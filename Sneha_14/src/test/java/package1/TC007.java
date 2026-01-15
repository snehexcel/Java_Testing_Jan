package package1;


public class TC007 {

		static int intNum1 = 3;
		static int intNum2;
	static {
		System.out.println("Static block initialized.");
		intNum2 = intNum1 * 4;
	}
	static void myMethod(int intNum3) {
		System.out.println("Number3 =" + intNum3);
		System.out.println("Number1 ="+ intNum1);
		System.out.println("Number2 =" + intNum2);
	}
	

	public static void main(String[] args) {
		System.out.println("First Name : Sneha");
		System.out.println("Last Name : Kumari");
		System.out.println("Gender : Female");
		System.out.println("Age : 22");
		System.out.println("Weight : 51");

		myMethod(10);

	}

}
