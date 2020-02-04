package by.bsu.rsa.action;

import java.math.BigInteger;

public class MathHelp {
    public static long getGreatestCommonDenominator(long a, long b) {
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        if (b == 0) {
            return a;
        } else {
            return getGreatestCommonDenominator(b, a % b);
        }
    }

    public static long findModularInverse(long a, long n) {
        long i = n;
        long x = 0;
        long d = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        while (a > 1) {
            long q = a / n;
            long t = n;
            n = a % n;
            a = t;
            t = x;
            x = d - q * x;
            d = t;
        }
        return  d < 0 ? d + i : d;
    }

    public static long findModularExponentiation(long value, long power, long mod) {
        BigInteger x = BigInteger.valueOf(1);
        BigInteger y = BigInteger.valueOf(value);
        while(power > 0) {
            if(power % 2 == 1) {
                x = (x.multiply(y)).mod(BigInteger.valueOf(mod));
            }
            y = (y.multiply(y)).mod(BigInteger.valueOf(mod));
            power /= 2;
        }
        return x.mod(BigInteger.valueOf(mod)).longValue();
    }

    public static long findPowerMod(long value, long power, long mod) {
        BigInteger value1 = BigInteger.valueOf(value);
        BigInteger res = BigInteger.valueOf(1);
        String binaryString = Long.toBinaryString(power);
        for (int i = 1; i <= binaryString.length(); i++) {
            if (binaryString.charAt(binaryString.length() - i) == '1') {
                res = res.multiply(value1).mod(BigInteger.valueOf(mod));
            }
            value1 = value1.multiply(value1).mod(BigInteger.valueOf(mod));
        }
        return res.longValue();
    }
}
