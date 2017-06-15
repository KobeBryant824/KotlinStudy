package com.example.cxh.kotlinstudy.kotlin.kt02_dataclass


fun main(args: Array<out String>){
    val user = User(0, "Kotlin")
    println(user)

    HelloKotlin::class.constructors.map(::println)
}


class HelloKotlin{
    fun hello(){

    }
}