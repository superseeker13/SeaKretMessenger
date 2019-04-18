package com.example.seakretmessenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //When sign in button is pressed
    public void sendLogin(View view){
        EditText editText_username = findViewById(R.id.edit_username);
        EditText editText_password = findViewById(R.id.edit_password);
        username = editText_username.getText().toString();
        String password = editText_password.getText().toString();
        Thread sendThread
                = new Thread(()-> TextSender.getInstance().sendLogin(password, username));
        sendThread.start();
        setContentView(R.layout.activity_menu);
    }
}

