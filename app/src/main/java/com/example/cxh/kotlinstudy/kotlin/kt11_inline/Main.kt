package com.example.cxh.kotlinstudy.kotlin.kt11_inline

import java.io.File


fun main(args: Array<String>) {
    val json = File("result_singer_field_loss.json").readText()
    val result : BaseResult<Singer> = ApiFactory.api.getSingerFromJson("")
    println(result.content.name.isEmpty())
}
