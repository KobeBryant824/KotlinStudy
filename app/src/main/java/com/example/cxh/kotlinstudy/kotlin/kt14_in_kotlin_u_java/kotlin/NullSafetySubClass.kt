package com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.kotlin

import com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.java.NullSafetyAbsClass
import java.util.*


class NullSafetySubClass : NullSafetyAbsClass(){
    override fun formatDate(date: Date): String {
        return date.toString()
    }
}

fun main(args: Array<String>) {
    val nullSafetySubClass = NullSafetySubClass()

    println(nullSafetySubClass.formatDate(Date()))

    println(nullSafetySubClass.formatTime(Date()))
}