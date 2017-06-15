package com.example.cxh.kotlinstudy.kotlin.kt07_retrofit


data class User(val login: String, val id: Long, val avatar_url: String){
    override fun toString(): String {
        return login
    }
}