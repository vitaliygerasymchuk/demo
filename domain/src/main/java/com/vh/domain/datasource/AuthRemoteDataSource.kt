package com.vh.domain.datasource

import com.vh.domain.states.SessionState

interface AuthRemoteDataSource {
    suspend fun getSessionState(): SessionState
}