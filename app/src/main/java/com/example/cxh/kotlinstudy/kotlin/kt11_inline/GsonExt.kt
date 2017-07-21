package com.example.cxh.kotlinstudy.kotlin.kt11_inline

import com.google.gson.Gson

inline fun <reified T: Any> Gson.fromJson(json: String): T{
    return fromJson(json, T::class.java)
}