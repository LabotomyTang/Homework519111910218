package com.bytedance.jstu.demo.Homework

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.jstu.demo.R

class Chapter2QuestionContentActivity: AppCompatActivity() {

    private var content = ""

    private val txtContent by lazy {
        findViewById<TextView>(R.id.chpater2questioncontent_txt_content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter2questioncontent)
        var bundle = intent.extras
        content = bundle?.getString("content").toString()
        txtContent.text = content
    }

}