package converter;

import java.math.BigInteger;

public class ToDecimal {

    public static BigInteger convert(String x, int base) {

        BigInteger result = BigInteger.ZERO;

        for (int i = 1; i <= x.length(); i++) {
            if (x.charAt(x.length() - i) > '9') {
                double temp = (x.toUpperCase().charAt(x.length() - i) - 55) * Math.pow(base, i - 1);
                result = result.add(BigInteger.valueOf((long) temp));
            } else {
                double temp = (x.charAt(x.length() - i) - 48) * Math.pow(base, i - 1);
                result = result.add(BigInteger.valueOf((long) temp));
            }
        }

        return result;
    }
}
