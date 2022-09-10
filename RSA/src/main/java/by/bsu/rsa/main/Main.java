package by.bsu.rsa.main;

import by.bsu.rsa.algorithm.Crack;
import by.bsu.rsa.algorithm.RivestShamirAdleman;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        long p = 100003;
        long q = 100019;
        long n = p * q;
        long m = 28;
        RivestShamirAdleman rsa = new RivestShamirAdleman(p, q, m);
        long phiN = rsa.getPhi();
        long e = rsa.getE(phiN);
        long d = rsa.getD(e, phiN);
        long encryptedValue = rsa.encryptNumber(e, n);
        long decryptedValue = rsa.decryptNumber(encryptedValue, d, n);
        System.out.println("-----------------------");
        System.out.println("Number message: " + m);
        System.out.println("Decrypted message: " + decryptedValue);
        System.out.println("-----------------------");
        String string = "Hello World";
        List<String> list = rsa.encryptString(string, e, n);
        System.out.println("*********************");
        System.out.println("String message: " + string);
        System.out.println("Decrypt string: " + rsa.decryptString(list, d, n));
        System.out.println("*********************");
        System.out.println("CRACK");
        Crack crack = new Crack();
        long encryptedData = 17210368;
        long crackedValue = crack.crack(encryptedData, n);
        System.out.println("Cracked value: " + crackedValue);
    }
}
