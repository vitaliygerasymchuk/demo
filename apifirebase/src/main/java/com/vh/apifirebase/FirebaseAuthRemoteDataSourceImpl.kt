package com.vh.apifirebase

import androidx.lifecycle.DefaultLifecycleObserver
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.vh.common.Loggable
import com.vh.domain.User
import com.vh.domain.datasource.AuthRemoteDataSource
import com.vh.domain.states.SessionState
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FirebaseAuthRemoteDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRemoteDataSource, DefaultLifecycleObserver, Loggable {

    private val currentUser: FirebaseUser? get() = auth.currentUser

    override suspend fun getSessionState(): SessionState {
        if (currentUser != null) {
            log("getSessionState: refresh current user")
            currentUser?.reload()?.await()
            val refreshedUser = currentUser?.asAppUser
            log("getSessionState: done -> ${refreshedUser != null}")
            if (refreshedUser != null) {
                return SessionState.Authenticated(refreshedUser)
            }
        }else{
            log("getSessionState: no current user")
        }
        return SessionState.Unauthenticated
    }

    private val FirebaseUser.asAppUser
        get() = User(
            id = uid
        )
}