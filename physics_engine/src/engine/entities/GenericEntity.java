package engine.entities;

import engine.components.Component;
import engine.components.ScalarComponent;
import engine.components.VectorComponent;
import util.Vector2;

import java.util.HashMap;
import java.util.Map;

public class GenericEntity implements Entity {
    private Map<Component.ComponentType, ScalarComponent> scalarComponents;
    private Map<Component.ComponentType, VectorComponent> vectorComponents;

    public GenericEntity() {
        scalarComponents = new HashMap<>();
        vectorComponents = new HashMap<>();
    }

    @Override
    public void addComponent(Component component) {
        if (component instanceof ScalarComponent) {
            scalarComponents.put(component.getType(), (ScalarComponent) component);
        } else if (component instanceof VectorComponent) {
            vectorComponents.put(component.getType(), (VectorComponent) component);
        } else {
            throw new IllegalArgumentException("Component is not supported.");
        }
    }

    @Override
    public float getScalarComponent(Component.ComponentType type) {
        return scalarComponents.get(type).getValue();
    }

    @Override
    public Vector2 getVectorComponent(Component.ComponentType type) {
        return vectorComponents.get(type).getValue();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (ScalarComponent c : scalarComponents.values()) {
            res.append(String.format("%s%n", c.toString()));
        }
        for (VectorComponent c : vectorComponents.values()) {
            res.append(String.format("%s%n", c.toString()));
        }
        return res.toString();
    }
}
