package com.anshbansal.domain

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, includePackage = false, excludes = 'password')
class User {

    String email
    String password

    static constraints = {
        email unique: true, email: true
    }
}
