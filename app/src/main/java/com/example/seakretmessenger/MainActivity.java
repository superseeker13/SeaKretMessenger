package com.example.seakretmessenger;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final TextSender tSend = TextSender.getInstance();
    public static Context context;
    public static String username = "";

    public static boolean displayErrorMess(Exception e, Context c){
        android.app.AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.context);
        dlgAlert.setMessage("Server Error: " + e);
        dlgAlert.setTitle("Error Message...");
        dlgAlert.setCancelable(true);
        dlgAlert.setPositiveButton("Ok",
                (DialogInterface dialog, int which) -> {dialog.dismiss();});
        dlgAlert.create().show();
        System.err.println("Security Exception: " + e);
        return true;
    }

    public static boolean displayErrorMess(String str, Context c){
        android.app.AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(MainActivity.context);
        dlgAlert.setMessage(str);
        dlgAlert.setTitle("Error Message...");
        dlgAlert.setCancelable(true);
        dlgAlert.setPositiveButton("Ok",
                (DialogInterface dialog, int which) -> {dialog.dismiss();});
        dlgAlert.create().show();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);
        Button main_activity_button = findViewById(R.id.sign_in_button);
        main_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_username = findViewById(R.id.edit_username);
                EditText editText_password = findViewById(R.id.edit_password);
                username = editText_username.getText().toString();
                String password = editText_password.getText().toString();
                Thread loginThread = new Thread(() ->{
                        try{
                            if(tSend.sendLogin(password, username)){
                                Intent menuIntent =
                                        new Intent( MainActivity.this, ActivityMenu.class);
                                startActivity(menuIntent);
                            }else {
                                Looper.prepare();
                                Handler mHandler = new Handler((mess)
                                        ->displayErrorMess("Wrong username or password.", getApplicationContext()));
                                Looper.loop();
                            }
                        }catch(SecurityException e){
                            Looper.prepare();
                            Handler mHandler= new Handler((mess)
                                    ->displayErrorMess(e,getApplicationContext()));
                            Looper.loop();
                        }
                    });
                loginThread.start();
            }
        });
    }
}