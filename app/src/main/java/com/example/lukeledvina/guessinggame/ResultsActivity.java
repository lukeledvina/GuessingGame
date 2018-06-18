package com.example.lukeledvina.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.lukeledvina.guessinggame.GameActivity.winningNumber;

public class ResultsActivity extends AppCompatActivity {

    private Button playAgainButton;
    private TextView correctNumberTextview;
    private TextView resultsTextView;
    private ImageView resultsImageView;
    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        playAgainButton = findViewById(R.id.restart_button);
        correctNumberTextview = findViewById(R.id.number_textview);
        resultsTextView = findViewById(R.id.results_textview);
        resultsImageView = findViewById(R.id.winning_imageview);

        setListener();

        //TODO get winning number from intent if loser has lost
        intent = getIntent();
        if(intent.hasExtra(winningNumber)) {
            setLosingData();
        }
    }

    private void setLosingData() {
        int winningNumber = intent.getIntExtra(GameActivity.winningNumber, 0);
        resultsTextView.setText(R.string.you_lost);
        correctNumberTextview.setText(getString(R.string.winning_number, winningNumber));
        correctNumberTextview.setVisibility(View.VISIBLE);

        resultsImageView.setImageResource(R.drawable.losingsadface);

    }

    private void setListener() {
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
