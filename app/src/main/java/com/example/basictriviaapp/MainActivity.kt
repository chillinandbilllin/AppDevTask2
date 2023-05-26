package com.example.basictriviaapp

import android.hardware.biometrics.BiometricManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
 class Question(val q:String,val options:List<String>,val correcti:Int)
class MainActivity : AppCompatActivity() {
    private val questions = listOf(
        Question("What is the most populous state in India?", listOf("Bihar", "Uttar Pradesh", "Rajasthan"), 1),
        Question(
            "What is the largest river in the world?",
            listOf("Nile", "Ganga", "Yamuna"),
            0
        ),
        Question(
            "Who wrote Merchant Of Venice",
            listOf("William Shakespeare", "Pablo Picasso", "Vincent van Gogh",),
            0
        )
    )


    var qi = 0;
    var sco = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var ques: TextView = findViewById(R.id.textView)
        var ans: RadioGroup = findViewById(R.id.radiogroup)
        var next: Button = findViewById(R.id.button)
        var score: TextView = findViewById(R.id.textView2)
        next.setOnClickListener() {
            val checked = ans.checkedRadioButtonId
            val checkedindex = ans.indexOfChild(ans.findViewById(checked))
            if (checkedindex == questions[qi].correcti) {
                sco++
            }
            qi += 1
            if (qi < questions.size) {
                var question = questions[qi]
                ques.text = question.q
                ans.clearCheck()
                for (i in 0 until ans.childCount) {
                    val radb = ans.getChildAt(i) as RadioButton
                    radb.text = question.options[i]

                }

            } else {
                ques.text = "Quiz done "
                score.text = sco.toString()
                next.isEnabled=false
                ans.removeAllViews()
            }

        }
    }
}