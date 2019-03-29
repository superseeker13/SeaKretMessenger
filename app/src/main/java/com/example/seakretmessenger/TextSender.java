package com.example.seakretmessenger;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/*
*  Singleton used to send the message to the server over http.
*  Should be ran on an unique thread.
*  I am not sure at the moment where to store the contact list
*  or if we should use one at all.
 */

class TextSender {
    private static final TextSender ourInstance = new TextSender();
    private static final String serverURLString = "ubuntu@ec2-3-91-230-123.compute-1.amazonaws.com";
    //private static List contactList = new LinkedList();

    private TextSender() {
    }

    static TextSender getInstance() {
        return ourInstance;
    }

    /*
    * Sends the message given to upstream to be converted to a bitmap.
    *
    * //TODO: Update server url.
    * //TODO: Add encryption on server side.
     */
    boolean sendMessage(String message){
        try {
            URL serverUrl = new URL(serverURLString); //Hack FIx
            HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
            con.setRequestMethod("POST");
            //int status = con.getResponseCode();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new BufferedOutputStream(con.getOutputStream()), StandardCharsets.UTF_8));
            String mess = textEncryption.blowFishMessage(message,true);
            writer.write(mess);
            writer.flush();
            writer.close();
            con.connect();
            con.disconnect();
            } catch (IOException e) {
                System.err.println("IOException in Sender.");
            }
        return false;
    }
}
