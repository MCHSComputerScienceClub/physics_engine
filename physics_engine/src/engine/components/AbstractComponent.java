package engine.components;

public abstract class AbstractComponent<T> implements Component<T> {
    private final ComponentType type;

    public AbstractComponent(ComponentType type) {
        this.type = type;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
