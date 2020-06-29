package com.example.randomouchbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button ouchButton;
    boolean isBlue = true;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ouchButton = findViewById(R.id.ouchButton);

        ouchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update count on each click to dictate other actions
                count++;

                //Alternate between blue and red button color after each click
                if(isBlue) {
                    ouchButton.setBackgroundColor(Color.RED);
                    isBlue = false;
                }
                else {
                    ouchButton.setBackgroundColor(Color.BLUE);
                    isBlue = true;
                }

                //After 10 clicks button text displays "Ouch" text
                if(count == 10) {
                    ouchButton.setText("Ouch!");
                }
                //After 20 clicks a random number is generated and displayed as text
                if(count >= 20) {
                    Random randomNum = new Random();
                    ouchButton.setText(String.valueOf(randomNum.nextInt(100)));
                }

            }
        });
    }
}
