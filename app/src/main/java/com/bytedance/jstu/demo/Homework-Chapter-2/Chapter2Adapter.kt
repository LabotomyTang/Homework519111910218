package com.bytedance.jstu.demo.Homework

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.jstu.demo.R

class Chapter2Adapter: RecyclerView.Adapter<Chapter2Adapter.Chapter2ViewHolder>() {

    private val questionList = ArrayList<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Chapter2ViewHolder {
        val view = View.inflate(parent.context, R.layout.chapter2_item, null)
        return Chapter2ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Chapter2ViewHolder, position: Int) {
        holder.bind(questionList[position])
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    fun addQuestion(question: Question) {
        questionList.add(question)
        notifyDataSetChanged()
    }


    class Chapter2ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val txtDifficulty = view.findViewById<TextView>(R.id.chapter2_txt_difficulty)
        private val txtTitle = view.findViewById<TextView>(R.id.chapter2_txt_title)
        private val txtAnswerAmt = view.findViewById<TextView>(R.id.chapter2_txt_answeramt)
        private val txtPassRate = view.findViewById<TextView>(R.id.chapter2_txt_passrate)


        fun bind(question: Question) {
            txtTitle.text = question.title
            txtAnswerAmt.text = question.answerAmt.toString()
            txtPassRate.text = "%.2f".format(question.passRate * 100) + " %"
            when (question.difficulty) {
                0 -> {
                    txtDifficulty.text = "简单"
                    txtDifficulty.setBackgroundColor(txtDifficulty.context.resources.getColor(R.color.green))
                }
                1 -> {
                    txtDifficulty.text = "普通"
                    txtDifficulty.setBackgroundColor(txtDifficulty.context.resources.getColor(R.color.yellow))
                }
                2 -> {
                    txtDifficulty.text = "困难"
                    txtDifficulty.setBackgroundColor(txtDifficulty.context.resources.getColor(R.color.red))
                }
            }

            txtTitle.setOnClickListener(View.OnClickListener {
                Log.e("zhTang", "success")
                var bundle = Bundle()
                bundle.putString("content", question.content)
                var intent = Intent()
                intent.putExtras(bundle)
                intent.setClass(txtTitle.context, Chapter2QuestionContentActivity::class.java)
                txtDifficulty.context.startActivity(intent)
            })

        }
    }


    class Question(_title: String, _difficulty: Int, _answerAmt: Int, _passRate: Float, _content: String) {
        var title = _title
        var difficulty = _difficulty
        var answerAmt = _answerAmt
        var passRate = _passRate
        var content = _content
    }

}