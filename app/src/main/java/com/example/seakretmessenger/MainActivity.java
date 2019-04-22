package com.example.seakretmessenger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;


/*
 * @author Edward Conn
 * */
public class MainActivity extends AppCompatActivity {

    public static final MessageHandler tSend = MessageHandler.getInstance();
    public static Context context;
    public static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);
        Button main_activity_button = findViewById(R.id.sign_in_button);
        main_activity_button.setOnClickListener((v) -> {
            EditText editText_username = findViewById(R.id.edit_username);
            EditText editText_password = findViewById(R.id.edit_password);
            username = editText_username.getText().toString();
            String password = editText_password.getText().toString();
            Thread loginThread = new Thread(() -> {
                tSend.sendLogin(password, username);
                Intent menuIntent = new Intent( MainActivity.this, ActivityMenu.class);
                startActivity(menuIntent);
            });
            loginThread.start();
        });
    }
}
