package com.anshbansal.service

import com.anshbansal.domain.User
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(BootstrapService)
class BootstrapServiceSpec extends Specification {


    void "test create user"() {
        when:
        User user = service.createUser("test")

        then:
        user.email == "test"
        user.password == "igdefault"

        and:
        false
    }
}
