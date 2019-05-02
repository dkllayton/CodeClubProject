package ui;

import gfx.Window;
import math.Vector2f;
import org.lwjgl.glfw.GLFW;

public class Mouse {
    private static final int MOUSE_BUTTONS = 16;

    private Vector2f position = new Vector2f();
    private int[] buttonStates = new int[MOUSE_BUTTONS];
    private Vector2f scroll = new Vector2f();

    public Mouse(Window window) {
        GLFW.glfwSetCursorPosCallback(window.getWindow(), (long w, double xpos, double ypos) -> position.set((float) xpos, (float) ypos));
        GLFW.glfwSetMouseButtonCallback(window.getWindow(), (long w, int button, int action, int mods) -> buttonStates[button] = action);
        GLFW.glfwSetScrollCallback(window.getWindow(), (long w, double xoffset, double yoffset) -> scroll.set((float) xoffset, (float) yoffset));
    }

    public Vector2f getPosition() { return position; }
    public boolean isButtonPressed(int button) { return buttonStates[button] == GLFW.GLFW_PRESS; }
    public Vector2f getScroll() { return scroll; }
}
