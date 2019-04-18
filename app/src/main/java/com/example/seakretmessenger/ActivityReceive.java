package com.example.seakretmessenger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ActivityReceive extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
    }

    public void receiveMessage(View view){
        final String gifLocation = "https://media.giphy.com/media/SozBhzSOBEqfC/giphy.gif";
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load(gifLocation).into(imageView);
    }

}
