package com.naufalprakoso.superheroapp.util

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.data.source.remote.ApiResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

class LiveDataCallAdapter<R>(private val responseType: Type) :
    CallAdapter<R, LiveData<ApiResponse<R>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>() {
            private var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            response.body()?.let {
                                postValue(ApiResponse.success(it))
                            }
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                        }
                    })
                }
            }
        }
    }
}