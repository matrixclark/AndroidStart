package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityStack.add(this)
    }

    fun finishActivity(simpleName: String) {
        for (activity in activityStack) {
            if (activity.javaClass.getSimpleName() == simpleName) {
                activity.finish()
                activityStack.remove(activity)
                break
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activityStack.remove(this)
    }

    companion object {
        //存放activity的栈
        val activityStack = Stack<Activity>()

        fun put(a: Activity) {
            activityStack.add(a)
        }
        /**
         * 结束所有的Activity
         */
        fun finishAll() {
            while (!activityStack.empty()) {
                activityStack.pop().finish()
            }
        }
    }


}