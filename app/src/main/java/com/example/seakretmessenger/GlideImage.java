package com.example.seakretmessenger;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.io.File;

public class GlideImage extends AppCompatActivity{
    private ImageView gifImageView;

    // Loads from URL as a GIF
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glidetest);


        gifImageView = (ImageView) findViewById(R.id.img_gif); // img_gif references xml in glidetest

        //loadFromURL();
        loadFromFile();
    }

    // Loads a simple address
    private void loadFromURL(){
        String internetURL = "https://techcrunch.com/wp-content/uploads/2015/08/safe_image.gif"; // Enter URL of gif here
        Glide.with(this).load(internetURL).into(gifImageView);
    }

    // Loads dog.gif from /app/res/drawable/
    private void loadFromFile(){
        Glide.with(this).load(R.drawable.dog).into(gifImageView);
    }
}