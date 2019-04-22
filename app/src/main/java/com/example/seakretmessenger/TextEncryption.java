package com.example.seakretmessenger;
import java.nio.charset.StandardCharsets;
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

/*
 * @author Edward Conn
 * */

public class TextEncryption {
    private static SecretKeySpec skSpec;
    private final String algoString = "AES";
    byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    IvParameterSpec ivspec = new IvParameterSpec(iv);

    public TextEncryption(){
        try {
            skSpec = new SecretKeySpec(KeyGenerator.getInstance(algoString)
                    .generateKey().getEncoded(), algoString);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }
    
    public SecretKeySpec getSecretKeySpec(){
        return TextEncryption.skSpec;
    }
    
    public String blowFishMessageEncrypt(String message, SecretKeySpec skSpec) {
        assert message != null;
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(ENCRYPT_MODE, skSpec, ivspec);
            return new String(cipher.doFinal(message.getBytes(StandardCharsets.UTF_8)));
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
            return new String(cipher.doFinal(message.getBytes(StandardCharsets.UTF_8)));
        }catch(BadPaddingException e){
            System.err.println(e + "\n Bad Key.");
        }catch (InvalidKeyException | IllegalBlockSizeException
                | NoSuchAlgorithmException | NoSuchPaddingException 
                | InvalidAlgorithmParameterException ex) {
            System.err.println(ex);
        }
        return null;
    }
}
