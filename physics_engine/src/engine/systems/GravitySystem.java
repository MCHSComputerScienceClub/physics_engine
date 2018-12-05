package engine.systems;

import engine.components.Component;
import engine.entities.Entity;
import util.Vector2;

public class GravitySystem extends AbstractSystem {
    public GravitySystem() {
        super(SystemType.GRAVITY);
    }

    @Override
    public void act() {
        for (Entity e : entities) {
            e.getVectorComponent(Component.ComponentType.FORCE).add(new Vector2(0, 0.98f).mult(e.getScalarComponent(Component.ComponentType.MASS)));
        }
    }
}
