package by.bsu.rsa.algorithm;

import by.bsu.rsa.action.MathHelp;

public class Crack {

    private boolean isSquare(long n) {
        long squareNumber = (long) Math.sqrt(n);
        return squareNumber * squareNumber == n || (squareNumber + 1) * (squareNumber + 1) == n;
    }

    private long[] getFactors(long n) {
        long a = (long) Math.ceil(Math.sqrt(n));
        long b = a * a - n;
        while (!isSquare(b)) {
            a++;
            b = a * a - n;
        }
        long p = a - (long) Math.sqrt(b);
        long q = n / p;
        return new long[]{p, q};
    }

    private long getE(long phiN) {
        long e = 2;
        while (MathHelp.getGreatestCommonDenominator(e, phiN) != 1) {
            e++;
        }
        return e;
    }

    public long crack(long value, long n) {
        long[] factors = getFactors(n);
        long phiN = (factors[0] - 1)*(factors[1] - 1);
        long d = MathHelp.findModularInverse(getE(phiN), phiN);
        return MathHelp.findModularExponentiation(value, d, n);
    }
}
