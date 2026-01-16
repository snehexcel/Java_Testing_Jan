package package1;
 
public class Person1 {
    private final String firstName;
    private final String lastName;
 
    public Person1(String firstName, String lastName) {
        this.firstName = firstName == null ? "" : firstName.trim();
        this.lastName  = lastName  == null ? "" : lastName.trim();
    }
 
    public String getFullName() {
        if (firstName.isEmpty()) return lastName;
        if (lastName.isEmpty())  return firstName;
        return firstName + " " + lastName;
    }
 
    @Override
    public String toString() {
        return getFullName();
    }
}