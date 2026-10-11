package com.memories.memories_recorder.feature.auth.domain.validation

object PasswordValidator {
    fun validate(password: String): String? {
        if(password.isBlank()) {
            return "Password is required."
        }

        return null
    }
}