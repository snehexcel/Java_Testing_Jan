package package1;
 
import java.io.FileInputStream;
import java.io.IOException;
 
public class TC_FileIO {
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Sneha.3.Kumari\\git\\Java_Testing_Jan\\Sneha_14\\src\\test\\java\\package1\\sampleinput.txt");
		
		int data;
		while((data=fis.read())!=-1)
		{
			System.out.println((char)data);
		}
		
		fis.close();
		
 
	}
 
}