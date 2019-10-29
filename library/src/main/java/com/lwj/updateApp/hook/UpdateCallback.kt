package com.lwj.updateApp.hook

interface UpdateCallback {
    fun before()
    fun after()
    fun queryResult(result:String)
    fun error(msg:String)
}