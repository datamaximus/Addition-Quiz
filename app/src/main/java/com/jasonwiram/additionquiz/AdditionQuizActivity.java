package com.jasonwiram.additionquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class AdditionQuizActivity extends AppCompatActivity {
    private QuestionBank mQuestionBank = new QuestionBank();
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private TextView mQuestionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_quiz);

        mAnswerButton1 = (Button) findViewById(R.id.button1);
        mAnswerButton2 = (Button) findViewById(R.id.button2);
        mAnswerButton3 = (Button) findViewById(R.id.button3);
        mQuestionTextView = (TextView) findViewById(R.id.QuestionTextView);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdditionQuizActivity.this, "You chose wisely!", Toast.LENGTH_LONG).show();
                mQuestionBank.setQuestionAndAnswers();
                mQuestionTextView.setText(mQuestionBank.mQuestion);
                mAnswerButton1.setText(mQuestionBank.mCorrectAnswer);
                mAnswerButton2.setText(mQuestionBank.mFirstIncorrectAnswer);
                mAnswerButton3.setText(mQuestionBank.mSecondIncorrectAnswer);
            }
        };
        mAnswerButton1.setOnClickListener(listener);
        mAnswerButton2.setOnClickListener(listener);
        mAnswerButton3.setOnClickListener(listener);
    }
}

