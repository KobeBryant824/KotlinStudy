package com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.kotlin

import com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.java.NullSafetyJava


fun main(args: Array<String>) {
    val nullSafetyJava = NullSafetyJava()

    val dataCanBeNull: String? = nullSafetyJava.data
    println(dataCanBeNull)

    val data: String = nullSafetyJava.data
    println(data)
}