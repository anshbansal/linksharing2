package com.anshbansal.service

import com.anshbansal.domain.User
import com.anshbansal.dto.LoginCredentials
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@Mock(User)
@TestFor(AuthService)
class AuthServiceSpec extends Specification {

    void "test that only valid login credentials are authenticated"() {

        setup: "Add one user"
        User user = new User(email: config.defaults.email, password: config.defaults.password)
        user.save()

        and: "Get valid and invalid credentials"

        LoginCredentials validCredentials = LoginCredentials.credentialsForEmail(user)
        LoginCredentials invalidCredentials = LoginCredentials.emptyCredentials

        expect: "Valid credentials are authenticated"
        service.loginAuth(validCredentials)

        and:
        ! service.loginAuth(invalidCredentials)

    }
}
