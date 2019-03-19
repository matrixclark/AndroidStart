package com.example.myapplication

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.support.v7.app.AlertDialog
//import android.support.design.widget;
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.View
import android.widget.Button;


import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private val TAG = SecondActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }



        val mButton = findViewById(R.id.btn) as Button
        //设置点击事件监听
        mButton.setOnClickListener(View.OnClickListener {
            //响应点击事件,启动MainActivity
//            val intent = Intent(this@SecondActivity, MainActivity::class.java)
//            startActivity(intent)


           // val intent = Intent()
           // intent.action = "com.test.filter"
           // intent.putExtra("data", "这是我传的参数")
            //startActivity(intent)

           // MainActivity.start(this,12)


            val dialog = AlertDialog.Builder(this)
                //设置对话框标题
                .setTitle("提示")
                //设置对话框图标
                .setIcon(R.mipmap.ic_launcher)
                //设置对话框提示内容
                .setMessage("这里是提示内容。")
                //确定按钮
                .setPositiveButton("确定") { dialog, which ->
                    //处理点击确定后的操作
                }
                .setNeutralButton("帮助") { dialog, which -> }
                //取消按钮
                .setNegativeButton("取消") { dialog, which ->
                    //处理点击取消后的操作
                    dialog.dismiss()//让对话框消失
                }.create()//创建对话框
            dialog.show() //显示对话框

        })
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val saveData = "save data"
        outState.putString("key", saveData)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val getData = savedInstanceState.getString("key")
        Log.d(TAG, getData)
    }


}
