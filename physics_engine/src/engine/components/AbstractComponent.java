package engine.components;

public abstract class AbstractComponent implements Component {
    private ComponentType type;

    public AbstractComponent(ComponentType type) {
        this.type = type;
    }

    @Override
    public ComponentType getType() {
        return type;
    }
}
