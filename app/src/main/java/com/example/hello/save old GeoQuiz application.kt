package com.example.hello
//package com.example.hello
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.ComponentActivity
//import com.example.hello.databinding.MainActivityBinding
//import android.widget.Toast
//
//private const val TAG = "Main Activity"
//
//class MainActivity : ComponentActivity() {
//    private lateinit var binding : MainActivityBinding
//    private var currentIndex = 0
//    private val questionBank = listOf(
//        Question(R.string.question_ocean,true),
//        Question(R.string.question_ocean,true),
//        Question(R.string.question_mideast,false),
//        Question(R.string.question_africa,false),
//        Question(R.string.question_americas,true),
//        Question(R.string.question_asia,true)
//    )
//
//    @SuppressLint("Range", "MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//
//        Log.d(TAG,"onCreate(savedInstanceState: Bundle?) called")
//
//        binding = MainActivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//
//
//        binding.trueButton.setOnClickListener{
//            checkAnswer(true)
//        }
//
//        binding.falseButton.setOnClickListener{ view -> view
//            checkAnswer(false)
//        }
//        binding.nextButton.setOnClickListener{
//            currentIndex = (currentIndex + 1 ) % questionBank.size
//            updateQuestion()
//        }
//        updateQuestion()
//
//    }
//    private fun updateQuestion(){
//        val questionTextResId = questionBank[currentIndex].textResId;
//        binding.questionTextView.setText(questionTextResId)
//    }
//    private fun checkAnswer(userAnswer : Boolean){
//        val correctAnswer = questionBank[currentIndex].answer
//        val messageResId = if(userAnswer == correctAnswer ){
//            R.string.correct_toast
//        }else {
//            R.string.incorrect_toast
//        }
//        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show()
//
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG,"onStart() called")
//
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG,"onStop() called")
//
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG,"onDestroy() called")
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG,"onResume() called")
//
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG,"onPause() called")
//
//    }
//}
//
//
//package com.example.hello
//import androidx.annotation.StringRes
//
//data class Question (@StringRes val textResId: Int, val answer: Boolean){
//
//}
