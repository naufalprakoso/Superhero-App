package com.naufalprakoso.superheroapp.util

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class ContextProviders {
    val main: CoroutineContext = Dispatchers.Main
    val io: CoroutineContext = Dispatchers.IO
}