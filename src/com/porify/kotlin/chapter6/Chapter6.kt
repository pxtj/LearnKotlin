package com.porify.kotlin.chapter6

import java.io.BufferedReader


fun main(args: Array<String>) {
    printAllCaps("adb")
    printAllCaps(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Simth", ceo)
    println(managerName(ceo))
    println(managerName(developer))

    println(strLenSafe("abc"))
    println(strLenSafe(null))

    val address = Address("elsestr.47", 80867, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmity", jetbrains)
    printShippingLabel(person)

    //printShippingLabel(Person("Alex", null))
    ignoreNulls("dfasdf")
//    ignoreNulls(null)

    sendEmailTo("test@gmail.com")
    val email: String? = "test_null@gmail.com"
    email?.let { sendEmailTo(it) }

    verifyUserInput("  ")
    verifyUserInput(null)

}

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name
fun foo(s: String?) {
    val t: String = s ?: ""
}

fun strLenSafe(s: String?): Int = s?.length ?: 0

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun printShippingLabel(person: Person) {
    val address = person?.company?.address
            ?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

class PersonForName(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? PersonForName ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int {
        return firstName.hashCode() + 37 * lastName.hashCode()
    }
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
        // or use :
        //result.add(line.toIntOrNull())
    }
    return result
}

fun addValueNumbers(numbers: List<Int?>) {

    var sumOfValueNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) {
            sumOfValueNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("Sum of valid numbers: $sumOfValueNumbers")
    println("invalid numbers: $invalidNumbers")
}

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}





























