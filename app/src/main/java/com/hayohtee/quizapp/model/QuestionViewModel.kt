package com.hayohtee.quizapp.model

import androidx.lifecycle.ViewModel

class QuestionViewModel: ViewModel() {
    private val questions = listOf<Question>(
        Question("Is Lagos the capital of Nigeria", false),
        Question("Egypt is in Africa?", true),
        Question("The Earth is the fifth planet?", false),
        Question("Crocodile a reptile?", true),
        Question("Sun sets in the East?", false)
    )
    private var score = 0
    private var currentIndex = 0

    fun getQuestion(): String {
        return questions[currentIndex].questionText
    }

    fun getAnswer(): Boolean {
       return questions[currentIndex].answer
    }

    fun nextQuestion(){
        if (currentIndex != questions.size - 1){
            currentIndex += 1
        }
    }
}