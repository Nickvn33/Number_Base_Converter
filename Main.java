package converter;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws UnsupportedEncodingException {
        // write your code here
        System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
        String source = scanner.next();
        if (!"/exit".equals(source)) {
            String target = scanner.next();

            while (!"/exit".equals(source)) {
                System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                String input = scanner.next();
                while (!"/back".equals(input)) {
                    if ("0".equals(input)) {
                        System.out.println("Conversion result: 0");
                        System.out.print('\n');
                        System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                        input = scanner.next();
                    } else if ("10".equals(target)) {
                        String[] inputSplit = input.split("[.]");
                        BigInteger decimal;
                        if ("0".equals(inputSplit[0])){
                            decimal = BigInteger.ZERO;
                        } else {
                            BigDecimal x = new BigDecimal(inputSplit[0]);
                            decimal = ToDecimal.convert(String.valueOf(x.intValue()), Integer.parseInt(source));
                        }
                        String fracional = "";
                        if (inputSplit.length > 1) {
                            fracional += "." + Fractional.convert(inputSplit[1], Integer.parseInt(source),
                                    Integer.parseInt(target));
                        }
                        System.out.println("Conversion result: " + decimal + fracional);
                        System.out.print('\n');
                        System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                        input = scanner.next();
                    } else if ("10".equals(source)) {
                        String[] inputSplit = input.split("[.]");
                        BigInteger decimal;
                        String result = "";
                        if ("0".equals(inputSplit[0])) {
                            result += "0";
                        } else {
                            decimal = new BigInteger(inputSplit[0]);
                            result += FromDecimal.convert(decimal, Integer.parseInt(target));
                        }
                        if (inputSplit.length > 1) {
                            result += "." + Fractional.convert(inputSplit[1], Integer.parseInt(source),
                                    Integer.parseInt(target));
                        }
                        System.out.println("Conversion result: " + result);
                        System.out.print('\n');
                        System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                        input = scanner.next();
                    } else {
                        String[] inputSplit = input.split("[.]");
                        String result = "";
                        if ("0".equals(inputSplit[0])){
                            result += "0";
                        } else {
                            BigInteger decimal = ToDecimal.convert(inputSplit[0], Integer.parseInt(source));
                            result += FromDecimal.convert(decimal, Integer.parseInt(target));
                        }
                        if (inputSplit.length > 1) {
                            result += "." + Fractional.convert(inputSplit[1], Integer.parseInt(source),
                                    Integer.parseInt(target));
                        }
                        System.out.println("Conversion result: " + result);
                        System.out.print('\n');
                        System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                        input = scanner.next();
                    }
                }
                System.out.print('\n');
                System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
                source = scanner.next();
                if (!"/exit".equals(source)) {
                    target = scanner.next();
                }
            }
        }
    }
}
