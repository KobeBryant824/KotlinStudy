package com.example.cxh.kotlinstudy.kotlin.kt01_main


fun main(args: Array<out String>) {
    println("Hello World!!")
    println(Main(0, "Kotlin"))
    println(Main1(0, "Kotlin"))
}

class Main(val id: Int, val title: String) {
    override fun toString(): String {
        return "$id - $title"  // $字符串模版
    }
}

data class Main1(val id: Int, val name: String)