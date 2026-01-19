package package1;
 
import java.io.*;
import java.util.Scanner;
 
public class Lab4_2 {
    public static void main(String[] args) throws IOException {
        String file = "C:\\\\Users\\\\Sneha.3.Kumari\\\\git\\\\Java_Testing_Jan\\\\Sneha_14\\\\src\\\\test\\\\java\\\\package1\\\\sampleinput.txt";
 
        
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("0,1,2,3,4,5,6,7,8,9,10");
        }
 
        try (Scanner sc = new Scanner(new File(file))) {
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                int n = Integer.parseInt(sc.next().trim());
                if (n % 2 == 0) {
                    System.out.println(n);
                }
            }
        }
    }
}
 
 
 