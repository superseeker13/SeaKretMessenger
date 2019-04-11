package com.example.seakretmessenger;

import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

public class NetworkUnitTest {

    @Test
    public void serverOnline(){
        final String serverURLString = "http://seakret.tk";
        try{
            URL serverUrl = new URL(serverURLString);
            HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
            assertEquals(con.getErrorStream(), null); //May break
            con.disconnect();
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    //Encryption and hashing tests
    @Test
    public void blowFishTest() {
        final String initMessage = "TestTest";
        final String encrypted = textEncryption.blowFishMessage(initMessage,true);
        assertNotEquals(initMessage, encrypted);
    }

    @Test
    public void hashTest() {
        final String initMessage = "TestTest";
        final String hashed = textEncryption.hashMD5(initMessage);
        final String hashedOne = textEncryption.hashMD5(initMessage);
        assertNotEquals(initMessage, hashed);
        assertEquals(hashed,hashedOne);
    }
}