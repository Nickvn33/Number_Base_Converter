package converter;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class FromDecimal {

    public static String convert(BigInteger x, int base) throws UnsupportedEncodingException {

        String calc = "";
        String result = "";
        BigInteger bigBase = new BigInteger(String.valueOf(base));

        while (x.compareTo(BigInteger.ZERO) > 0) {
            BigInteger temp;
            String digit;
            if (x.mod(bigBase).compareTo(BigInteger.TEN.subtract(BigInteger.ONE)) > 0) {
                temp = x.mod(bigBase).add(new BigInteger(String.valueOf(87)));
                digit = new String(temp.toByteArray(), "UTF-8");
            } else {
                temp = x.mod(bigBase);
                digit = temp.toString();
            }
            calc += digit;
            x = x.divide(bigBase);
        }

        for (int i = calc.length() - 1; i >= 0; i--) {
            result += calc.charAt(i);
        }

        return result;
    }
}
