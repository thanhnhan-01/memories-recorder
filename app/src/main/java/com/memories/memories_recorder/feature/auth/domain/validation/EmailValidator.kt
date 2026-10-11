package com.memories.memories_recorder.feature.auth.domain.validation

object EmailValidator {
    fun validate(email: String): String? {
        val normalizedEmail = email.trim()

        if(normalizedEmail.isBlank()) {
            return "Email is required."
        }

        val emailPattern = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

        if(!emailPattern.matches(normalizedEmail) ) {
            return "Please enter a valid email address"
        }

        return null
    }
}