
package package1;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab9 {

    public static String addToItself(String s) {
        if (s == null) s = "";
        return s + s;
    }

    public static String replaceOddPositionsWithHash(String s) {
        if (s == null) s = "";
        StringBuilder out = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            out.append(i % 2 == 0 ? '#' : s.charAt(i));
        }
        return out.toString();
    }

    public static String removeDuplicates(String s) {
        if (s == null) s = "";
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder out = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (seen.add(c)) {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static String changeOddCharsToUpper(String s) {
        if (s == null) s = "";
        StringBuilder out = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            out.append(i % 2 == 0 ? Character.toUpperCase(s.charAt(i)) : s.charAt(i));
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\n--- Running all operations one by one ---");
        System.out.println("1) Add to itself              : " + addToItself(input));
        System.out.println("2) Replace odd with '#'       : " + replaceOddPositionsWithHash(input));
        System.out.println("3) Remove duplicates          : " + removeDuplicates(input));
        System.out.println("4) Odd chars to UPPERCASE     : " + changeOddCharsToUpper(input));

        sc.close();
    }
}
