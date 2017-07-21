package com.example.cxh.kotlinstudy.kotlin.kt12_dagger2.module

import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton


@Module
class RxAdapterModule {

    @Singleton @Provides fun adapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()
}