package engine.components;

public interface Component<T> {
    ComponentType getType();

    enum ComponentType {
        POSITION,
        VELOCITY,
        ACCELERATION,
        FORCE,
        MASS
    }

    T getValue();
}
