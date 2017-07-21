package com.example.cxh.kotlinstudy.kotlin.kt11_inline


data class BaseResult<Content>(val code: Int, val message: String, val content: Content)

data class Song(val id: Long, val name: String)

data class Singer(val id: Long, val name: String, val songs: List<Song>)
