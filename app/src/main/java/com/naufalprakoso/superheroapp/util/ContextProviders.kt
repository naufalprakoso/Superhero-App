package com.naufalprakoso.superheroapp.util

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class ContextProviders {
    open val main: CoroutineContext = Dispatchers.Main
    open val io: CoroutineContext = Dispatchers.IO

    companion object {
        @Volatile
        private var INSTANCE: ContextProviders? = null

        fun getInstance(): ContextProviders {
            return INSTANCE ?: synchronized(this) {
                ContextProviders()
            }.also {
                INSTANCE = it
            }
        }
    }
}