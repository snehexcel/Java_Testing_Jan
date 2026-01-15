
package package1;

public class TC001 {

    private static double Width = 20.0;
    private static double Height = 10.0;
    private static double Depth = 10.0;
    private static int boxid;

    public static double volume() {
        return Width * Height * Depth;
    }

    public static void main(String[] args) {
        System.out.println("Volume: " + volume());
    }
}
