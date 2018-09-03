package com.porify.kotlin


class User(val id: Int, val name: String, val address: String)

fun saveUser1(user: User) {

    if (user.name.isEmpty()) {
        print("Can't save user ${user.id}: empty name")
    }
    if (user.address.isEmpty()) {
        println("Can't save user ${user.id}: empty address")
    }

    println("will save user ${user.id}")
}

fun saveUser2(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            println("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user, user.name, "name")
    validate(user, user.address, "address")

    println("Will save user ${user.id}")
}

fun saveUser3(user: User) {
    fun validate(value: String, fieldName: String){
        if (value.isEmpty()){
            println("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user.name, "name")
    validate(user.address, "address")

    println("Will save user ${user.id}")
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String){
        println("Can't save user $id: empty $fieldName")
    }
    validate(name, "name")
    validate(address, "address")
}

fun saveUser4(user: User){
    user.validateBeforeSave()
    println("Will save user ${user.id}")
}
