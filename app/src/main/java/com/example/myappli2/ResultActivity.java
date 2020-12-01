package com.example.myappli2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultActivity extends AppCompatActivity {






   private ArrayList<String> userAnswer;
    private TextView textShowAnswer;
    private Button goAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        goAgain=findViewById(R.id.goAgain);

        userAnswer=getIntent().getStringArrayListExtra("UserAnswerTrue");
        textShowAnswer=findViewById(R.id.numbersTrue);
        String formatted=userAnswer.toString().replace(",","\n")
                .replace("[","")
                .replace("]","")
                .trim();
                textShowAnswer.setText(formatted);

                goAgain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(ResultActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

    }

}




