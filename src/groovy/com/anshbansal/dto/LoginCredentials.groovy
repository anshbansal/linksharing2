package com.anshbansal.dto

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true)
class LoginCredentials {

    String email
    String password
}
