package com.myhistoryapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Declare
    private lateinit var clearButton: Button
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Initialise
        clearButton = findViewById(R.id.clearButton)
        searchButton = findViewById(R.id.searchButton)
        resultTextView = findViewById(R.id.resultTextView)
        ageInput = findViewById(R.id.ageInput)

        searchButton.setOnClickListener {
                val age = ageInput.text.toString().toIntOrNull()

                if (age != null && age in 20..100) {
                    val FamousPerson = when (age) {
                        20 -> "Christopher Wallace, known better as The Notorious B.I.G. or Biggie Smalls, left a lasting legacy in the world of rap, yet he only released a single album in his lifetime."
                        30 -> "Princess Diana was a member of the British royal family. She was the first wife of Charles, Prince of Wales, and the mother of Prince William and Prince Harry."
                        40 -> "Nate Dogg was born on August 19, 1969 in Long Beach, California, USA."
                        50 -> "Steven Paul Jobs, he was the founder of Apple."
                        60 -> "Garry Shandling, he was a writer and actor."
                        70 -> "Bruce Lee, remains the greatest icon of martial arts cinema and a key figure of modern popular media."
                        80 -> "Muhammad Ali, he was a famous boxing star."
                        90 -> "Loretta Lynn, was a American singer-songwriter."
                        100 -> "Henry Alfred Kissinger, was an American diplomat, political scientist, geopolitical consultant, and politician who served as United States secretary of state and national security advisor."
                        else -> null
                    }
                    val message = if (FamousPerson != null) "The persons name is $FamousPerson"
                    else "No Famous person found within the entered age"
                    resultTextView.text = message

                } else {
                    resultTextView.text =
                        "Invalid input.Please enter a valid age between 20 and 100."
                }
                clearButton.setOnClickListener {
                    ageInput.text.clear()
                    resultTextView.text = ""
                }

            }
        }
    }
