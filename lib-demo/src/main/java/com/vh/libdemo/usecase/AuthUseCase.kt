package com.vh.libdemo.usecase

import com.vh.domain.states.SessionState
import kotlinx.coroutines.flow.StateFlow

interface AuthUseCase {
    val sessionStateObservable: StateFlow<SessionState>

    suspend fun getSessionState()
}