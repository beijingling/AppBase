package com.ling.commonlib

import android.app.Application
import android.content.Context
import android.content.res.Resources

/**
 * APPLICATION
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    /**
     * @param base
     */
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    companion object {
        @get:Synchronized
        var instance: BaseApplication? = null
            private set
        val appContext: Context?
            get() = instance
        val appResources: Resources
            get() = instance!!.resources
    }
}
