package com.memories.memories_recorder.feature.auth.data.repository

import com.memories.memories_recorder.feature.auth.data.remote.AuthApi
import com.memories.memories_recorder.feature.auth.data.remote.dto.AuthResponseDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.LoginRequestDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.RegisterRequestDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.RegisterResponseDto
import com.memories.memories_recorder.feature.auth.domain.repository.AuthRepository
import retrofit2.Response

class AuthRepositoryImpl(private val authApi: AuthApi): AuthRepository {

    override suspend fun login(request: LoginRequestDto): AuthResponseDto {
        val response = authApi.login(request)
        return response.requireBody()
    }

    override suspend fun register(request: RegisterRequestDto): RegisterResponseDto {
        val response = authApi.register(request)
        return response.requireBody()
    }

    private fun<T: Any> Response<T>.requireBody(): T {
        if(!isSuccessful) {
            throw AuthApiException(
                message = "Request failed with HTTP ${code()}()"
            )
        }

        return body() ?: throw AuthApiException("Server returned an empty response.")
    }
}

class AuthApiException(message: String): Exception(message)