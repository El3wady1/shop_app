package com.example.task

class Data {

    companion object {
        var users = mutableListOf<User>()
        var logeduser = User("", "", "", "", "")
    }
}


class User(
    var name: String,
    var email: String,
    var pass: String,
    var country: String,
    var phone: String
)
