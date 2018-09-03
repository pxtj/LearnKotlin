package com.porify.kotlin.chapter4

import java.io.File


fun main(args: Array<String>) {

    val persons = arrayListOf(Person("Zhangsan", 10000),
            Person("lisi", 12000))
    Payroll.allEmployee.addAll(persons)
    Payroll.calculateSalary()

    println(persons.sortedWith(Person.NameComparator))
    println(persons.sortedWith(Person.SalaryComparator))

    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}

object Payroll {
    val allEmployee = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployee) {
            println(person)
        }
    }
}

data class Person(val name: String, val salary: Int) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person?, o2: Person?) = o1!!.name.compareTo(o2!!.name, ignoreCase = true)
    }

    object SalaryComparator : Comparator<Person> {
        override fun compare(o1: Person?, o2: Person?) = o1!!.salary.compareTo(o2!!.salary)
    }
}

fun Person.changeSalary(salary: Int) {
    println("$this, new Salary is $salary")
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File?, o2: File?): Int {
        return o1!!.path.compareTo(o2!!.path, ignoreCase = true)
    }
}



















