package engine.entities;

import engine.components.Component;
import engine.components.ScalarComponent;
import engine.components.VectorComponent;
import util.Vector2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericEntity implements Entity {
    private final Map<Component.ComponentType, ScalarComponent> scalarComponents;
    private final Map<Component.ComponentType, VectorComponent> vectorComponents;

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
    public boolean hasComponents(List<Component.ComponentType> types) {
        int count = 0;
        for (Component.ComponentType t : scalarComponents.keySet()) {
            if (types.contains(t)) {
                count++;
            }
        }
        for (Component.ComponentType t : vectorComponents.keySet()) {
            if (types.contains(t)) {
                count++;
            }
        }
        return count == types.size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (ScalarComponent c : scalarComponents.values()) {
            res.append(String.format("%s | ", c.toString()));
        }
        for (VectorComponent c : vectorComponents.values()) {
            res.append(String.format("%s | ", c.toString()));
        }
        return res.subSequence(0, res.length() - " | ".length()).toString();
    }
}
