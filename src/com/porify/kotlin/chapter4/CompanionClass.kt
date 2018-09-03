package com.porify.kotlin.chapter4

fun main(args: Array<String>) {

    val subscribingUser = CompanionUser.newSubscribingUser("bob@gmail.com")
    val accountUser = CompanionUser.newAccountUser(4444)
    println(subscribingUser.nickname)
    println(accountUser.nickname)

    val person = PersonUtil.fromJson("Zhangsan@10000")
    println(person)

    val Wangwu = loadFromJson(PersonUtil.PersonFactor, "WangWu@123456")
    println(Wangwu)

    val lisi = loadFromJson(PersonUtil, "lisi@20000")
    println(lisi)


    val zhaoLiu = PersonUtil.fromXml("Zhaoliu/24680")
    println(zhaoLiu)
    zhaoLiu.changeSalary(98999)

}

class NormalUser {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBeforeLast('@')
    }

    constructor(accountId: Int) {
        nickname = getNickname(accountId)
    }

    private fun getNickname(accountId: Int) = "$accountId"
}

class CompanionUser private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = CompanionUser(email.substringBeforeLast('@'))

        fun newAccountUser(accountId: Int) = CompanionUser(getNickname(accountId))

        private fun getNickname(accountId: Int) = "nickname is $accountId"
    }
}

interface JsonFactory<T> {
    fun fromJson(jsonText: String): T
}

class PersonUtil {
    companion object PersonFactor : JsonFactory<Person> {
        override fun fromJson(jsonText: String) = Person(jsonText.getPersonName(), jsonText.getPersonSalary())
    }
}

private fun String.getPersonSalary(separator: String = "@") = substringAfterLast(separator).toInt()
private fun String.getPersonName(separator: String = "@") = substringBeforeLast(separator)

fun <T> loadFromJson(factory: JsonFactory<T>, jsonText: String): T {
    return factory.fromJson(jsonText)
}

fun PersonUtil.PersonFactor.fromXml(xmlText: String) : Person {
    return Person(xmlText.getPersonName("/"), xmlText.getPersonSalary("/"))
}
