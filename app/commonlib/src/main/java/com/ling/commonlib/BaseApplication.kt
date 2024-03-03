package com.ling.commonlib

import android.app.Application
import android.content.Context
import android.content.res.Resources

class BaseApplication : Application() {
    //伴生对象，相当于Java中的static
    companion object {
        lateinit var baseApplication: BaseApplication
        fun getAppContext(): Context {
            return baseApplication
        }

        fun getAppResources(): Resources {
            return baseApplication.resources
        }

        fun getInstance(): BaseApplication {
            return baseApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        baseApplication = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}