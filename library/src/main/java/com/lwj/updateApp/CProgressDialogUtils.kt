package com.lwj.updateApp

import android.app.Activity
import android.content.Context
import android.widget.ProgressBar

class CProgressDialogUtils{
        private var dialog :ProgressBar?=null

    companion object{
        fun showDialog(activity: Activity?){
            if (activity==null||activity.isFinishing)return
            var dialog = ProgressBar(activity)

        }
        fun cancelDialog(){

        }
    }

}