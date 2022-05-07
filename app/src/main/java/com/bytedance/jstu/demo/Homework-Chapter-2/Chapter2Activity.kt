package com.bytedance.jstu.demo.Homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.jstu.demo.R


class Chapter2Activity: AppCompatActivity() {

    private val recycleViewMain by lazy {
        findViewById<RecyclerView>(R.id.chapter2_recyclerview_main)
    }

    private val adapter = Chapter2Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter2)

        recycleViewMain.layoutManager = LinearLayoutManager(this)
        recycleViewMain.adapter = adapter


        var title = ""
        var difficulty = 0
        var answerAmt = 0
        var passRate = 0f
        var content = ""
        for (i in (0 until 100)) {
            title = "第 ${ i + 1 } 题"
            difficulty = (0..2).random()
            answerAmt = (0..10000).random()
            passRate = (0..10000).random().toFloat() / 10000
            content = "这是第 ${ i + 1 } 题的内容"
            adapter.addQuestion(Chapter2Adapter.Question(title, difficulty, answerAmt, passRate, content))
        }
    }




}