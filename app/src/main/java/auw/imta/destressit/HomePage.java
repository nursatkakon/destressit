package auw.imta.destressit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button Alco;
    Button Narco;
    Button Suici;
    Button Depres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button Alco = (Button) findViewById(R.id.alcoholism);
        Button Narco = (Button) findViewById(R.id.narcotism);
        Button Suici = (Button) findViewById(R.id.suicidal);
        Button Depres = (Button) findViewById(R.id.depression);
        Button Userpro = (Button) findViewById(R.id.userpro);

        Alco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,AlcoholismMenu.class));
            }
        });
        Narco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,NarcoticsMenu.class));
            }
        });
        Suici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,SuicidalMenu.class));
            }
        });
        Depres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,DepressionMenu.class));
            }
        });
        Userpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,Profile.class));
            }
        });
    }
}
