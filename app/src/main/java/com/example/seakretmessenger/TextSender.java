package com.example.seakretmessenger;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

/*
*  Singleton used to send the message to the server over http.
*  I am not sure at the moment where to store the contact list
*  or if we should use one at all.
 */

class TextSender {
    private static final TextSender ourInstance = new TextSender();
    private String serverUrlString = "http://babycakes.tk/seakretApp-1.0/messManager";

    private TextSender() {
    }

    static TextSender getInstance() {
        return ourInstance;
    }
    /*
    * Sends the message given to upstream to be converted to a bitmap.
     */

    protected void sendLogin(String message, String username) throws SecurityException{
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(serverUrlString).openConnection();
            con.setRequestMethod("POST");
            con.addRequestProperty("Username", username);
            con.addRequestProperty("Destination", "");
            con.setConnectTimeout(60 * 1000);
            try{
                con.connect();
            }catch(SecurityException e){ //Hack fix server certificate issue.
                System.err.println("Security Exception: " + e);
            }
            con.disconnect();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    protected void sendMessage(String message, String dest, String username){
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(serverUrlString).openConnection();
            con.setRequestMethod("POST");
            con.addRequestProperty("Username", username);
            con.addRequestProperty("Destination", dest);
            con.setConnectTimeout(60 * 1000);
            try{
                con.connect();
            }catch(SecurityException e){ //Hack fix server certificate issue.
                System.err.println("Security Exception: " + e);
            }
            con.disconnect();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
