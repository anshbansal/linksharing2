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

        when: "Valid credentials are authenticated"
        Boolean statusForValidCredentials = service.loginAuth(LoginCredentials.credentialsForEmail(user))

        then:
        statusForValidCredentials
    }

    void "test that invalid login credentials are not authenticated"() {
        when: "Invalid credentials are authenticated"
        Boolean statusForInvalidCredentials = service.loginAuth(LoginCredentials.emptyCredentials)

        then:
        statusForInvalidCredentials != null
        ! statusForInvalidCredentials
    }
}
