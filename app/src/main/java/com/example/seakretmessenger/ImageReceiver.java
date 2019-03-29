package com.example.seakretmessenger;

import android.media.Image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

class ImageReceiver {
    private static final ImageReceiver ourInstance = new ImageReceiver();

    private ImageReceiver() {
    }

    static ImageReceiver getInstance() {
        return ourInstance;
    }

    synchronized LinkedList<Image> getImages(String urlString) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(urlString).openConnection();
            con.setRequestMethod("GET");
            con.setReadTimeout(60 * 1000);
            con.setConnectTimeout(60 * 1000);

            int status = con.getResponseCode();
            Reader streamReader;

            if (status > 299) {
                streamReader = new InputStreamReader(con.getErrorStream());
            } else {
                streamReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }

            LinkedList<Image> imagesList = copyInputStream(streamReader);
            con.disconnect();
            return imagesList;

        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }

    /*
     * Copies the images from the input stream
     * //TODO: Add check for images
     *
     * //TODO: Try inverting screen to blob image : Low polity
     */

    private synchronized LinkedList<Image> copyInputStream(Reader streamReader) {
        LinkedList<Image> result = new LinkedList<>();
        //while(streamReader.){
        //}
        return result;
    }
}
