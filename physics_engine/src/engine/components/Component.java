package engine.components;

public interface Component<T> {
    ComponentType getType();

    enum ComponentType {
        POSITION,
        VELOCITY,
        ACCELERATION,
        FORCE,
        MASS,
        PREV_POSITION,
        RADIUS,
        RESTITUTION
    }

    T getValue();
}
