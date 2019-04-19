package com.example.seakretmessenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final TextSender tSend = TextSender.getInstance();
    public static String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button main_activity_button = findViewById(R.id.sign_in_button);
        main_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_username = findViewById(R.id.edit_username);
                EditText editText_password = findViewById(R.id.edit_password);
                username = editText_username.getText().toString();
                final String password = editText_password.getText().toString();
                //tSend.sendLogin(password, username);
                Thread sendThread
                       = new Thread(()-> tSend.sendLogin(password, username));
                sendThread.start();
                Intent menuIntent = new Intent( MainActivity.this, ActivityMenu.class);
                startActivity(menuIntent);
            }
        });
    }
}

