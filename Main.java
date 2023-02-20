package converter;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static String convert(int x, int base) {

        String calc = "";
        String result = "";

        while (x > 0) {
            if (x % base > 9) {
                switch (x % base) {
                    case 10:
                        calc += "A";
                        break;
                    case 11:
                        calc += "B";
                        break;
                    case 12:
                        calc += "C";
                        break;
                    case 13:
                        calc += "D";
                        break;
                    case 14:
                        calc += "E";
                        break;
                    case 15:
                        calc += "F";
                        break;
                }
            } else {
                calc += x % base;
            }
            x /= base;
        }

        for (int i = calc.length() - 1; i >= 0; i--) {
            result += calc.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.print("Enter number in decimal system: ");
        int x = scanner.nextInt();
        System.out.print("Enter target base: ");
        int base = scanner.nextInt();
        System.out.print("Conversion result: ");
        System.out.print(convert(x, base));
    }
}
