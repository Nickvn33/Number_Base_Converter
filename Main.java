package converter;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
        String option = scanner.next();
        int x, base;
        String y = "";

        while (!"/exit".equals(option)){
            switch (option) {
                case "/from":
                    System.out.print("Enter a number in decimal system: ");
                    x = scanner.nextInt();
                    System.out.print("Enter the target base: ");
                    base = scanner.nextInt();
                    System.out.print("Conversion result: ");
                    System.out.print(FromDecimal.convert(x, base));
                    System.out.print('\n');
                    break;
                case "/to":
                    System.out.print("Enter source number: ");
                    y = scanner.next();
                    System.out.print("Enter source base: ");
                    base = scanner.nextInt();
                    System.out.print("Conversion to decimal result: ");
                    System.out.print(ToDecimal.convert(y, base));
                    System.out.print('\n');
                    break;
            }

            System.out.print('\n');
            System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
            option = scanner.next();
        }
    }
}
