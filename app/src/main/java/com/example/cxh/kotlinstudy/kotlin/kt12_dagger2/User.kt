package com.example.cxh.kotlinstudy.kotlin.kt12_dagger2


data class User(val login: String, val id: Long, val avatar_url: String){
    override fun toString(): String {
        return login
    }
}