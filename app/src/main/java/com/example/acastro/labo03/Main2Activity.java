package com.example.acastro.labo03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.View;

//import android.content.Intent;

public class Main2Activity extends AppCompatActivity {
TextView text;
Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.tv2);
        but = findViewById(R.id.btnhome);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();
        if(Intent.ACTION_SEND.equals(intentAction) && intentType != null){
            if(intentType.equals("text/plain")){
                handleReceivedText(callingIntent);
            }
        }

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fstScreenIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(fstScreenIntent);
            }
        });
        }

        public void handleReceivedText (Intent i){
            String intentText = i.getStringExtra(Intent.EXTRA_TEXT);

            if (text != null){
                text.setText(intentText);
            }
        }





    }

