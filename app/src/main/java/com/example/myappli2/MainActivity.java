package com.example.myappli2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button yesBtn;
    private Button noBtn;
    private Button help;
    private TextView textView;
    ArrayList<String> answerUser=new ArrayList<>();
    private Question[] questions = new Question[] {
            new Question(R.string.question1, true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,false),
            new Question(R.string.question4,false),
            new Question(R.string.question5,false),
            new Question(R.string.question6,false),
            new Question(R.string.question7,false),
            new Question(R.string.question8,true),
            new Question(R.string.question9,true),
            new Question(R.string.question10,false),
            new Question(R.string.question11,true),
            new Question(R.string.question12,false),
            new Question(R.string.question13,false),
            new Question(R.string.question14,false),
            new Question(R.string.question15,false),
            new Question(R.string.question16,false),
            new Question(R.string.question17,true),
            new Question(R.string.question18,false),
            new Question(R.string.question19,true),
            new Question(R.string.question20,false)

    };
    private int questionIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textQuestion);
        help=findViewById(R.id.help);
        if (savedInstanceState != null){ // Если есть сохранённая информация, то достаём её.
            questionIndex = savedInstanceState.getInt("questionIndex");
        }


        textView.setText(questions[questionIndex].getQuestionRecId());
        yesBtn= findViewById(R.id.yesBtn);
        noBtn= findViewById(R.id.noBtn);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue()){
                    answerUser.add("Правильно");
                    Toast.makeText(MainActivity.this, R.string.Correct, Toast.LENGTH_SHORT).show();}
                else {
                    answerUser.add("Неправильно");
                    Toast.makeText(MainActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT).show();}
                    questionIndex++;
                    if (questionIndex < questions.length)
                        textView.setText(questions[questionIndex].getQuestionRecId());
                    else {
                        yesBtn.setEnabled(false);
                        noBtn.setEnabled(false);
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("UserAnswerTrue", answerUser);
                        startActivity(intent);
                    }


            }
            });

            noBtn=findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    if (questions[questionIndex].isAnswerTrue()) {
                        answerUser.add("Неправильно");
                        Toast.makeText(MainActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT).show();
                    } else {
                        answerUser.add("Правильно");
                        Toast.makeText(MainActivity.this, R.string.Correct, Toast.LENGTH_SHORT).show();}
                        questionIndex++;
                        if (questionIndex < questions.length)
                            textView.setText(questions[questionIndex].getQuestionRecId());
                        else {
                            yesBtn.setEnabled(false);
                            noBtn.setEnabled(false);
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("UserAnswerTrue", answerUser);
                            startActivity(intent);
                        }

                }

            });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer",questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });

        }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){ // Метод сохранения данных перед уничтожением активности
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("questionIndex",questionIndex);
    }
}
