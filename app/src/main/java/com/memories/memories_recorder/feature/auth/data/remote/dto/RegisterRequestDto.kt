package com.memories.memories_recorder.feature.auth.data.remote.dto

data class RegisterRequestDto(
    val email: String,
    val username: String,
    val password: String,
    val confirmPassword: String
)