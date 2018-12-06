package engine.systems;

import engine.components.Component;
import engine.entities.Entity;
import util.Constants;
import util.Vector2;

public class ForceSystem extends AbstractSystem {
    public ForceSystem() {
        super(SystemType.FORCE);
    }

    @Override
    public void act() {
        for (Entity e : entities) {
            e.getVectorComponent(Component.ComponentType.ACCELERATION).set(e.getVectorComponent(Component.ComponentType.FORCE).div(e.getScalarComponent(Component.ComponentType.MASS)));
            e.getVectorComponent(Component.ComponentType.VELOCITY).add(e.getVectorComponent(Component.ComponentType.ACCELERATION).mult(Constants.TIME_STEP));
            e.getVectorComponent(Component.ComponentType.POSITION).add(e.getVectorComponent(Component.ComponentType.VELOCITY).iMult(Constants.TIME_STEP));
            e.getVectorComponent(Component.ComponentType.FORCE).set(new Vector2());
        }
    }
}
