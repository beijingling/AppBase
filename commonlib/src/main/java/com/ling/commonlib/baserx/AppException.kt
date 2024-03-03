package com.ling.commonlib.baserx

//自定义一个异常类
class AppException : Exception {
    @JvmField
    var code: String? = null

    constructor(msg: String?) : super(msg)
    constructor(msg: String?, code: String?) : super(msg) {
        this.code = code
    }
}
