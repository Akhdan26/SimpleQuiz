package org.akhdan.simplequiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;
    TextView score, question, timer;

    private Questions mQuestions = new Questions();
    private CountDownTimer countDownTimer;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;
    private boolean timerHasStarted = false;
    private TimerClass timerClass = new TimerClass(90000,1000 );


    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            r = new Random();

            answer1 = (Button) findViewById(R.id.answer1);
            answer2 = (Button) findViewById(R.id.answer2);
            answer3 = (Button) findViewById(R.id.answer3);
            answer4 = (Button) findViewById(R.id.answer4);

            score = (TextView) findViewById(R.id.score);
            question = (TextView) findViewById(R.id.question);
            timer = (TextView) findViewById(R.id.waktu);

            timerClass.start();

            score.setText("Score: " + mScore);
            updateQuestion(r.nextInt(mQuestionsLength));

            answer1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (answer1.getText() == mAnswer) {
                        mScore++;
                        score.setText("Score: " + mScore);
                        updateQuestion(r.nextInt(mQuestionsLength));
                    } else {
                        gameOver();
                    }
                }
            });

            answer2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (answer2.getText() == mAnswer) {
                        mScore++;
                        score.setText("Score: " + mScore);
                        updateQuestion(r.nextInt(mQuestionsLength));
                    } else {
                        gameOver();
                    }
                }
            });

            answer3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (answer3.getText() == mAnswer) {
                        mScore++;
                        score.setText("Score: " + mScore);
                        updateQuestion(r.nextInt(mQuestionsLength));
                    } else {
                        gameOver();
                    }
                }
            });

            answer4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (answer4.getText() == mAnswer) {
                        mScore++;
                        score.setText("Score: " + mScore);
                        updateQuestion(r.nextInt(mQuestionsLength));
                    } else {
                        gameOver();
                    }
                }
            });
//        View backgroundimage = findViewById(R.id.background);
//        Drawable background = backgroundimage.getBackground();
//        background.setAlpha(220);
    }

    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuider = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuider
                .setMessage("Game Over! Score anda " +mScore+ " point.")
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        })
                .setNegativeButton("Exit Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuider.create();
        alertDialog.show();
    }

    class TimerClass extends CountDownTimer {

        public TimerClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String waktu = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            timer.setText(waktu);
        }

        @Override
        public void onFinish() {
            gameOver();
        }
    }
}