package com.memories.memories_recorder.feature.auth.data.remote

import com.memories.memories_recorder.feature.auth.data.remote.dto.AuthResponseDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.LoginRequestDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.RegisterRequestDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.RegisterResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api/v1/auth/login")
    suspend fun login(
        @Body request: LoginRequestDto
    ): Response<AuthResponseDto>

    @POST("api/v1/auth/register")
    suspend fun register(
        @Body request: RegisterRequestDto
    ): Response<RegisterResponseDto>
}