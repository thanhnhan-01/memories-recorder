package com.memories.memories_recorder.feature.auth.data.remote.dto

data class AuthResponseDto(
    val accessToken: String,
    val refreshToken: String,
    val user: UserSummaryDto
)