package com.efarrar.book_ch10_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TwoLineListItem;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable lightsAnimation;      //provides methods for drawable animations

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgFrame = findViewById(R.id.imgLights);              //instantiating the imageView
        //setting the animation-list from animation.xml as the Background property of the imgFrame ImageView
        imgFrame.setBackgroundResource(R.drawable.animation);
        //accessing the animationDrawable object by getting the view object
        lightsAnimation=(AnimationDrawable) imgFrame.getBackground();

        //adding the buttons
        Button button1 = findViewById(R.id.btnStart);
        Button button2 = findViewById(R.id.btnStop);

        /* View.OnClickListener with an Anonymous Inner Type event handler

         */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animation is started using the stop() from AnimationDrawable class
                lightsAnimation.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animation is stopped using the stop() from AnimationDrawable class
                lightsAnimation.stop();
                //Launching the Tween.java class
                startActivity(new Intent(MainActivity.this, Tween.class));
            }
        });

    }
}
