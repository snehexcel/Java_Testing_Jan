package package1;

import package1.Balance;

class Balance{
	String name;
	double bal;
	
	public Balance(String n, double b) {
		
		name  = n;
		bal = b;
	}
	public void show() {
		if(bal>0) {
			System.out.println("Name :" + name + " $" + bal);
		}
	}
}

public class TC006 {

	public static void main(String[] args) {

		Balance obj = new Balance("Sneha", 60000.00);
		obj.show();
		
	}

}
