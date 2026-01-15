
package package1;

import java.util.Scanner;

public class Lab7 {

    public static void main(String[] args) {

        String firstName = "Ravindra";
        String lastName = "Manjhu";
        Gender gender = Gender.MALE; // use enum instead of char

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine().trim();
        sc.close();

        // Person now expects Gender enum
        Person obj = new Person(firstName, lastName, gender, mobile);

        System.out.println("First Name : " + obj.getFirstName());
        System.out.println("Last Name  : " + obj.getLastName());
        System.out.println("Gender     : " + obj.getGender());          // prints MALE/FEMALE/OTHER
        // If you prefer 'M'/'F'/'O':
        // System.out.println("Gender     : " + obj.getGender().getCode());

        System.out.println("Mobile     : " + obj.getMobile());
    }
}
