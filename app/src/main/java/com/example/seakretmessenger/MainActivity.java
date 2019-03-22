package com.example.seakretmessenger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }


        //When send button is pressed
        public void sendMessage(View view){
            EditText editText = findViewById(R.id.edit_message);
            String message = editText.getText().toString();
            //String recipiet
        }
        
        //TODO: Add message lisener thread and thread stop.
        //TODO: Add contact info to message and destination.
        
}
