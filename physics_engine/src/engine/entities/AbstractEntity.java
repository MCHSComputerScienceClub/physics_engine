package engine.entities;

import engine.components.Component;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEntity implements Entity {
    private Map<Component.ComponentType, Component> components;

    public AbstractEntity() {
        components = new HashMap<>();
    }

    @Override
    public void addComponent(Component component) {
        components.put(component.getType(), component);
    }

    @Override
    public Component getComponent(Component.ComponentType type) {
        return components.get(type);
    }
}
