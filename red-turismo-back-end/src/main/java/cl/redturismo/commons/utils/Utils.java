package cl.redturismo.commons.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.validator.routines.EmailValidator;


public class Utils {

	private static String instance = "AES/CBC/PKCS5PADDING";
	private static String algorithm = "AES";
	private static String encoding = "UTF-8";
	private static String initVector = "4s6z_78*/1/$56.-";
	private static String key = "26c8c3318d4b81a4";
	
    public static String encrypt(String value) {
        
    	byte[] encrypted = null;
            
			try {
			final IvParameterSpec ivParam = new IvParameterSpec(Utils.initVector
						.getBytes(Utils.encoding));
			
            final SecretKeySpec skeySpec = new SecretKeySpec(Utils.key
            		.getBytes(Utils.encoding), Utils.algorithm);

            final Cipher cipher = Cipher.getInstance(Utils.instance);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParam);

            encrypted = cipher.doFinal(value.getBytes());
            
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Base64.getEncoder().encodeToString(encrypted);            
    }

    public static String decrypt(String encrypted) {
        
    	    byte[] original = null; 
            
			try {
			final IvParameterSpec ivParameter = new IvParameterSpec(Utils.initVector
						.getBytes(Utils.encoding));
			
			final SecretKeySpec skeySpec = new SecretKeySpec(Utils.key
            		.getBytes(Utils.encoding), Utils.algorithm);

			final Cipher cipher = Cipher.getInstance(Utils.instance);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameter);

            original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return new String(original);
    }
    
    public static String generateRandomString(final int lenght) {
    	byte[] array = new byte[lenght];
        new Random().nextBytes(array);
        final String generatedString = new String(array, Charset.forName("UTF-8"));
     
        String encrypted = Utils.encrypt(generatedString.replace(" ", ""));
        if (encrypted.length() > lenght) {
        	encrypted = encrypted.substring(0, lenght);
        }
        return encrypted;
    }
    
    public static boolean validarEmail(final String email) {
    	// valido
    	return EmailValidator.getInstance().isValid(email);
    }
}
