package com.naufalprakoso.superheroapp.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.naufalprakoso.superheroapp.network.ApiResponse
import com.naufalprakoso.superheroapp.network.StatusResponse
import com.naufalprakoso.superheroapp.vo.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

abstract class NetworkBoundResource<ResultType, RequestType>
constructor(private val contextProviders: ContextProviders) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)
        val dbSource = loadFromDB()
        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    setValue(Resource.success(newData))
                }
            }
        }
    }

    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        result.addSource(dbSource) { newData ->
            setValue(Resource.loading(newData))
        }

        apiResponse?.let {
            result.addSource(it) { response ->
                result.removeSource(it)
                result.removeSource(dbSource)
                when (response.status) {
                    StatusResponse.SUCCESS -> {
                        GlobalScope.launch(contextProviders.io) {
                            saveCallResult(processResponse(response))
                            GlobalScope.launch(contextProviders.main) {
                                result.addSource(loadFromDB()) { newData ->
                                    setValue(Resource.success(newData))
                                }
                            }
                        }
                    }
                    StatusResponse.EMPTY -> {
                        GlobalScope.launch(contextProviders.main) {
                            result.addSource(loadFromDB()) { newData ->
                                setValue(Resource.success(newData))
                            }
                        }
                    }
                    StatusResponse.ERROR -> {
                        onFetchFailed()
                        result.addSource(dbSource) { newData ->
                            setValue(Resource.error(response.message.toString(), newData))
                        }
                    }
                }
            }
        }
    }

    protected open fun onFetchFailed() {}

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    abstract fun saveCallResult(data: RequestType)

    private fun processResponse(response: ApiResponse<RequestType>) = response.body

    abstract fun createCall(): LiveData<ApiResponse<RequestType>>?

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromDB(): LiveData<ResultType>
}