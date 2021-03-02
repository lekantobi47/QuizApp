package com.hayohtee.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
            nextQuestion()
        }
        binding.trueButton.setOnClickListener { checkAnswer(true) }
        binding.falseButton.setOnClickListener { checkAnswer(false) }
        binding.resetButton.setOnClickListener { reset() }
    }

    private fun nextQuestion(){
        if (questionViewModel.getCurrentIndex() == questionViewModel.getSize() - 1){
            end()
        } else {
            questionViewModel.incrementCurrentIndex()
            displayQuestion()
        }
    }

    private fun checkAnswer(value: Boolean){
        var message: String? = null
        if (value == questionViewModel.getAnswer()){
            questionViewModel.incrementScore()
            message = "Correct!"
        } else {
            message = "Incorrect!"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun end(){
        binding.trueButton.visibility = View.GONE
        binding.falseButton.visibility = View.GONE
        binding.nextButton.visibility = View.GONE
        binding.resetButton.visibility = View.VISIBLE
        binding.questionTextView.text = "Total score was ${questionViewModel.getScore()}"
    }


    private fun reset(){
        questionViewModel.reset()
        displayQuestion()

        binding.trueButton.visibility = View.VISIBLE
        binding.falseButton.visibility = View.VISIBLE
        binding.nextButton.visibility = View.VISIBLE
        binding.resetButton.visibility = View.GONE

    }

}