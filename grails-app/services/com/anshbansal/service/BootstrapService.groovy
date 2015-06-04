package com.anshbansal.service

import com.anshbansal.domain.User
import grails.transaction.NotTransactional
import grails.transaction.Transactional
import grails.util.Holders

class BootstrapService {

    @NotTransactional
    User createUser(String email) {
        new User(
                email: email,
                password: Holders.config.defaults.password
        )
    }
}
