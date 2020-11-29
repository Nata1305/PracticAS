package com.example.myappli2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button yesBtn;
    private Button noBtn;
    private TextView textView;
    private TextView textFinished;
    private Question[] questions = new Question[] {
            new Question(R.string.question1, false),
            new Question(R.string.question2,false),
            new Question(R.string.question3,true),
            new Question(R.string.question4,true),
            new Question(R.string.question5,true),
            new Question(R.string.question6,false)

    };
    private int questionIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textQuestion);
        textFinished=findViewById(R.id.textFinish);


        textView.setText(questions[questionIndex].getQuestionRecId());
        yesBtn= findViewById(R.id.yesBtn);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this, R.string.Correct, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT).show();
                questionIndex++;
                if (questionIndex<6)
                    textView.setText(questions[questionIndex].getQuestionRecId());
                else {
                    textFinished.setText(R.string.textFinish);
                }


            }
        });

        noBtn=findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  if (questions[questionIndex].isAnswerTrue())
                  Toast.makeText(MainActivity.this,R.string.Incorrect,Toast.LENGTH_SHORT).show();
                    else
                    Toast.makeText(MainActivity.this,R.string.Correct,Toast.LENGTH_SHORT).show();
                    questionIndex++;
                    if (questionIndex<6)
                    textView.setText(questions[questionIndex].getQuestionRecId());
                    else  {
                    textFinished.setText(R.string.textFinish);
                }


            }
        });
    }
}