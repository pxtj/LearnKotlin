package com.porify.kotlin.chapter4

interface Clickable {
    fun click()
    fun showOff() = println("I am Clickable")
}

interface Focusable {
    fun setFocusable(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I am Focusable")
}

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked.")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

open class RichButton : Clickable {
    fun disable() {}
    open fun animate() {}
    override fun click() {}
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}

internal open class TalktiveButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let us talk.")
}

internal fun TalktiveButton.giveSpeech() {
    //yell()
    //whisper()
}

fun main(args: Array<String>) {
    val button = Button()
    button.click()
    button.setFocusable(true)
    button.showOff()

    val user = UserClass("Alice")
    user.address = "huayang"
    user.address = "shuangliu"

    val lengthCounter  = LengthCounter()
    lengthCounter.addWord("Chengdu")
    //lengthCounter.counter = 33 //error
    println("${lengthCounter.counter}")

}

interface User {
    val nickName: String
    val address: String get() = nickName
}

class PrivateUser(override val nickName: String) : User

fun PrivateUser.changeNickname(nickName: String) {
    println("new nickname is $nickName")
}

class SubscribingUser(val email: String) : User {
    override val nickName: String
        get() = email.substringBeforeLast('@')
}

class FacebookUser(val accountId: Int) : User {
    override val nickName: String
        get() = getFacebookCountId()

    private fun getFacebookCountId(): String = "$accountId"
}

class UserClass(val name: String) {
    var address: String = "unspecified"
        set(value) {
            println("""Address was changed for $name: "$field"->"$value".""".trimIndent())
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter = word.length
    }

}



























