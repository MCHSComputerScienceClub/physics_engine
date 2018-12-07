package engine.systems;

import engine.components.Component;
import engine.entities.Entity;
import util.Constants;
import util.Vector2;

import java.util.ArrayList;
import java.util.List;

public class ForceSystem extends AbstractSystem {
    private static final List<Component.ComponentType> requiredComponentTypes = new ArrayList<>();
    static {
        requiredComponentTypes.add(Component.ComponentType.POSITION);
        requiredComponentTypes.add(Component.ComponentType.VELOCITY);
        requiredComponentTypes.add(Component.ComponentType.ACCELERATION);
        requiredComponentTypes.add(Component.ComponentType.FORCE);
        requiredComponentTypes.add(Component.ComponentType.MASS);
    }

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

    @Override
    protected List<Component.ComponentType> requiredComponentTypes() {
        return requiredComponentTypes;
    }
}
