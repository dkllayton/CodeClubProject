import gfx.Window;
import org.lwjgl.Version;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Hello World", 900, 900);

        while (!window.shouldClose()) {
            window.update();
        }

        window.close();

        System.out.println(Version.getVersion());
    }
}
