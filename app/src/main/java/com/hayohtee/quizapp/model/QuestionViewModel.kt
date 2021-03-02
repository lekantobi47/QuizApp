package com.hayohtee.quizapp.model

import androidx.lifecycle.ViewModel

class QuestionViewModel: ViewModel() {
    private var score = 0
    private var currentIndex = 0

    // List of Question objects
    private val questions = listOf<Question>(
        Question("Is Lagos the capital of Nigeria", false),
        Question("Egypt is in Africa?", true),
        Question("The Earth is the fifth planet?", false),
        Question("Crocodile a reptile?", true),
        Question("Sun sets in the East?", false)
    )

    fun getCurrentIndex(): Int {
        return currentIndex
    }

    fun getScore(): Int {
        return score
    }

    fun getSize(): Int {
        return questions.size
    }


    fun incrementCurrentIndex(){
        currentIndex += 1
    }


    fun incrementScore(){
        score += 1
    }

    fun getQuestion(): String {
        return questions[currentIndex].questionText
    }

    fun getAnswer(): Boolean {
       return questions[currentIndex].answer
    }

    fun reset(){
        score = 0
        currentIndex = 0
    }

}