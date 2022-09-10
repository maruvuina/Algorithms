package by.bsu.rsa.algorithm;

import by.bsu.rsa.action.MathHelp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RivestShamirAdleman {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ,!?:;.";

    private long p;

    private long q;

    private long numberMessage;

    public RivestShamirAdleman(long p, long q, long numberMessage) {
        this.p = p;
        this.q = q;
        this.numberMessage = numberMessage;
    }

    public long getPhi() {
        return (p - 1) * (q - 1);
    }

    public long getE(long phiN) {
        long e = 2;
        while (MathHelp.getGreatestCommonDenominator(e, phiN) != 1) {
            e++;
        }
        return e;
    }

    public long getD(long e, long phiN) {
        return MathHelp.findModularInverse(e, phiN);
    }

    public long encryptNumber(long e, long n) {
        return MathHelp.findModularExponentiation(numberMessage, e, n);
    }

    public long decryptNumber(long encryptedValue, long d, long n) {
        return MathHelp.findModularExponentiation(encryptedValue, d, n);
    }

    public List<String> encryptString(String value, long e, long n) {
        List<String> encryptedString = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            int index = CHARACTERS.indexOf(value.charAt(i));
            BigInteger temp = new BigInteger(String.valueOf(index));
            temp = BigInteger.valueOf(MathHelp.findModularExponentiation(temp.longValue(), e, n));
            encryptedString.add(temp.toString());
        }
        return encryptedString;
    }

    public String decryptString(List<String> value, long d, long n) {
        StringBuilder decryptedString = new StringBuilder();
        for(String string : value) {
            BigInteger temp = new BigInteger(String.valueOf(string));
            temp = BigInteger.valueOf(MathHelp.findModularExponentiation(temp.longValue(), d, n));
            int index = temp.intValue();
            decryptedString.append(CHARACTERS.charAt(index));
        }
        return decryptedString.toString();
    }
}
