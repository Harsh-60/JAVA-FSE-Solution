// BuilderTest.java
public class BuilderTest {
    public static void main(String[] args) {

        // Gaming PC — all options
        Computer gamingPC = new Computer.Builder()
                .cpu("Intel i9")
                .ram("32GB")
                .storage("2TB SSD")
                .gpu("NVIDIA RTX 4090")
                .os("Windows 11")
                .build();

        // Basic office PC — minimal options
        Computer officePC = new Computer.Builder()
                .cpu("Intel i5")
                .ram("8GB")
                .storage("512GB SSD")
                .os("Windows 10")
                .build();

        System.out.println("Gaming PC  : " + gamingPC);
        System.out.println("Office PC  : " + officePC);
    }
}
