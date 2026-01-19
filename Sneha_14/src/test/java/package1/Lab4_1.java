package package1;
 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class Lab4_1 {
 
    public static void main(String[] args) throws IOException {
 
        String file = "C:\\\\Users\\\\Sneha.3.Kumari\\\\git\\\\Java_Testing_Jan\\\\Sneha_14\\\\src\\\\test\\\\java\\\\package1\\\\numbers.txt";
 
        
        FileReader fr = new FileReader(file);
        String data = "";
        int ch;
 
        while ((ch = fr.read()) != -1) {
            data = data + (char) ch;
        }
fr.close();
 
        
        String reversed = new StringBuilder(data).reverse().toString();
 
        
        FileWriter fw = new FileWriter(file);
        fw.write(reversed);
        fw.close();
 
        System.out.println("File reversed successfully");
    }
}