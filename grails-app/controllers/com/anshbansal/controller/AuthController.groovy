package com.anshbansal.controller

import com.anshbansal.dto.LoginCredentials

class AuthController {

    def authService

    Boolean loginAuth(LoginCredentials credentials) {
        render(contentType: 'application/json') {
            isValid = authService.loginAuth(credentials)
        }
    }
}
