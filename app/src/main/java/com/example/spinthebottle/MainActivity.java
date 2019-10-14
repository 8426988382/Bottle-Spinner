package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private TextView textView;
    private Random random = new Random();

    private int lastdir;
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);

        textView = findViewById(R.id.text);
    }

    public void spinimage(View v) {


       //    MediaPlayer mp = MediaPlayer.create(this , R.raw.)

        if (!spinning) {
            int newdir = random.nextInt(2000);

            float pivotx = bottle.getWidth() / 2;
            float pivoty = bottle.getHeight() / 2;

            Animation animation = new RotateAnimation(lastdir, newdir, pivotx, pivoty);

            animation.setDuration(5000);

            animation.setFillAfter(true);


            lastdir = newdir;

            bottle.startAnimation(animation);

            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                    textView.setText("Here You Go!!! Wait for a moment!!");
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                    textView.setText("");
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        }


    }
}
