package converter;

import java.io.UnsupportedEncodingException;
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
                System.out.print('\n');
                System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                String input = scanner.next();
                while (!"/back".equals(input)) {
                    if ("0".equals(input)) {
                        System.out.println("Conversion result: 0");
                        System.out.print('\n');
                        System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                        input = scanner.next();
                    } else if ("10".equals(target)) {
                        BigInteger decimal = ToDecimal.convert(input, Integer.parseInt(source));
                        System.out.println("Conversion result: " + decimal);
                        System.out.print('\n');
                        System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                        input = scanner.next();
                    } else if ("10".equals(source)) {
                        BigInteger decimal = new BigInteger(input);
                        String result = FromDecimal.convert(decimal, Integer.parseInt(target));
                        System.out.println("Conversion result: " + result);
                        System.out.print('\n');
                        System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", source, target);
                        input = scanner.next();
                    } else {
                        BigInteger decimal = ToDecimal.convert(input, Integer.parseInt(source));
                        String result = FromDecimal.convert(decimal, Integer.parseInt(target));
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
