package com.example.seakretmessenger;

import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

public class NetworkUnitTest {

    @Test
    public void serverOnline(){
        final String serverURLString = "http://babycakes.tk/";
        try{
            URL serverUrl = new URL(serverURLString);
            HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
            assertNull(con.getErrorStream()); //May break
            con.connect();
            con.disconnect();
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void loginSend(){
        TextSender testSend = TextSender.getInstance();
        boolean success = testSend.sendLogin("Everything was fine","JohnSmith");
        assertTrue(success);
    }

    @Test
    public void loginMessage(){
        TextSender testSend = TextSender.getInstance();
        boolean success = testSend.sendMessage("Everything is fine","JaneDoe", "JohnSmith");
        assertTrue(success);
    }

    /*
        //Encryption and hashing tests
        @Test
        public void blowFishTest() {
            final String initMessage = "TestTest";
            final String encrypted = TextEncryption.blowFishMessageEncrypt(initMessage);
            assertNotEquals(initMessage, encrypted);
            System.out.println(initMessage + encrypted);
            //assertEquals(initMessage, TextEncryption.blowFishMessageDecrypt(encrypted.getBytes()));
        }

        @Test
        public void hashTest() {
            final String initMessage = "TestTest";
            final byte[] hashed = TextEncryption.hashMD5(initMessage);
            final byte[] hashedOne = TextEncryption.hashMD5(initMessage);
            assertNotEquals(initMessage, hashed);
            assertTrue(hashed[0] == hashedOne[0]);
    }*/
}