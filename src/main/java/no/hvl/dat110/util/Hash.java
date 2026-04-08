package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static BigInteger hashOf(String entity) {    
        BigInteger hashint = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            String entityHex = toHex(md.digest(entity.getBytes()));

            hashint = new BigInteger(entityHex, 16);
        } catch (NoSuchAlgorithmException err) {
            System.err.println(err);
        }
        
        return hashint;
    }
    
    public static BigInteger addressSize() {
        return BigInteger.TWO.pow(bitSize());
    }
    
    public static int bitSize() {
        int digestlen = 0;
        
        try {
            digestlen = MessageDigest.getInstance("MD5").getDigestLength();
        } catch (NoSuchAlgorithmException err) {
            System.err.println(err);
        }

        return digestlen*8;
    }
    
    public static String toHex(byte[] digest) {
        StringBuilder strbuilder = new StringBuilder();
        for(byte b : digest) {
            strbuilder.append(String.format("%02x", b&0xff));
        }
        return strbuilder.toString();
    }
}