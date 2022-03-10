package com.bayesa.catchingjerry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScorePage extends AppCompatActivity {
    TextView scoreTextView;
    TextView highestScoreTextView;
    Button button2;
    int score_value;
    int high_score;
    MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);
        scoreTextView = findViewById(R.id.anotherScoretextView);
        highestScoreTextView = findViewById(R.id.highestScoreTextView);
        button2 = findViewById(R.id.button2);
        Intent intent = getIntent();
        mainActivity.sharedPreferences = this.getSharedPreferences("com.bayesa.catchingjerry", Context.MODE_PRIVATE);
        score_value = intent.getIntExtra("score",0);
        high_score = intent.getIntExtra("highScore",0);
        highestScoreTextView.setText("High Score: " + high_score);

        if(score_value == 0){
            scoreTextView.setText("No score");
        }
        else{
            scoreTextView.setText("Score: " + score_value);
        }

        if(score_value > high_score){
            Toast.makeText(this,"High Score will be updated in the next round",Toast.LENGTH_LONG).show();
        }

    }

    public void restart(View view){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    public void resetAllData(View view){
        // SharedPreferences içerisindeki tüm veriler silinip yeni değerleri ile güncellenecek....

        mainActivity.sharedPreferences.edit().remove("score").apply();
        scoreTextView.setText("Score: ");
        mainActivity.sharedPreferences.edit().remove("highScore").apply();
        highestScoreTextView.setText("High Score: ");
        Toast.makeText(this,"Bu özellik üzerinde çalışılıyor...",Toast.LENGTH_LONG).show();

    }
}