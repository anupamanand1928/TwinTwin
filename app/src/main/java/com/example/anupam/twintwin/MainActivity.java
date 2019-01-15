package com.example.anupam.twintwin;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView image1,image2,image3,image4,imageMain;
    TextView tv_status;
    Button b_next;

    Integer[] images = {
            R.drawable.redcircle,
            R.drawable.bluecircle,
            R.drawable.blackcircle,
            R.drawable.redtriangle,
            R.drawable.bluetriangle,
            R.drawable.blacktriangle,
            R.drawable.redsquare,
            R.drawable.bluesquare,
            R.drawable.blacksquare,
    };

    Integer[] images_bw = {
            R.drawable.redcircle,
            R.drawable.bluecircle,
            R.drawable.blackcircle,
            R.drawable.redtriangle,
            R.drawable.bluetriangle,
            R.drawable.blacktriangle,
            R.drawable.redsquare,
            R.drawable.bluesquare,
            R.drawable.blacksquare,
    };

    Integer[] image_numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    int turn = 0;
    int correctAnswer = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        imageMain = (ImageView) findViewById(R.id.imageMain);

        tv_status = (TextView) findViewById(R.id.tv_status);

        b_next = (Button) findViewById(R.id.b_next);

        Collections.shuffle(Arrays.asList(image_numbers));

        setImages();

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctAnswer == 1) {
                    score +=10;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);
                } else {
                    tv_status.setText("Wrong");
                    b_next.setVisibility(View.VISIBLE);
                }

                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctAnswer == 2) {
                    score +=10;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);
                } else {
                    tv_status.setText("Wrong");
                    b_next.setVisibility(View.VISIBLE);
                }

                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctAnswer == 3) {
                    score +=10;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);
                } else {
                    tv_status.setText("Wrong");
                    b_next.setVisibility(View.VISIBLE);
                }

                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctAnswer == 4) {
                    score +=10;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);
                } else {
                    tv_status.setText("Wrong");
                    b_next.setVisibility(View.VISIBLE);
                }

                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn++;
                if(turn == 9){
                    checkEnd();
                } else {
                    setImages();
                }
            }
        });
    }

    private void setImages() {
        Random r = new Random();
        correctAnswer = r.nextInt(4) + 1;

        int wrongAnswer1, wrongAnswer2, wrongAnswer3, wrongAnswer4;

        do{
            wrongAnswer1 = r.nextInt(9);

        } while (wrongAnswer1 == image_numbers[turn]);

        do{
            wrongAnswer2 = r.nextInt(9);

        } while (wrongAnswer2 == image_numbers[turn] || wrongAnswer2 == wrongAnswer1);

        do{
            wrongAnswer3 = r.nextInt(9);

        } while (wrongAnswer3 == image_numbers[turn] || wrongAnswer3 == wrongAnswer2 || wrongAnswer3 == wrongAnswer1);

        switch (correctAnswer) {
            case 1:
                image1.setImageResource(images[image_numbers[turn]]);
                image2.setImageResource(images[wrongAnswer1]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 2:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[image_numbers[turn]]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 3:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[image_numbers[turn]]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 4:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[wrongAnswer3]);
                image4.setImageResource(images[image_numbers[turn]]);
                break;
        }

        imageMain.setImageResource(images_bw[image_numbers[turn]]);

        tv_status.setText("");
        b_next.setVisibility(View.INVISIBLE);

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);

    }

    private void checkEnd() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Game Over ! Score: " + score );
        alertDialogBuilder.setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
