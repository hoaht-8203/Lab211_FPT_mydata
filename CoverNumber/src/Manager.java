
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class Manager {
    public static void covertDisplay(String base1, String base2, String num, String result) {
        System.out.println("------------------------------------------------------");
        System.out.println("RESULT:");
        System.out.println(num + "(" + base1.toUpperCase() + ") = " + result + " (" + base2 + ")");
        System.out.println("------------------------------------------------------");
    }
    
    public static String binaryToDecimal(String number) {
        BigInteger result = new BigInteger(number, 2);
        return result.toString();
    }
    
    public static String binaryToHex(String number) {
        BigInteger result = new BigInteger(binaryToDecimal(number));
        return result.toString(16).toUpperCase();
    }
    
    public static String decimalToBinary(String number) {
        BigInteger result = new BigInteger(number);
        return result.toString(2);
    }
    
    public static String decimalToHex(String number) {
        BigInteger result = new BigInteger(number);
        return result.toString(16);
    }
    
    public static String hexToBinary(String number) {
        BigInteger result = new BigInteger(number, 16);
        return result.toString(2);
    }
    
    public static String hexToDecimal(String number) {
        BigInteger result = new BigInteger(number, 16);
        return result.toString();
    }
}
