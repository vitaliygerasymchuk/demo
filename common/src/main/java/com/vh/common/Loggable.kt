package com.vh.common

import android.util.Log

interface Loggable {
    fun log(msg: String) {
        Log.d(this::class.simpleName, msg)
    }
}