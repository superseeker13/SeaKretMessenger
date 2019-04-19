package com.example.seakretmessenger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ActivitySend extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
    }

    //When send button is pressed
    // Lamda creates a Runnable that sends the message.
    public void sendMessage(View view){
        EditText editText = findViewById(R.id.edit_message);
        final String message = editText.getText().toString();
        final String dest = editText.getText().toString();
        Thread sendThread = new Thread(
                () -> TextSender.getInstance().sendMessage(message, dest, MainActivity.username));
        sendThread.start();
    }
}
