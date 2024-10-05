package com.example.hello

import QuizViewModel
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent

import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.hello.databinding.MainActivityBinding
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.RenderEffect
import androidx.core.app.ActivityCompat


private const val TAG = "Main Activity"





class MainActivity  : ComponentActivity() {
    private lateinit var binding : MainActivityBinding

    private val quizViewModel:QuizViewModel by viewModels()

    private val cheatLuancher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
            run {
                if (result.resultCode == Activity.RESULT_OK) {
                    quizViewModel.isCheater =
                        result.data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false
                }
            }
    }
//    @SuppressLint("Range", "MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(savedInstanceState: Bundle?) called")

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.trueButton.setOnClickListener{
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener{
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener{
            quizViewModel.moveToNext()
            updateQuestion()
        }
        binding.cheatButton.setOnClickListener{
            var intent = Intent(this,CheatActivity::class.java)
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            intent = CheatActivity.newIntent(this@MainActivity,answerIsTrue)
            cheatLuancher.launch(intent)
        }

        updateQuestion()

    }
    private fun updateQuestion(){
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer : Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if(userAnswer == correctAnswer ){
            R.string.correct_toast
        }else {
            R.string.incorrect_toast
        }
        val messageResId2 = when{
            quizViewModel.isCheater -> R.string.judgement_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }
        Toast.makeText(this,messageResId2,Toast.LENGTH_SHORT).show()

    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() called")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() called")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() called")

    }
}


