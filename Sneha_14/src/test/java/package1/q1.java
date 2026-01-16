package package1;
 
import java.util.Random;
 
class acco{
static String genAccNo() {
		long time = System.currentTimeMillis();
		int random = new Random().nextInt(900) + 100;
		return time+""+random;
	}
}
 
public class q1 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		acco obj = new acco();
		System.out.println("Account Number: " + obj.genAccNo());
		int random1 = new Random().nextInt(9000000)+10000000;
		System.out.println("random1: "+random1);
 
	}
 
}
 
 