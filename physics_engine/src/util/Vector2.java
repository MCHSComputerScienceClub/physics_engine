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

    public Vector2 sub(Vector2 other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }

    public Vector2 iSub(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
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

    public float dotProduct(Vector2 other) {
        return this.x * other.x + this.y * other.y;
    }

    public float magnitude() {
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Vector2 normalize() {
        return this.div(this.magnitude());
    }

    public float distanceTo(Vector2 other) {
        return (float) Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public Vector2 set(Vector2 other) {
        this.x = other.x;
        this.y = other.y;
        return this;
    }

    public Vector2 copy() {
        return new Vector2(x, y);
    }

    public int getRoundedX() { return Math.round(x); }
    public int getRoundedY() { return Math.round(y); }

    @Override
    public String toString() {
        return String.format("<x: %.3f, y: %.3f>", x, y);
    }
}
