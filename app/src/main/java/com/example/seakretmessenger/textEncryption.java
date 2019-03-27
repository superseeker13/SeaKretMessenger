package com.example.seakretmessenger;

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


public final class textEncryption {


    public static String blowFishMessage(String message, boolean encrypt){
        assert message != null;
        int mode = encrypt ? ENCRYPT_MODE : DECRYPT_MODE;
        try{
            KeyGenerator kg = KeyGenerator.getInstance("Blowfish");
            SecretKey sk = kg.generateKey(); //Hack set server and client keys
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(mode, sk);
            return cipher.doFinal(message.getBytes()).toString();
        }catch(Exception e){
            System.err.println(e.toString());
        }
        return null; //Fix
    }
}
