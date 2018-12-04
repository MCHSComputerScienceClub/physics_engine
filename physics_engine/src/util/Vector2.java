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

    public void add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void mult(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }
}
