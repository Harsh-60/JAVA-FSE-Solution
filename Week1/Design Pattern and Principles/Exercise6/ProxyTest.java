// ProxyTest.java
public class ProxyTest {
    public static void main(String[] args) {

        Image image = new ProxyImage("photo.jpg");

        System.out.println("-- First display (loads from server) --");
        image.display();

        System.out.println("\n-- Second display (uses cache) --");
        image.display();
    }
}
