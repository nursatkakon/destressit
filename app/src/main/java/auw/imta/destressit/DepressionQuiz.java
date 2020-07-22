package auw.imta.destressit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DepressionQuiz extends AppCompatActivity{


    int score;
    Button record;

    public void depressionScore1(View view) {
        score = score + 1;
        display(score);
    }

    public void depressionScore2(View view) {
        score = score + 2;
        display(score);
    }

    public void depressionScore3(View view) {
        score = score + 3;
        display(score);
    }

    private void display(int number) {
        TextView scoreTextView = (TextView) findViewById(R.id.depressionScore);
        scoreTextView.setText("" + number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depression_quiz);
        //Button depScore = (Button) findViewById(R.id.depressionScore);
        record = (Button) findViewById(R.id.record);


        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DepressionQuiz.this,DepressionScore.class));
            }
        });
    }
}