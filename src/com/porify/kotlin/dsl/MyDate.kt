package com.porify.kotlin.dsl

import java.time.LocalDate
import java.time.Period

fun main(args: Array<String>) {

    val s = buildString {
        this.append("Hello, ")
        append("World.")
    }
    println(s)

    val dependencies = DependencyHandler()
    dependencies.compile("org.kotlin")
    dependencies {
        compile("org.kotlin")
        compile("org.android")
        compile("junit")
    }

    "StringTest".should(startWith("Str"))
//    "StringTest".should(startWith("str"))

    "StringTest" should startWith("String")

    println(1.days)
    println(1.days.ago)
    println(2.days.fromNow)
}

fun buildString(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

class DependencyHandler {
    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}

interface Matcher<T> {
    fun test(value: T)
}

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)

class startWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        if (!value.startsWith(prefix)) {
            throw AssertionError("String $value does not start with $prefix")
        } else {
            println("String $value is start witch $prefix")
        }
    }
}


val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this





















