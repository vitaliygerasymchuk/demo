package com.vh.libdemo.di

import com.vh.libdemo.usecase.AuthUseCase
import com.vh.libdemo.usecase.AuthUseCaseImpl
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    fun providesAuthUseCase(): AuthUseCase {
        return AuthUseCaseImpl()
    }
}