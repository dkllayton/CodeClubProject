package math;

public class Vector2f {
    public float x, y;

    public Vector2f() { this(0.0f, 0.0f); }
    public Vector2f(float x, float y) { set(x, y); }

    public Vector2f set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2f add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2f sub(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2f mul(float x, float y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public Vector2f div(float x, float y) {
        this.x /= x;
        this.y /= y;
        return this;
    }

    public Vector2f normalize() {
        float mag = MathUtils.sqrt(x * x + y * y);
        this.x /= mag;
        this.y /= mag;
        return this;
    }

    public static Vector2f getOne() { return new Vector2f(1.0f, 1.0f); }
    public static Vector2f getZero() { return new Vector2f(0.0f, 0.0f); }
}
