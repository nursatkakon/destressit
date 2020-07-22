package auw.imta.destressit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlchoholQuiz extends AppCompatActivity {

    int score;
    Button alcScore;


    public void alcoholismScore1(View view) {
        score = score + 1;
        display(score);
    }

    public void alcoholismScore2(View view) {
        score = score + 2;
        display(score);
    }

    public void alcoholismScore3(View view) {
        score = score + 3;
        display(score);
    }

    private void display(int number) {
        TextView scoreTextView = (TextView) findViewById(R.id.alcoholismScore);
        scoreTextView.setText("" + number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alchohol_quiz);
        Button depScore = (Button) findViewById(R.id.alcoholismScore);

        alcScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlchoholQuiz.this,AlcoholismScore.class));
            }
        });
    }


}