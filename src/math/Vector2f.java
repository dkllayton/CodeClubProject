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

    public Vector2f add(Vector2f other) {
        return this.add(other.x, other.y);
    }

    public Vector2f sub(Vector2f other) {
        return this.sub(other.x, other.y);
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

    public Vector2f mul(float f) {
        return mul(f, f);
    }

    public Vector2f div(float f) {
        return div(f, f);
    }

    public float dot(float x, float y) {
        return this.x * x + this.y * y;
    }

    public float dot(Vector2f other) {
        return dot(other.x, other.y);
    }

    public float getLength() {
        return MathUtils.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2f normalize() {
        float mag = this.getLength();
        if (mag == 0) {
            return this;
        }
        this.x /= mag;
        this.y /= mag;
        return this;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static Vector2f getIVector() { return new Vector2f(1.0f, 0.0f); }
    public static Vector2f getJVector() { return new Vector2f(0.0f, 1.0f); }
    public static Vector2f getOne() { return new Vector2f(1.0f, 1.0f); }
    public static Vector2f getZero() { return new Vector2f(0.0f, 0.0f); }
}
