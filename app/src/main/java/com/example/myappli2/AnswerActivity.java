package com.example.myappli2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private Boolean isAnswerTrue;
    private TextView textShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

      isAnswerTrue= getIntent().getBooleanExtra("answer",true);
       textShowAnswer=findViewById(R.id.show_answer);

      textShowAnswer.setText(isAnswerTrue?R.string.Yes:R.string.No);


    }
}