package com.example.cxh.kotlinstudy.kotlin.kt12_dagger2.module

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import java.io.File
import javax.inject.Singleton


@Module
class CacheModule {
    companion object{
        const val CACHE_DIR = "./cache"
        const val CACHE_SIZE = 10 * 1024 * 1024L
    }

    @Singleton @Provides fun cache(): Cache = Cache(File(CACHE_DIR), CACHE_SIZE)
}