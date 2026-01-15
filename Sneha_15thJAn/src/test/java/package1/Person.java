
package package1;

public class Person {

    // Encapsulated fields
    private String firstName;
    private String lastName;
    private Gender gender;   // <-- enum
    private String mobile;

    // 3-arg constructor (no mobile yet)
    public Person(String fn, String ln, Gender g) {
        this.firstName = fn;
        this.lastName = ln;
        this.gender = g;
    }

    // 4-arg constructor (with mobile)
    public Person(String fn, String ln, Gender g, String m) {
        this(fn, ln, g);
        this.mobile = m;
    }

    // Getters & Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    }
