package com.example.cxh.kotlinstudy.kotlin.kt12_dagger2.module

import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class GsonConverterModule {
    @Singleton @Provides fun converter(): Converter.Factory = GsonConverterFactory.create()
}