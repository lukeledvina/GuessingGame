package com.example.lukeledvina.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private Button guessButton;
    private TextView clue;
    private EditText guess;

    private int generatedNumber;
    private int numberOfGuesses = 0;
    private final int MAX_GUESS_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        guessButton = findViewById(R.id.submit_guess_button);
        clue = findViewById(R.id.clue_textview);
        guess = findViewById(R.id.guess_edittext);

        //this generates a random number between 1 and 100
        generatedNumber = (int) Math.ceil(Math.random() * 100);

//        Toast.makeText(this, Integer.toString(generatedNumber), Toast.LENGTH_SHORT).show();

        setListener();


    }

    private void setListener() {
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateGuess();
            }
        });
    }

    private void validateGuess() {
        
    }

    @Override
    public void onBackPressed() {
        //Removed super.onBackPressed(); to make sure if the back button is pressed nothing will happen.
    }
}
