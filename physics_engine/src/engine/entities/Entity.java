package engine.entities;

import engine.components.Component;

public interface Entity {
    void addComponent(Component component);
    Component getComponent(Component.ComponentType type);
}
