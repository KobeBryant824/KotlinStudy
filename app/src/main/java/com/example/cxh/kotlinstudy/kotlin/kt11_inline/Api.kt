package com.example.cxh.kotlinstudy.kotlin.kt11_inline

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Proxy


interface Api {
    fun getSingerFromJson(json: String): BaseResult<Singer>
}

object ApiFactory {
    val api: Api by lazy {
        Proxy.newProxyInstance(ApiFactory.javaClass.classLoader, arrayOf(Api::class.java)) {
            proxy, method, args ->
            val responseType = method.genericReturnType
            val adapter = Gson().getAdapter(TypeToken.get(responseType))
            adapter.fromJson(args[0].toString())
        } as Api
    }
}