package com.lwj.updateApp

/**
 * @author by  LWJ
 * @date on 2019/10/28
 * @describe 添加描述
 */
/**
 * @param version 版本号
 * @param constraint 是否强制更新 0 否  1  是
 * @param updateUrl app更新下载链接
 */
open class UpdateInfo (var isUpadate:Boolean,var version:String,
                       var constraint:Int,var updateUrl:String)