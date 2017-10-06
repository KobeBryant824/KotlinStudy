package com.example.cxh.kotlinstudy.kotlin

fun main(args: Array<String>) {
    val person: Person? = Person()
    println(person)

    //java
    if (null != person) {
        person.name = "kobe"
        person.age = 38
        println(person)
    }

    //to kotlin
    person?.let {
        person.name = "kobe"
        person.age = 38
        println(person)
    }

}

data class Person(var name: String? = null, var age: Int = 0)