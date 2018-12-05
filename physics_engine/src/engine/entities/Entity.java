package engine.entities;

import engine.components.Component;
import util.Vector2;

public interface Entity {
    void addComponent(Component component);
    float getScalarComponent(Component.ComponentType type);
    Vector2 getVectorComponent(Component.ComponentType type);
}
