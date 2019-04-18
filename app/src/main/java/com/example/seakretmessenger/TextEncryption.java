package com.example.seakretmessenger;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*
*
* Encrypts or Decrypts the given message using the specified key
*
* Possible Exceptions:
*   import javax.crypto.IllegalBlockSizeException;
*   import javax.crypto.BadPaddingException;
*   import java.security.InvalidKeyException;
*   import java.security.NoSuchAlgorithmException;
* */

public class textEncryption {
    private final String algoString = "AES";
    private static SecretKeySpec skSpec;
    byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    IvParameterSpec ivspec = new IvParameterSpec(iv);
    
    
    public textEncryption(){
        try {
            skSpec = new SecretKeySpec(KeyGenerator.getInstance(algoString)
                    .generateKey().getEncoded(), algoString);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }
    
    public SecretKeySpec getSecretKeySpec(){
        return textEncryption.skSpec;
    }
    
    public String blowFishMessageEncrypt(String message, SecretKeySpec skSpec) {
        assert message != null;
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(ENCRYPT_MODE, skSpec, ivspec);
            try {
                return new String(cipher.doFinal(message.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException ex) {
                System.err.println("UTF-8 unsupported?");
            }
        }catch(BadPaddingException e){
            System.err.println(e + "\n Bad Key.");
        }catch(NoSuchAlgorithmException | NoSuchPaddingException 
                | IllegalBlockSizeException | InvalidKeyException 
                | InvalidAlgorithmParameterException e){
            System.err.println(e.toString());
        }
        return null;
    }

    //Not working
    public String blowFishMessageDecrypt(String message, SecretKeySpec skSpec){
        assert message != null;
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(DECRYPT_MODE, skSpec, ivspec);
            try {
                return new String(cipher.doFinal(message.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException ex) {
                System.err.println("UTF-8 unsupported?");
            }
        }catch(BadPaddingException e){
            System.err.println(e + "\n Bad Key.");
        }catch (InvalidKeyException | IllegalBlockSizeException
                | NoSuchAlgorithmException | NoSuchPaddingException 
                | InvalidAlgorithmParameterException ex) {
            System.err.println(ex);
        }
        return null;
    }
    /*
    public static String padRight(String s) {
        int padSize = 16 - (s.length() / 16);
        return String.format("%1$-" + padSize + "s", s);  
    }
    */
}
