package engine.components;

public class ScalarComponent extends AbstractComponent<Float> {
    private final float value;

    public ScalarComponent(float value, ComponentType type) {
        super(type);
        this.value = value;
    }

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s: %.3f", super.toString(), value);
    }
}
