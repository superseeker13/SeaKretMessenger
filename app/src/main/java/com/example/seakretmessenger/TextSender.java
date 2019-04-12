package com.example.seakretmessenger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/*
*  Singleton used to send the message to the server over http.
*  I am not sure at the moment where to store the contact list
*  or if we should use one at all.
 */

class TextSender {
    private static final TextSender ourInstance = new TextSender();
    //private static List contactList = new LinkedList();

    private TextSender() {
    }

    static TextSender getInstance() {
        return ourInstance;
    }

    /*
    * Sends the message given to upstream to be converted to a bitmap.
    *
    * //TODO: Add encryption
     */

    protected boolean sendLogin(String message, String username){
        try {
            URL serverUrl = new URL(message); //Hack FIx
            HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
            con.setRequestMethod("POST");
            con.addRequestProperty("Username", username);
            con.setConnectTimeout(60 * 1000);
            int status = con.getResponseCode();
            if(status < 299){
                con.connect();
                con.disconnect();
                return true;
            }
            con.disconnect();
            return false;
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        return false;
    }

    protected boolean sendMessage(String message, String dest, String username){
        try {
            URL serverUrl = new URL(message); //Hack FIx
            HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
            con.setRequestMethod("POST");
            con.addRequestProperty("Username", username);
            con.addRequestProperty("Destination", dest);
            con.setConnectTimeout(60 * 1000);
            int status = con.getResponseCode();
            if(status < 299){
                con.connect();
                con.disconnect();
                return true;
            }
                return false;
            } catch (IOException e) {
                System.err.println(e.toString());
            }
        return false;
    }
}
