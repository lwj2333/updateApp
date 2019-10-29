package com.lwj.updateApp


import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.lwj.updateApp.hook.HttpManage
import com.lwj.updateApp.hook.UpdateCallback
import java.io.File
import java.util.*
import javax.xml.transform.Templates

/**
 * @author by  LWJ
 * @date on 2019/10/28
 * @describe 添加描述
 */
class UpdateAppManage{
private constructor(
    context: Context,
    param: AppInfo,
    manage: HttpManage?,back:UpdateCallback?
) {
    callback = back
        ?: object :UpdateCallback{
            override fun before() {

            }
            override fun after() {

            }
            override fun queryResult(result: String) {

            }
            override fun error(msg:String) {

            }
        }


       httpManage = manage ?: HttpManageUtil()
       httpManage?.getUpdateAppInfo(param,callback!!)


}

    var context: Context? = null
    var param: AppInfo? = null
    var httpManage: HttpManage? = null
   var  callback: UpdateCallback ?=null




    companion object {
        fun installApp() {}
        fun getVersionName(context: Context): String {
            val packageInfo = getPackageInfo(context)
            return if (packageInfo != null) {
                packageInfo.versionName
            } else ""
        }
        fun getPackageInfo(context: Context): PackageInfo? {
            try {
                return context.packageManager.getPackageInfo(context.packageName, 0)
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return null
        }
    }

    private val TAG = "UpdateAppManage"

    class Builder {
        var param: AppInfo? = null
        var context: Context? = null
        var httpManage: HttpManage? = null
        var callback:UpdateCallback?=null
        fun setParam(param: AppInfo): Builder {
            this.param = param
            return this
        }

        fun setHttpManage(httpManage: HttpManage): Builder {
            this.httpManage = httpManage
            return this
        }

        fun setContext(context: Context): Builder {
            this.context = context
            return this
        }
     fun setUpdateCallback(callback: UpdateCallback):Builder{
         this.callback = callback
         return this
     }
        fun builder(): UpdateAppManage {
              if (context==null){
                  throw NullPointerException("context not null")
              }
            if (param==null){
                throw NullPointerException("param not null")
            }


            return UpdateAppManage(context!!,param!!,httpManage,callback)
        }
    }



}