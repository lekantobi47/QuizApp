package com.hayohtee.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hayohtee.quizapp.databinding.ActivityMainBinding
import com.hayohtee.quizapp.model.QuestionViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val questionViewModel: QuestionViewModel by lazy {
        ViewModelProvider(this).get(QuestionViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        displayQuestion()
        setHandlers()
    }

    private fun displayQuestion(){
        val question = questionViewModel.getQuestion()
        binding.questionTextView.text = question
    }

    private fun setHandlers(){
        binding.nextButton.setOnClickListener {
            questionViewModel.nextQuestion()
            displayQuestion()
        }
    }

}