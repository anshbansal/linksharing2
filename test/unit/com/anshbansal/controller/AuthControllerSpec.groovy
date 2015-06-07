package com.anshbansal.controller

import com.anshbansal.dto.LoginCredentials
import com.anshbansal.service.AuthService

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(AuthController)
class AuthControllerSpec extends Specification {

    void "test that isValid is sent as true for correct credentials"() {

        setup: "Set authService to return true"
        controller.authService = Mock(AuthService) {
            1 * loginAuth(_ as LoginCredentials) >> true
        }

        when:
        controller.loginAuth(new LoginCredentials())

        then:
        response.contentAsString == '{"isValid":true}'
    }

    void "test that isValid is sent as false for incorrect credentials"() {

        setup: "Set authService to return true"
        controller.authService = Mock(AuthService) {
            1 * loginAuth(_ as LoginCredentials) >> false
        }

        when:
        controller.loginAuth(new LoginCredentials())

        then:
        response.contentAsString == '{"isValid":false}'
    }
}
