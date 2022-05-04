/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encryption;

/**
 *
 * @author mathu
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtils1 
{
    
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#!£&*^";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    
    
    
    
    public static String getSalt(int length) 
    {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) 
        {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        System.out.println("Final salt generated: " + returnValue);
        return new String(returnValue);
    }
     
     
    public static byte[] hash(char[] password, byte[] salt) 
    {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try 
        {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } 
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) 
        {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally 
        {
            spec.clearPassword();
            System.gc();
        }
    }
    
    public static String generateSecurePassword(String password, String salt) 
    {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        returnValue = Base64.getEncoder().encodeToString(securePassword);
        return returnValue;
    }
    
    public static boolean verifyUserPassword(String providedPassword,
            String securedPassword, String salt)
    {
        boolean returnValue = false;
        
        // Generate New secure password with the same salt
        String newSecurePassword = generateSecurePassword(providedPassword, salt);
        
        // Check if two passwords are equal
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        
        return returnValue;
    }
    
    
    public static void main(String [] args)
    {
        
//        String slt = getSalt(50);
//        System.out.println("");
//        System.out.println("Salg lenght: " + slt.length());
//        System.out.println("");
//        
//        String pwd = generateSecurePassword("123", slt);
//        System.out.println("");
//        System.out.println("pw length: " + pwd.length());
//        System.out.println("");
//        System.out.println("pwd salted: " + pwd);
//        
//        System.out.println("");
//        
//        
//        
//        System.out.println("--- Check password supplied against one created at start ---");
//        System.out.println("quando logghi prende la pw, e controlla la vecchia pwd+salt, con la nuova+salt fatto in passato");
//        boolean pwMatch = verifyUserPassword("123", pwd, slt);
//        System.out.println("");
//        System.out.println("pssMatch: " + pwMatch);
//        System.out.println("");
        
        String myPassword = "123";
        
        // Generate Salt. The generated value can be stored in DB. 
        String salt = PasswordUtils1.getSalt(30);
        
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils1.generateSecurePassword(myPassword, salt);
        
        // Print out protected password 
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);
        
        
        

    }
}