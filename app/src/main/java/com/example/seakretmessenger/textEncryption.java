package com.example.seakretmessenger;

import java.io.IOException

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

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
    private static KeyGenerator kg;
    private static SecretKey sk;
    
    public textEncryption(){
        textEncryption.kg = KeyGenerator.getInstance("Blowfish");
        textEncryption.sk = kg.generateKey();
    }
    
    public getSecretKey(){
        return textEncryption.sk;
    }
    
    static String blowFishMessageEncrypt(String message, SecretKey sk){
        assert message != null;
        try{
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(ENCRYPT_MODE, sk.getBytes("UTF-8"));
            return new String(cipher.doFinal(message.getBytes()));
        }catch(IOException e){
            System.err.println(e.toString());
        }
        return null;
    }

    //Not working
    static String blowFishMessageDecrypt(String message, SecretKey sk){
        assert message != null;
        try{
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(DECRYPT_MODE, sk);
            return new String(cipher.doFinal(message));
        }catch(IOException e){
            System.err.println(e.toString());
        }
        return null; //Fix
    }

    //Destroyed after rebase needs fixed.
    //Returns unaltered string if fails.
    static byte[] hashMD5(String message){
        final String hash = "35454B055CC325EA1AF2126E27707052";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes());
            byte[] digest = md.digest();
            return digest;
        } catch(NoSuchAlgorithmException e){
            System.err.println(e);
        }
        return null;
    }
}
