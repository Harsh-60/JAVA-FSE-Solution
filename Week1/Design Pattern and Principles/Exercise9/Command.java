// Command.java  (Command Interface)
public interface Command {
    void execute();
}

// ── Receiver ─────────────────────────────────────────────────────────────
class Light {
    private String location;
    public Light(String location) { this.location = location; }

    public void turnOn()  { System.out.println(location + " light is ON."); }
    public void turnOff() { System.out.println(location + " light is OFF."); }
}

// ── Concrete Commands ────────────────────────────────────────────────────
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }

    @Override public void execute() { light.turnOn(); }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) { this.light = light; }

    @Override public void execute() { light.turnOff(); }
}

// ── Invoker ──────────────────────────────────────────────────────────────
class RemoteControl {
    private Command command;

    public void setCommand(Command command) { this.command = command; }

    public void pressButton() {
        command.execute();
    }
}
