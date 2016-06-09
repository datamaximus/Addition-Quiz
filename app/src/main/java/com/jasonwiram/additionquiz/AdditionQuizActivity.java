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
    private String mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_quiz);

        mAnswerButton1 = (Button) findViewById(R.id.button1);
        mAnswerButton2 = (Button) findViewById(R.id.button2);
        mAnswerButton3 = (Button) findViewById(R.id.button3);
        mQuestionTextView = (TextView) findViewById(R.id.QuestionTextView);

        nextQuestion();

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerButton1.getText() == mQuestionBank.mCorrectAnswer) {
                    mToast = "Correct!";
                } else {
                    mToast = "Incorrect.";
                }
                Toast.makeText(AdditionQuizActivity.this, mToast, Toast.LENGTH_SHORT).show();
                nextQuestion();
            }
        };

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerButton2.getText() == mQuestionBank.mCorrectAnswer) {
                    mToast = "Correct!";
                } else {
                    mToast = "Incorrect.";
                }
                Toast.makeText(AdditionQuizActivity.this, mToast, Toast.LENGTH_SHORT).show();
                nextQuestion();
            }
        };

        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerButton3.getText() == mQuestionBank.mCorrectAnswer) {
                    mToast = "Correct!";
                } else {
                    mToast = "Incorrect.";
                }
                Toast.makeText(AdditionQuizActivity.this, mToast, Toast.LENGTH_SHORT).show();
                nextQuestion();
            }
        };

        mAnswerButton1.setOnClickListener(listener1);
        mAnswerButton2.setOnClickListener(listener2);
        mAnswerButton3.setOnClickListener(listener3);
    }

    public void nextQuestion() {
        mQuestionBank.setQuestionAndAnswers();
        mQuestionTextView.setText(mQuestionBank.mQuestion);
        assignAnswerPosition();
    }

    public void assignAnswerPosition() {
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(3);
        if (randomNumber == 0) {
            mAnswerButton1.setText(mQuestionBank.mCorrectAnswer);
            mAnswerButton2.setText(mQuestionBank.mFirstIncorrectAnswer);
            mAnswerButton3.setText(mQuestionBank.mSecondIncorrectAnswer);
        } else if (randomNumber == 1) {
            mAnswerButton2.setText(mQuestionBank.mCorrectAnswer);
            mAnswerButton1.setText(mQuestionBank.mFirstIncorrectAnswer);
            mAnswerButton3.setText(mQuestionBank.mSecondIncorrectAnswer);
        } else if (randomNumber == 2) {
            mAnswerButton3.setText(mQuestionBank.mCorrectAnswer);
            mAnswerButton1.setText(mQuestionBank.mFirstIncorrectAnswer);
            mAnswerButton2.setText(mQuestionBank.mSecondIncorrectAnswer);
        }
    }
}

