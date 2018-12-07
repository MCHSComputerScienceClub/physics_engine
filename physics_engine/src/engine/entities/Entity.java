package engine.entities;

import engine.components.Component;
import util.Vector2;

import java.util.List;

public interface Entity {
    void addComponent(Component component);
    float getScalarComponent(Component.ComponentType type);
    Vector2 getVectorComponent(Component.ComponentType type);
    boolean hasComponents(List<Component.ComponentType> types);
}
