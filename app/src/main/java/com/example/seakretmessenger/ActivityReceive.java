package com.example.seakretmessenger;

import com.bumptech.glide.Glide;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

//import pl.droidsonroids.gif.GifDrawable;

public class ActivityReceive extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
    }

    public void receiveMessage(View view){
        final String gifLocation = "http://babycakes.tk/ServerServletV2/Users/"
                + MainActivity.username + "/message.gif";
        final String emptyLocation = "http://gph.to/2Gu5G0G"; //Use if an error occurs.

        final ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).asGif().load(gifLocation).placeholder(R.drawable.spring).into(imageView);
        Handler hand = new Handler();
        hand.postDelayed(() -> imageView.setImageResource(R.drawable.spring),5000L);
    }
}
