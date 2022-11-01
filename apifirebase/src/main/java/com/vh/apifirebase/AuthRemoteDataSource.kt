package com.vh.apifirebase

import com.vh.domain.states.SessionState

interface AuthRemoteDataSource {
    suspend fun getSessionState(): SessionState
}