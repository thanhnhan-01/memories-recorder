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

    private fun <T : Any> Response<T>.requireBody(): T {
        if (!isSuccessful) {
            val errorMessage = parseErrorMessage()
            throw AuthApiException(
                message = errorMessage,
                statusCode = code()
            )
        }

        return body()
            ?: throw AuthApiException(
                message = "Server returned an empty response.",
                statusCode = code()
            )
    }

    private fun <T : Any> Response<T>.parseErrorMessage(): String {
        val rawBody = errorBody()?.string()
            ?: return "Request failed with HTTP ${code()}"

        return try {
            val json = org.json.JSONObject(rawBody)

            when {
                json.has("message") -> json.optString("message")
                json.has("detail") -> json.optString("detail")
                json.has("error") -> json.optString("error")
                else -> "Request failed with HTTP ${code()}"
            }
        } catch (_: Exception) {
            "Request failed with HTTP ${code()}"
        }
    }
}

class AuthApiException(message: String, val statusCode: Int? = null): Exception(message)