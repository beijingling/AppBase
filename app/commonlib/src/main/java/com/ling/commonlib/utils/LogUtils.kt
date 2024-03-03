package com.ling.commonlib.utils

import com.orhanobut.logger.AndroidLogAdapter

/**
 * 如果用于android平台，将信息记录到“LogCat”。如果用于java平台，将信息记录到“Console”
 * 使用logger封装
 */
object LogUtils {
    var DEBUG_ENABLE = true // 是否调试模式

    /**
     * 在application调用初始化
     */
    fun logInit(debug: Boolean) {
        val formatStrategy: FormatStrategy =
            PrettyFormatStrategy.newBuilder().showThreadInfo(false) // 是否显示线程信息，默认为ture
                .methodCount(0)
                .tag("commonApp") // 每个日志的全局标记。默认PRETTY_LOGGER
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
        DEBUG_ENABLE = debug
    }

    fun logd(message: String?, vararg args: Any?) {
        if (DEBUG_ENABLE) {
            Logger.d(message, args)
        }
    }

    fun logd(message: Any?) {
        if (DEBUG_ENABLE) {
            Logger.d(message)
        }
    }

    fun loge(throwable: Throwable?, message: String?, vararg args: Any?) {
        if (DEBUG_ENABLE) {
            Logger.e(throwable, message, args)
        }
    }

    fun loge(message: String?, vararg args: Any?) {
        if (DEBUG_ENABLE) {
            Logger.e(message, args)
        }
    }

    fun logi(message: String?, vararg args: Any?) {
        if (DEBUG_ENABLE) {
            Logger.i(message, args)
        }
    }

    fun logv(message: String?, vararg args: Any?) {
        if (DEBUG_ENABLE) {
            Logger.v(message, args)
        }
    }

    fun logw(message: String?, vararg args: Any?) {
        if (DEBUG_ENABLE) {
            Logger.v(message, args)
        }
    }

    fun logwtf(message: String?, vararg args: Any?) {
        if (DEBUG_ENABLE) {
            Logger.wtf(message, args)
        }
    }

    fun logjson(message: String?) {
        if (DEBUG_ENABLE) {
            Logger.json(message)
        }
    }

    fun logxml(message: String?) {
        if (DEBUG_ENABLE) {
            Logger.xml(message)
        }
    }
}
