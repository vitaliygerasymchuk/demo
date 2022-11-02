package com.vh.domain.states

import com.vh.domain.User

sealed class SessionState {
    object Na : SessionState()
    object Loading : SessionState()
    data class Authenticated(val user: User) : SessionState()
    object Unauthenticated : SessionState()
}
