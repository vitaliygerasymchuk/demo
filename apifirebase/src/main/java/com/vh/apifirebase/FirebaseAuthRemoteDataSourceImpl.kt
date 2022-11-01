package com.vh.apifirebase

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.vh.common.Loggable
import com.vh.domain.User
import com.vh.domain.states.SessionState
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseAuthRemoteDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRemoteDataSource, DefaultLifecycleObserver, Loggable {

    private val currentUser: FirebaseUser? get() = auth.currentUser

    private val processLifecycle by lazy {
        ProcessLifecycleOwner.get().lifecycle
    }

    init {
        processLifecycle.addObserver(this)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        log("onStart: $owner")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        processLifecycle.removeObserver(this)
        log("onDestroy: $owner")
    }

    override suspend fun getSessionState(): SessionState {
        if (currentUser != null) {
            currentUser?.reload()?.await()
            val refreshedUser = currentUser?.asAppUser
            if (refreshedUser != null) {
                return SessionState.Authenticated(refreshedUser)
            }
        }
        return SessionState.Unauthenticated
    }

    private val FirebaseUser.asAppUser
        get() = User(
            id = uid
        )
}