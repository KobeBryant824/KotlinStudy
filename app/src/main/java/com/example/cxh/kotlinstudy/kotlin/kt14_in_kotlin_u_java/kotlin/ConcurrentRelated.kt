package com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.kotlin


@Volatile var count: Int = 0

fun count(){
    synchronized(count){
        count++
    }
}

