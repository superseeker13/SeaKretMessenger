package com.example.seakretmessenger;

//import pl.droidsonroids.gif.GifDrawable;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/*
*  Singleton used to send the message to the server over http.
*  I am not sure at the moment where to store the contact list
*  or if we should use one at all.
 */

/*
 * @author Edward Conn
 * */
class MessageHandler {
    private static final MessageHandler ourInstance = new MessageHandler();
    private String serverUrlString = "http://babycakes.tk/ServerServletV2/messManager";

    private MessageHandler() {
    }

    static MessageHandler getInstance() {
        return ourInstance;
    }
    /*
    * Sends the message given to upstream to be converted to a bitmap.
     */

    protected boolean sendLogin(String pass, String username) throws SecurityException{
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(serverUrlString).openConnection();
            con.setRequestMethod("POST");
            con.addRequestProperty("Username", username);
            con.addRequestProperty("Destination", "");
            con.addRequestProperty("Password", pass);
            con.setConnectTimeout(60 * 1000);
            con.connect();
            con.disconnect();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected boolean sendMessage(String message, String dest, String username){
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(serverUrlString).openConnection();
            con.setRequestMethod("POST");
            con.addRequestProperty("Username", username);
            con.addRequestProperty("Destination", dest);
            BufferedOutputStream out = new BufferedOutputStream(con.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            writer.write(message);
            writer.flush();
            writer.close();
            out.close();
            con.connect();
            //Receive response
            String response = "", line = "";
            BufferedReader buffRead = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line=buffRead.readLine()) != null) {
                response+= line + "\n";
            }
            con.disconnect();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    GifDrawable getImageFromURL(String username){
        GifDrawable gifDraw = null;
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(serverUrlString).openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("Username", username);
            con.setConnectTimeout(60 * 1000);
            con.connect();
            // Converts the output from the server to a byte array and then a gif.
            byte[] imgArr = ((ByteArrayOutputStream)con.getOutputStream()).toByteArray();
            gifDraw = new GifDrawable(imgArr);
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gifDraw;
    }*/
}
