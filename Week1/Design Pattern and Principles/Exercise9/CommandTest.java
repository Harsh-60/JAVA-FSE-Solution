// CommandTest.java
public class CommandTest {
    public static void main(String[] args) {

        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight    = new Light("Bedroom");

        Command livingOn  = new LightOnCommand(livingRoomLight);
        Command livingOff = new LightOffCommand(livingRoomLight);
        Command bedOn     = new LightOnCommand(bedroomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingOn);
        remote.pressButton();   // Living Room light ON

        remote.setCommand(bedOn);
        remote.pressButton();   // Bedroom light ON

        remote.setCommand(livingOff);
        remote.pressButton();   // Living Room light OFF
    }
}
