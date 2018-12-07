package engine.components;

import util.Vector2;

public class VectorComponent extends AbstractComponent<Vector2> {
    private final Vector2 value;

    public VectorComponent(Vector2 value, ComponentType type) {
        super(type);
        this.value = value;
    }

    @Override
    public Vector2 getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), value.toString());
    }
}
