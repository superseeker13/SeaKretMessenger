package com.example.seakretmessenger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.net.HttpURLConnection;
import java.net.URL;

public class ActivityReceive extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
    }

    public void receiveMessage(View view){
        final String gifLocation = "http://babycakes.tk/seakretApp-1.0/messManager/" + MainActivity.username;
        final String errorLocation = "http://gph.to/2Gu5G0G"; //Use if an error occurs.

        int status = 404;
        try { //Checks if username's folder exists
            URL u = new URL(gifLocation);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("HEAD");
            huc.setConnectTimeout(30 * 100);
            huc.connect();
            status = huc.getResponseCode();
            huc.disconnect();
        } catch(Exception e){}
        if(status < 299){
            //Displays Message gif
            ImageView imageView = findViewById(R.id.imageView);
            Glide.with(this).asGif().load(gifLocation).placeholder(R.drawable.tenor).into(imageView);
        }else{
            //Displays error gif
            ImageView imageView = findViewById(R.id.imageView);
            Glide.with(this).asGif().load(errorLocation).placeholder(R.drawable.tenor).into(imageView);
        }
    }
}
