package com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.kotlin

import com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.java.SAMInJava


fun main(args: Array<String>) {

    val samInJava = SAMInJava()
    val lambda = {
        println("Hello")
    }

    samInJava.addTask(lambda)
    samInJava.addTask(lambda)
    samInJava.addTask(lambda)
    samInJava.addTask(lambda)
    samInJava.addTask(lambda)

    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
}