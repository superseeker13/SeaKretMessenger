package com.example.seakretmessenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //On button press, will transition to receive screen
        Button receive_activity_button = findViewById(R.id.receive_activity_button);
        receive_activity_button.setOnClickListener((view) ->
                startActivity(new Intent(ActivityMenu.this, ActivityReceive.class)));

        //On button press, will transition to send screen
        Button send_activity_button = findViewById(R.id.send_activity_button);
        send_activity_button.setOnClickListener((view) ->
                 startActivity(new Intent(ActivityMenu.this, ActivitySend.class)));
    }
}