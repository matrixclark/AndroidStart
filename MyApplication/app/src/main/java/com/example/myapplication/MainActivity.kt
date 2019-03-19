package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        val data = intent.getIntExtra("data",0)

        Log.d("MainActivity", data.toString())
    }


    companion object{
        fun start(activty: AppCompatActivity, data: Int) {
            val intent = Intent(activty, MainActivity::class.java)
            intent.putExtra("data", data)
            activty.startActivity(intent)
        }
    }
}

