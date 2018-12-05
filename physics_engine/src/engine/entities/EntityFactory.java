package engine.entities;

import engine.components.Component;
import engine.components.ScalarComponent;
import engine.components.VectorComponent;
import util.Vector2;

public class EntityFactory {
    public Entity create(float mass, Vector2 position) {
        Entity entity = new GenericEntity();
        entity.addComponent(new ScalarComponent(mass, Component.ComponentType.MASS));
        entity.addComponent(new VectorComponent(new Vector2(), Component.ComponentType.FORCE));
        entity.addComponent(new VectorComponent(new Vector2(), Component.ComponentType.ACCELERATION));
        entity.addComponent(new VectorComponent(new Vector2(), Component.ComponentType.VELOCITY));
        entity.addComponent(new VectorComponent(position, Component.ComponentType.POSITION));
        return entity;
    }
}
