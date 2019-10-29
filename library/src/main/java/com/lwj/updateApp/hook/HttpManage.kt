package com.lwj.updateApp.hook

import com.lwj.updateApp.AppInfo
import com.lwj.updateApp.UpdateInfo

/**
 * @author by  LWJ
 * @date on 2019/10/28
 * @describe 添加描述
 */
interface HttpManage {
    fun getUpdateAppInfo(param: AppInfo,back:UpdateCallback):UpdateInfo
    fun downloadApp()
}