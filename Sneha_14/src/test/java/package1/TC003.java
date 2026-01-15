package package1;

import package1.Box;

class Box{
	double width = 10;
	double height = 20;
	double depth = 10;
	
	double calvolume() {
		return width * height * depth ;
	}
}

public class TC003{
	

	public static void main(String[] args) {

		Box obj = new Box();
		System.out.println(obj.calvolume());
	}

}
