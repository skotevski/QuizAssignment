package com.bignerdranch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_france, true),
            new Question(R.string.question_stan, true),
            new Question(R.string.question_drake, true),
            new Question(R.string.question_antman, false),
            new Question(R.string.question_apple, true),
            new Question(R.string.question_thanos, false),
            new Question(R.string.question_eminem, false),

    };
    private int mCurrentIndex = 0;



    /*private Button mNextButton;
    private TextView mQuestionTextView;
    private com.bignerdranch.android.geoquiz.Question[] mQuestionBank = new com.bignerdranch.android.geoquiz.Question[] {
            new com.bignerdranch.android.geoquiz.Question(R.string.question_australia, true),
            new com.bignerdranch.android.geoquiz.Question(R.string.question_oceans, true),
            new com.bignerdranch.android.geoquiz.Question(R.string.question_mideast, false),
            new com.bignerdranch.android.geoquiz.Question(R.string.question_africa, false),
            new com.bignerdranch.android.geoquiz.Question(R.string.question_americas, true),
            new com.bignerdranch.android.geoquiz.Question(R.string.question_asia, true),
    };
    private int mCurrentIndex = 0;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
//        int question = mQuestionBank[mCurrentIndex].getTextResId();
//        mQuestionTextView.setText(question);



        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
//                int question = mQuestionBank[mCurrentIndex].getTextResId();
//                mQuestionTextView.setText(question);
                updateQuestion();
            }
        });
        updateQuestion();
    }
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }
}

