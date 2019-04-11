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
            assertNull(con.getErrorStream()); //May break
            con.disconnect();
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    //Encryption and hashing tests
    @Test
    public void blowFishTest() {
        final String initMessage = "TestTest";
        final byte[] encrypted = textEncryption.blowFishMessage(initMessage,true);
        assertNotEquals(initMessage, encrypted.toString());
        System.out.println(encrypted);
    }

    @Test
    public void hashTest() {
        final String initMessage = "TestTest";
        final byte[] hashed = textEncryption.hashMD5(initMessage);
        final byte[] hashedOne = textEncryption.hashMD5(initMessage);
        assertNotEquals(initMessage, hashed);
        assertTrue(hashed[0] == hashedOne[0]);
    }
}