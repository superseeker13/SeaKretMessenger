package com.example.seakretmessenger;

import com.bumptech.glide.Glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;

//import pl.droidsonroids.gif.GifDrawable;

public class ActivityReceive extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
    }

    public void receiveMessage(View view){
        final String gifLocation = "http://babycakes.tk/ServerServletV2/Users/"
                + MainActivity.username +"/message.gif";
        final String errorLocation = "http://gph.to/2Gu5G0G"; //Use if an error occurs.

        //Glide stuff
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

        /*Thread thread = new Thread(() ->{
            GifDrawable gifDraw = MainActivity.tSend.getImageFromURL(MainActivity.username);
            runOnUiThread(()->{
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageDrawable(gifDraw);
                imageView.animate();
            });
        });
        thread.start();*/
    }
}
