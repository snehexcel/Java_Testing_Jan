
package package1;

public class Lab6 {

    public static void main(String[] args) {

        Person obj = new Person("Ravindra", "Manjhu", Gender.MALE);

        System.out.println("Person's Details :");
        System.out.println("_____________________________________________________________________________");
        System.out.println("First Name : " + obj.getFirstName());
        System.out.println("Last Name  : " + obj.getLastName());
        System.out.println("Gender     : " + obj.getGender());
    }
}
