package engine.systems;

import engine.components.Component;
import engine.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSystem implements System {
    private final SystemType type;
    protected final List<Entity> entities;

    public AbstractSystem(SystemType type) {
        this.type = type;
        entities = new ArrayList<>();
    }

    @Override
    public SystemType getType() {
        return type;
    }

    @Override
    public void addEntity(Entity e) {
        if (!e.hasComponents(requiredComponentTypes())) {
            throw new IllegalArgumentException(String.format("Entity [ %s ]%n    does not have the required components: %s", e, requiredComponentTypes()));
        }
        entities.add(e);
    }

    protected abstract List<Component.ComponentType> requiredComponentTypes();
}
