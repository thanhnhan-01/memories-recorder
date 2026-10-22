package com.memories.memories_recorder.feature.auth.domain.repository

import com.memories.memories_recorder.feature.auth.data.remote.dto.AuthResponseDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.LoginRequestDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.RegisterRequestDto
import com.memories.memories_recorder.feature.auth.data.remote.dto.RegisterResponseDto

interface AuthRepository {
    suspend fun login(
        request: LoginRequestDto
    ): AuthResponseDto

    suspend fun register(
        request: RegisterRequestDto
    ): RegisterResponseDto
}