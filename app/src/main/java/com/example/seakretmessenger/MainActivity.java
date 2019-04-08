package com.example.seakretmessenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

        final static String siteUrl = "seakret.tk";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }


        //TODO: send OAuth and set it as a header.
        //When sign in button is pressed
        public void sendLogin(View view){
            EditText editText_username = findViewById(R.id.edit_username);
            EditText editText_password = findViewById(R.id.edit_password);
            final String username = editText_username.getText().toString();
            final String password = editText_password.getText().toString();
            Thread sendThread = new Thread(()-> TextSender.getInstance()
                    .sendMessage("OAuth" + username + "," + password));
            sendThread.start();
            setContentView(R.layout.activity_menu);
        }

        //When send button is pressed
        // Lamda creates a Runnable that sends the message.
        public void sendMessage(View view){
            EditText editText = findViewById(R.id.edit_message);
            final String message = editText.getText().toString();
            Thread sendThread = new Thread(()-> TextSender.getInstance().sendMessage(message));
        }

        // Lamda creates a Runnable that recieves the message.
        public void recieveMessage(View view){
            EditText editText = findViewById(R.id.edit_message);
            final String message = editText.getText().toString();
            Thread recieveThread = new Thread(()
                     -> ImageReceiver.getInstance().getImages(siteUrl));
            recieveThread.start();
            //TODO save images.
        }

        //TODO: Add contact info to message and destination.
}
