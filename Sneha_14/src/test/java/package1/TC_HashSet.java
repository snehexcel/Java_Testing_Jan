package package1;

import java.util.HashSet;
import java.util.TreeSet;

public class TC_HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> numbers=new HashSet<>();
		numbers.add(10);
		numbers.add(2);
		numbers.add(5);
		numbers.add(3);
		numbers.add(10);
		numbers.add(2);
		numbers.add(5);
		numbers.add(3);
		
		System.out.println(numbers);
	}

}
