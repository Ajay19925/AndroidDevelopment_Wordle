package com.example.wordle

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.backgroundColor
import androidx.core.text.color
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.models.Size


class MainActivity : AppCompatActivity() {
    val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

    var counter=0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

        val button = findViewById<Button>(R.id.button)
        val simpleEditText = findViewById<EditText>(R.id.et_simple)
        val guessed1 = findViewById<TextView>(R.id.Guess1)
        val guessed2 = findViewById<TextView>(R.id.Guess2)
        val guessed3 = findViewById<TextView>(R.id.Guess3)
        val guessedres1 = findViewById<TextView>(R.id.gussedcheck1)
        val guessedres2 = findViewById<TextView>(R.id.gussedcheck2)
        val guessedres3 = findViewById<TextView>(R.id.gussedcheck3)
        val guessedword1 = findViewById<TextView>(R.id.guessedword)
        val guessedword2 = findViewById<TextView>(R.id.guessedword2)
        val guessedword3 = findViewById<TextView>(R.id.guessedword3)
        val guessresult1 = findViewById<TextView>(R.id.guessresult1)
        val guessresult2 = findViewById<TextView>(R.id.guessresult2)
        val guessresult3 = findViewById<TextView>(R.id.guessresult3)
        val Result = findViewById<TextView>(R.id.Result)
        val viewKonfetti = findViewById<KonfettiView>(R.id.konfetti)


        //Toast.makeText(this, wordToGuess, Toast.LENGTH_SHORT).show()
        button.setOnClickListener {
            it.hideKeyboard()

            if (counter == 0) {
                    counter++
                    val strValue = simpleEditText.text.toString().uppercase()
                    guessed1.visibility = View.VISIBLE
                    guessedword1.visibility = View.VISIBLE
                    guessedword1.text = strValue


                    val res = checkGuess(strValue)
                    guessedres1.visibility = View.VISIBLE
                    guessresult1.visibility = View.VISIBLE
                    guessresult1.text = res
                    simpleEditText.text.clear()

                if(wordToGuess==strValue){
                    viewKonfetti.build()
                        .addColors(Color.YELLOW,Color.GREEN,Color.MAGENTA)
                        .setDirection(0.0,359.0)
                        .setSpeed(1f,5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(nl.dionsegijn.konfetti.models.Shape.Square,nl.dionsegijn.konfetti.models.Shape.Circle)
                        .addSizes(Size(12))
                        .setPosition(-50f,viewKonfetti.width + 50f,-50f, -50f)
                        .streamFor(300,3000L)

                    button.text = "RESTART"
                    Result.visibility=View.VISIBLE
                    Result.text=wordToGuess
                    button.setOnClickListener {
                        val intent = Intent(
                            this@MainActivity,
                            MainActivity::class.java
                        )

                        startActivity(intent)
                        //val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

                    }
                }
            }

             else if (counter == 1) {
                    counter++
                    val strValue = simpleEditText.text.toString().uppercase()
                    guessed2.visibility = View.VISIBLE
                    guessedword2.visibility = View.VISIBLE
                    guessedword2.text = strValue


                    val res = checkGuess(strValue)
                    guessedres2.visibility = View.VISIBLE
                    guessresult2.visibility = View.VISIBLE
                    guessresult2.text = res
                simpleEditText.text.clear()
                if(wordToGuess==strValue){
                    viewKonfetti.build()
                        .addColors(Color.YELLOW,Color.GREEN,Color.MAGENTA)
                        .setDirection(0.0,359.0)
                        .setSpeed(1f,5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(nl.dionsegijn.konfetti.models.Shape.Square,nl.dionsegijn.konfetti.models.Shape.Circle)
                        .addSizes(Size(12))
                        .setPosition(-50f,viewKonfetti.width + 50f,-50f, -50f)
                        .streamFor(300,3000L)
                    Result.visibility=View.VISIBLE
                    Result.text=wordToGuess
                    button.text = "RESTART"
                    button.setOnClickListener {
                        val intent = Intent(
                            this@MainActivity,
                            MainActivity::class.java
                        )

                        startActivity(intent)
                        //val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

                    }
                }
                }

             else if (counter == 2) {
                    counter++
                    val strValue = simpleEditText.text.toString().uppercase()
                    guessed3.visibility = View.VISIBLE
                    guessedword3.visibility = View.VISIBLE
                    guessedword3.text = strValue


                    val res = checkGuess(strValue)
                    guessedres3.visibility = View.VISIBLE
                    guessresult3.visibility = View.VISIBLE
                    guessresult3.text = res
                simpleEditText.text.clear()
                if(wordToGuess==strValue){
                    viewKonfetti.build()
                        .addColors(Color.YELLOW,Color.GREEN,Color.MAGENTA)
                        .setDirection(0.0,359.0)
                        .setSpeed(1f,5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(nl.dionsegijn.konfetti.models.Shape.Square,nl.dionsegijn.konfetti.models.Shape.Circle)
                        .addSizes(Size(12))
                        .setPosition(-50f,viewKonfetti.width + 50f,-50f, -50f)
                        .streamFor(300,3000L)
                }


                Result.visibility=View.VISIBLE
                Result.text=wordToGuess
                button.text = "RESTART"
                button.setOnClickListener {
                  val intent = Intent(
                      this@MainActivity,
                            MainActivity::class.java
                        )

                        startActivity(intent)
                        //val wordToGuess = FourLetterWordList.getRandomFourLetterWord()


                }


                }

        }


            // Showing the user input
          //  Toast.makeText(this, strValue, Toast.LENGTH_SHORT).show()





        //print(wordToGuess)


    }
    private fun checkGuess(guess: String) : SpannableStringBuilder {
        val s = SpannableStringBuilder()

        var result = ""
        //val foregroundColorSpanBlue = ForegroundColorSpan(Color.RED)
        //val foregroundColorSpanGreen = ForegroundColorSpan(Color.GREEN)
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                //result += "O"
                val temp = guess[i].toString()
                s.color(Color.GREEN,{ append(temp)})
                //val temp = guess[i].toString()
                //val spannableString = SpannableString(temp)
                //result += s

                //result += spannableString.setSpan(foregroundColorSpanGreen, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE).toString()
                //result = SpannableStringBuilder().backgroundColor(foregroundColorSpanBlue, { append(guess[i]) }).toString()
            }
            else if (guess[i] in wordToGuess) {
                //result += guess[i].toString()
                val temp1 = guess[i].toString()
                s.color(Color.RED,{append(temp1)})
                //result += "+"
            }
            else {
                //val temp1 = guess[i].toString()
                //val spannableString1 = SpannableString(temp1)
                val temp2 = guess[i].toString()
                s.color(Color.BLACK,{append(temp2)})

                //result += spannableString1.setSpan(foregroundColorSpanBlue, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE).toString()
                //result += "X"
            }
        }

        //result = s.toString()

        return s
    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

}