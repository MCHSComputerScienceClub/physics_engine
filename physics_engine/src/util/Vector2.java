package util;

public class Vector2 {
    private float x, y;

    public Vector2() {
        this(0, 0);
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public Vector2 mult(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    public Vector2 iMult(float scalar) {
        return new Vector2(this.x * scalar, this.y * scalar);
    }

    public Vector2 div(float scalar) {
        this.x /= scalar;
        this.y /= scalar;
        return this;
    }

    public Vector2 set(Vector2 other) {
        this.x = other.x;
        this.y = other.y;
        return this;
    }

    public int getRoundedX() { return Math.round(x); }
    public int getRoundedY() { return Math.round(y); }

    @Override
    public String toString() {
        return String.format("<x: %.3f, y: %.3f>", x, y);
    }
}
