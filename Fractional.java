package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Fractional {

    public static String convert(String x, int source, int target) {

        String result = "";
        if (source != 10) {
            x = toTen(x, source);
        } else {
            x = "0." + x;
        }
        if (target != 10) {
            result = fromTen(x, target);
        } else {
            result = String.valueOf(x);
        }

        return result.substring(2, 7);
    }

    public static String toTen(String x, int source) {

        String temp = "0." + x;
        BigDecimal result = BigDecimal.ZERO;

        for (int i = 1; i < temp.length() - 1; i++) {
            result = result.add(
                    new BigDecimal(String.valueOf(Character.getNumericValue(temp.charAt(i + 1)) * Math.pow(source, -i))));
        }

        result = result.setScale(5, RoundingMode.HALF_UP);
        return String.valueOf(result);
    }

    public static String fromTen(String x, int target) {

        String result = "0.";
        BigDecimal temp = new BigDecimal(x);
        BigDecimal base = new BigDecimal(String.valueOf(target));

        while (result.length() != 7) {
            temp = temp.multiply(base);
            int next = temp.intValue();
            if (next > 9) {
                result += (char) (next + 87);
            } else {
                result += next;
            }
            temp = temp.subtract(new BigDecimal(temp.intValue()));
        }

        return result;
    }
}
