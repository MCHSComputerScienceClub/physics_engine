package engine.components;

public interface Component {
    ComponentType getType();

    enum ComponentType {
        POSITION_COMPONENT
    }
}
