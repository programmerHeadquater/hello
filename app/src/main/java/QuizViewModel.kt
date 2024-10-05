import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.SAVED_STATE_REGISTRY_OWNER_KEY
import androidx.lifecycle.SavedStateHandle
import com.example.hello.Question
import com.example.hello.R


private const val TAG = "QuizViewModel"
const val current_index_key = "current_index_key"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    var currentIndex: Int
        get() = savedStateHandle.get<Int>(current_index_key) ?: 0 // Default to 0 if not found
        set(value) {
            savedStateHandle.set(current_index_key, value)
        }

    private val questionBank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_ocean,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true)
    )
    var isCheater : Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?:false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = ( currentIndex + 1 ) % questionBank.size
    }

}




