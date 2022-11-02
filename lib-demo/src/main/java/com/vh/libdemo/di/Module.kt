package com.vh.libdemo.di

import com.vh.apifirebase.di.FirebaseAuthRemoteDataSource
import com.vh.domain.datasource.AuthRemoteDataSource
import com.vh.libdemo.usecase.AuthUseCase
import com.vh.libdemo.usecase.AuthUseCaseImpl
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun providesAuthUseCase(
        @FirebaseAuthRemoteDataSource
        firebaseAuthRemoteDataSource: AuthRemoteDataSource
    ): AuthUseCase {
        return AuthUseCaseImpl(
            firebaseAuthRemoteDataSource
        )
    }
}