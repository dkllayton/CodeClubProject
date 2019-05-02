import gfx.Window;
import org.lwjgl.Version;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengles.GLES;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.system.Configuration;
import ui.Keyboard;
import ui.Mouse;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Hello World", 900, 900);
        Configuration.OPENGLES_EXPLICIT_INIT.set(true);
        GLES.create(GL.getFunctionProvider());
        GLES.createCapabilities();

        Mouse mouse = new Mouse(window);
        Keyboard keyboard = new Keyboard(window);

        while (!window.shouldClose()) {
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
            GLES20.glClearColor(0.0f, 1.0f, 1.0f, 1.0f);

            System.out.println(mouse.getPosition().toString());

            window.update();
        }

        window.close();

        System.out.println(Version.getVersion());
    }
}
