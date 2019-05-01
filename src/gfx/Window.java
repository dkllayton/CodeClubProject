package gfx;

import org.lwjgl.glfw.*;
import org.lwjgl.system.MemoryUtil;

public class Window {
    private static final int SWAP_INTERVAL = 1;

    private final long window;
    private String title;
    private int posX, posY;
    private int width, height;

    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        // Initializing GLFW
        GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) { throw new IllegalStateException("GLFW could not be initialized."); }
        GLFW.glfwDefaultWindowHints();
        // Setting OpenGL ES Window Hints
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 0);
        GLFW.glfwWindowHint(GLFW.GLFW_CLIENT_API, GLFW.GLFW_OPENGL_ES_API);
        // Creating window
        window = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (window == MemoryUtil.NULL) { throw new IllegalStateException("GLFW window could not be created."); }
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwSwapInterval(SWAP_INTERVAL);
        GLFW.glfwShowWindow(window);
        // Setting callbacks
        GLFW.glfwSetWindowSizeCallback(window, (long window, int w, int h) -> {
            Window.this.width = w;
            Window.this.height = h;
        });
        GLFW.glfwSetWindowPosCallback(window, (long window, int xpos, int ypos) -> {
            Window.this.posX = xpos;
            Window.this.posY = ypos;
        });
        // Setting window position to the center of the primary monitor
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        try { GLFW.glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);
        } catch (NullPointerException e) { e.printStackTrace(); }
    }

    public void update() {
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    public void close() {
        Callbacks.glfwFreeCallbacks(window);
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    public boolean shouldClose() { return GLFW.glfwWindowShouldClose(window); }

    public String getTitle() { return title; }
    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
