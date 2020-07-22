package auw.imta.destressit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NarcoticsQuiz extends AppCompatActivity {

    int score;
    Button narScore;


    public void narcoticsScore1(View view) {
        score = score + 1;
        display(score);
    }

    public void narcoticsScore2(View view) {
        score = score + 2;
        display(score);
    }

    public void narcoticsScore3(View view) {
        score = score + 3;
        display(score);
    }

    private void display(int number) {
        TextView scoreTextView = (TextView) findViewById(R.id.narcotismScore);
        scoreTextView.setText("" + number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narcotics_quiz);
        Button depScore = (Button) findViewById(R.id.narcotismScore);

        narScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NarcoticsQuiz.this,NarcoticsScore.class));
            }
        });
    }


}
