package com.memories.memories_recorder.feature.auth.data.repository

import android.content.Context
import com.memories.memories_recorder.core.network.RetrofitClient
import com.memories.memories_recorder.core.storage.TokenStorage
import com.memories.memories_recorder.feature.auth.domain.repository.AuthRepository

object AuthRepositoryProvider {

    val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authApi = RetrofitClient.authApi)
    }

    fun provideTokenStorage(context: Context): TokenStorage {
        return TokenStorage(context.applicationContext)
    }
}