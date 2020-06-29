package com.example.randomouchbuttonkotlin

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var count = 0;
    var isBlue = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ouchButton.setOnClickListener { v ->
            //update count on each click to dictate other actions
            count++

            //Alternate between blue and red button color after each click
            isBlue = if (isBlue) {
                ouchButton.setBackgroundColor(Color.RED)
                false
            } else {
                ouchButton.setBackgroundColor(Color.BLUE)
                true
            }

            //After 10 clicks button text displays "Ouch" text
            if (count == 10) {
                ouchButton.text = "Ouch!"
            }
            //After 20 clicks a random number is generated and displayed as text
            if (count == 20) {
                val randomNum = Random()
                ouchButton.text = randomNum.nextInt(100).toString()
            }
        }
    }
}
