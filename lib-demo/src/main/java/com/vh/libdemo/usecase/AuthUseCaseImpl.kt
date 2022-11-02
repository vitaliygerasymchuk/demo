package com.vh.libdemo.usecase

import com.vh.common.Loggable
import com.vh.domain.datasource.AuthRemoteDataSource
import com.vh.domain.states.SessionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class AuthUseCaseImpl(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthUseCase, Loggable {

    private val _sessionStateObservable = MutableStateFlow<SessionState>(SessionState.Na)
    override val sessionStateObservable: StateFlow<SessionState> = _sessionStateObservable

    override suspend fun getSessionState() {
        log("getSessionState: start")
        _sessionStateObservable.value = SessionState.Loading
        _sessionStateObservable.value = authRemoteDataSource.getSessionState()
        log("getSessionState: done")
    }
}