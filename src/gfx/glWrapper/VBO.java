package gfx.glWrapper;

import org.lwjgl.opengles.GLES20;

public class VBO {
    private final int[] id = new int[1];

    public VBO() { GLES20.glGenBuffers(id); }
}
