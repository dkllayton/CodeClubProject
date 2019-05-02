package gfx.glWrapper;

import org.lwjgl.opengles.GLES30;

public class VAO {
    private final int[] id = new int[1];

    public VAO() { GLES30.glGenVertexArrays(id); }
}
