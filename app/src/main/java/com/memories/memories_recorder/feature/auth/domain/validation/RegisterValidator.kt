package com.memories.memories_recorder.feature.auth.domain.validation

object RegisterValidator {

    fun validateUsername(username: String): String? {
        if(username.isBlank()) {
            return "Username is required"
        }

        return null
    }

    fun validateEmail(email: String): String? {
        return EmailValidator.validate(email)
    }

    fun validatePassword(password: String): String? {
        if(password.isBlank()) {
            return "Password is required"
        }

        if(password.length < 8) {
            return "Password must be at least 8 characters"
        }

        return null;
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): String? {
        if(confirmPassword.isBlank()) {
            return "Please confirm your password."
        }

        if(password != confirmPassword) {
            return "Passwords does not match."
        }

        return null
    }
}