package com.example.cxh.kotlinstudy.kotlin.kt12_dagger2

import dagger.Component
import com.example.cxh.kotlinstudy.kotlin.kt12_dagger2.module.RetrofitModule
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(RetrofitModule::class))
interface RESTFulComponent {
    fun retrofit(): Retrofit
}