// Image.java  (Subject Interface)
public interface Image {
    void display();
}

// ── Real Subject ─────────────────────────────────────────────────────────
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();           // expensive operation
    }

    private void loadFromServer() {
        System.out.println("Loading image from remote server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// ── Proxy ────────────────────────────────────────────────────────────────
class ProxyImage implements Image {
    private String   fileName;
    private RealImage realImage;   // cached reference

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            // Lazy initialization — load only when first needed
            realImage = new RealImage(fileName);
        } else {
            System.out.println("(Cache hit) Skipping reload for: " + fileName);
        }
        realImage.display();
    }
}
