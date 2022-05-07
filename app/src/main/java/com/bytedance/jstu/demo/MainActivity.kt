package com.bytedance.jstu.demo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.bytedance.jstu.demo.Homework.Chapter2Activity

class MainActivity : AppCompatActivity() {

    private val btnChapter2 by lazy {
        findViewById<Button>(R.id.main_btn_chapter2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBtnClickEvent(btnChapter2, Chapter2Activity())
    }

    fun setBtnClickEvent(btn: Button, activity: Activity) {
        btn.setOnClickListener(View.OnClickListener {
            var intent = Intent()
            intent.setClass(this, activity::class.java)
            startActivity(intent)
        })
    }

}