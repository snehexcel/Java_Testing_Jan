package package1;

import java.util.Scanner;

public class TC005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        int n = sc.nextInt();
        sc.close();

        if (n > 0) {
            System.out.println(n + " is positive");
        } else if (n < 0) {
            System.out.println(n + " is negative");
        } else {
            System.out.println(n + " is zero");
        }
    }

}