package ui;

import gfx.Window;
import org.lwjgl.glfw.GLFW;

public class Keyboard {
    private static final int KEYBOARD_SIZE = 5048;

    private int[] keys = new int[KEYBOARD_SIZE];

    public Keyboard(Window window) {
        GLFW.glfwSetKeyCallback(window.getWindow(), (long w, int key, int scancode, int action, int mods) -> keys[key] = action);
    }

    public boolean isKeyPressed(int key) { return keys[key] == GLFW.GLFW_PRESS; }
}
