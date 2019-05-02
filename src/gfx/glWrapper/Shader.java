package gfx.glWrapper;

import org.lwjgl.opengles.GLES20;

public class Shader {
    private final int programId;

    public Shader(String vertexShader, String fragmentShader) {
        programId = GLES20.glCreateProgram();
    }
}
