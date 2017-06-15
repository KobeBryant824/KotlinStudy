package com.example.cxh.kotlinstudy.util

import com.example.cxh.kotlinstudy.kotlin.kt02_dataclass.User


/**
 * Desc: 单例
 * Created by Hai (haigod7@gmail.com) on 2017/6/2 16:28.
 */
object KotlinSingleton {
    private val USER = User(28,"kobe")
    fun getData() {}
    fun getInstance() = USER
}