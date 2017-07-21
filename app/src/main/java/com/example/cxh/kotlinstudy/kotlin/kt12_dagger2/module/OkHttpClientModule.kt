package com.example.cxh.kotlinstudy.kotlin.kt12_dagger2.module

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module(includes = arrayOf(CacheModule::class))
class OkHttpClientModule {
    @Singleton @Provides fun okHttpClient(cache: Cache): OkHttpClient
            = OkHttpClient.Builder().cache(cache).build()
}