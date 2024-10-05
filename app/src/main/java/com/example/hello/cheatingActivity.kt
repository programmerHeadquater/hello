package com.example.hello

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.databinding.ActivityCheatingBinding
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import com.example.hello.databinding.MainActivityBinding

private const val EXTRA_ANSWER_IS_TRUE = "com.example.hello.answer_is_true"
const val EXTRA_ANSWER_SHOWN = "com.example.hello.answer_shown"


class CheatActivity : ComponentActivity() {
    private lateinit var binding: ActivityCheatingBinding

    var answerIsTrue = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false)
        binding.showAnswerButton.setOnClickListener{
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            binding.showAnswerButton.setText(answerText)
            setAnswerShownResult(true)
        }
    }
    private fun setAnswerShownResult(isAnswerShown: Boolean){
        val data = Intent().apply{
            putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown)
        }
        setResult(Activity.RESULT_OK,data)
    }
    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }

        }


    }

}