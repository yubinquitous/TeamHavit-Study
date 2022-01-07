package com.example.havit

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication :Application() {

    companion object
    {
        var instance: MainApplication? = null
    }

    override fun onCreate()
    {
        super.onCreate()

        KakaoSdk.init(this, "6069fb41c205cbbf8f213b32eec7f2c8")
        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@MainApplication)
            // use modules
            //modules(myViewModel, myModule)
        }
    }

    override fun onTerminate()
    {
        super.onTerminate()
        instance = null
    }

    fun getMainApplicationContext(): MainApplication
    {
        checkNotNull(instance) { "this application does not inherit com.kakao.MainApplication" }
        return instance!!
    }
}