package com.vh.apifirebase.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vh.apifirebase.FirebaseAuthRemoteDataSourceImpl
import com.vh.domain.datasource.AuthRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Singleton
    @Provides
    fun providesFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }

    @Singleton
    @Provides
    @FirebaseAuthRemoteDataSource
    fun providesFirebaseAuthRemoteDataSource(
        auth: FirebaseAuth
    ): AuthRemoteDataSource {
        return FirebaseAuthRemoteDataSourceImpl(auth)
    }
}