package com.anshbansal.domain

class User {

    String email
    String password

    static constraints = {
        email unique: true, email: true
    }
}
