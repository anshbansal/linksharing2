package com.anshbansal.service

import com.anshbansal.domain.User
import com.anshbansal.dto.LoginCredentials
import grails.transaction.NotTransactional


class AuthService {

    @NotTransactional
    Boolean loginAuth(LoginCredentials credentials) {
        User foundUser = User.findByEmailAndPassword(credentials.email, credentials.password)

        log.debug "For login credentials $credentials user was $foundUser"

        foundUser ? true : false
    }
}
