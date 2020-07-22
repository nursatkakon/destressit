package auw.imta.destressit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DepressionMenu extends AppCompatActivity {
    Button quiz;
    Button Specialists;
    Button about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depression_menu);
        quiz = (Button) findViewById(R.id.quiz);
        Button Specialists = (Button) findViewById(R.id.specialists);
        Button about = (Button) findViewById(R.id.about);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DepressionMenu.this,DepressionQuiz.class));

                //Intent intent = new Intent(DepressionMenu.this,DepressionQuiz.class);
                //startActivity(intent);
            }
        });
        Specialists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DepressionMenu.this,Expert_depression.class));
            }
        });
       about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DepressionMenu.this,about_depression.class));
            }
        });
    }
}
