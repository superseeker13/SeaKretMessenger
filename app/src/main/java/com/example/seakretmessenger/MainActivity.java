package com.example.seakretmessenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);
        }

        //When sign in button is pressed
        public void sendLogin(View view){
            EditText editText_username = findViewById(R.id.edit_username);
            EditText editText_password = findViewById(R.id.edit_password);
            final String username = editText_username.getText().toString();
            final String password = editText_password.getText().toString();
        }


        //When send button is pressed
        public void sendMessage(View view){
            EditText editText = findViewById(R.id.edit_message);
            final String message = editText.getText().toString();
        }

        //TODO: Add contact info to message and destination.
}
