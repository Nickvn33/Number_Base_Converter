package converter;

public class ToDecimal {

    public static int convert(String x, int base) {

        int result = 0;

        for (int i = 1; i <= x.length(); i++) {
            if (x.charAt(x.length() - i) > '9') {
                result += (x.toUpperCase().charAt(x.length() - i) - 55) * Math.pow(base, i - 1);
            } else {
                result += (x.charAt(x.length() - i) - 48) * Math.pow(base, i - 1);
            }
        }

        return result;
    }
}
