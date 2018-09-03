package com.porify.kotlin.chapter5

import com.porify.kotlin.chapter4.Person

fun main(args: Array<String>) {

    val persons = listOf<Person>(Person("Zhangsan", 10000),
            Person("lisi", 11200), Person("wangwu", 14000),
            Person("wangmazi", 15000))
    println(persons)
    val maxSalary = persons.maxBy { it.salary }
    println(maxSalary)

    println(persons.maxBy(Person::salary))

    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    run(::salute)

    val person1 = Person("Zhaoliu", 14566)
    val personSalary = person1::salary
    println(personSalary())

//    val personSalaryEasy = Person::salary
//    println(personSalaryEasy())

    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    println(list.map { it * it })

    println(persons.filter { it.salary > 13000 })
    println(persons.map { it.name })
    println(persons.map(Person::salary))

    val filterAndMap = persons.filter { it.salary > 12000 }.map(Person::name)
    println(filterAndMap)

    val maxS = persons.maxBy { it.salary }!!.salary
    val maxS2 = persons.maxBy(Person::salary)!!.salary
    println(persons.filter { it.salary == maxS })

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers)
    println(numbers.mapValues { it.value.toUpperCase() })

    val sequeue1 = persons.map(Person::name).filter { it.startsWith("w") }
    println(sequeue1)

    val sequence = persons.asSequence()
            .map(Person::name)
            .filter { it.startsWith("w") }
            .toList()
    println(sequence)

    println(listOf(1, 2, 3, 4).asSequence()
            .map { println("map($it)"); it * it }
            .filter { println("filter($it)"); it % 2 == 0 }.toList())

    println(listOf(1, 2, 3, 4).asSequence()
            .map { it * it }.find { it > 3 })

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(naturalNumbers)
    println(numbersTo100)
    println(numbersTo100.sum())

    //postponeComputation(1000){println(42)}

    println(alphabet())
    println(alphabetWith())
    println(alphabetWithSimple())
    println(alphabetWithSimpleMore())

    println(alphabetApply()
    )

}

fun salute() = println("Salute!")

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet")
    return result.toString()
}


fun alphabetWith(): String {
    val result = StringBuilder()
    return with(result) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow is alphabetWith")
        this.toString()
    }
}

// 可以省略上一个方法中的this引用
fun alphabetWithSimple(): String {
    val result = StringBuilder()
    return with(result) {
        for (letter in 'a'..'z') {
            append(letter)
        }
        append("\n Now is alphabetWithSimple")
        toString()
    }
}

fun alphabetWithSimpleMore() = with(StringBuilder()) {
    for (letter in 'a'..'z') {
        append(letter)
    }
    append("\n Now is alphabetWithSimpleMore")
    toString()
}

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'a'..'z'){
        append(letter)
    }
    append("\n Now is alphabetApply")
    toString()
}
















