package com.anshbansal.dto

import com.anshbansal.domain.User
import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true)
class LoginCredentials {

    String email
    String password

    static LoginCredentials getEmptyCredentials() {
        new LoginCredentials()
    }

    static LoginCredentials credentialsForEmail(User user) {
        new LoginCredentials(email: user.email, password: user.password)
    }
}
