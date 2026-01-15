
package package1;

public enum Gender {
    MALE('M'),
    FEMALE('F'),
    OTHER('O');

    private final char code;

    Gender(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }
    public static Gender fromChar(char c) {
        switch (Character.toUpperCase(c)) {
            case 'M': return MALE;
            case 'F': return FEMALE;
            case 'O': return OTHER;
            default: throw new IllegalArgumentException("Invalid gender code: " + c);
        }
    }

    public static Gender fromString(String s) {
        if (s == null) throw new IllegalArgumentException("Gender cannot be null");
        s = s.trim();
        if (s.length() == 1) {
            return fromChar(s.charAt(0));
        }
        switch (s.toUpperCase()) {
            case "MALE": return MALE;
            case "FEMALE": return FEMALE;
            case "OTHER": return OTHER;
            default: throw new IllegalArgumentException("Invalid gender: " + s);
        }
    }
}
