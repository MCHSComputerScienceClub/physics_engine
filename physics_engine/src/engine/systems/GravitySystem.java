package engine.systems;

import engine.components.Component;
import engine.entities.Entity;
import util.Constants;
import util.Vector2;

import java.util.ArrayList;
import java.util.List;

public class GravitySystem extends AbstractSystem {
    private static final List<Component.ComponentType> requiredComponentTypes = new ArrayList<>();
    static {
        requiredComponentTypes.add(Component.ComponentType.POSITION);
        requiredComponentTypes.add(Component.ComponentType.FORCE);
        requiredComponentTypes.add(Component.ComponentType.MASS);
    }

    public GravitySystem() {
        super(SystemType.GRAVITY);
    }

    @Override
    public void act() {
        for (int i = 0; i < entities.size() - 1; i++) {
            for (int j = i + 1; j < entities.size(); j++) {
                Entity e1 = entities.get(i);
                Entity e2 = entities.get(j);

                float distance = e1.getVectorComponent(Component.ComponentType.POSITION).distanceTo(e2.getVectorComponent(Component.ComponentType.POSITION));
                float gravityStrength = Constants.GRAVITY_STRENGTH * e1.getScalarComponent(Component.ComponentType.MASS) * e2.getScalarComponent(Component.ComponentType.MASS) / (distance * distance);
                Vector2 gravity = e2.getVectorComponent(Component.ComponentType.POSITION).iSub(e1.getVectorComponent(Component.ComponentType.POSITION)).normalize().mult(gravityStrength);
                e1.getVectorComponent(Component.ComponentType.FORCE).add(gravity);
                e2.getVectorComponent(Component.ComponentType.FORCE).add(gravity.mult(-1));
                // java.lang.System.out.printf("P1: %s | V1: %s | P2: %s | V2: %s | GS: %.3f | G: %s%n", e1.getVectorComponent(Component.ComponentType.POSITION).toString(), e1.getVectorComponent(Component.ComponentType.VELOCITY).toString(), e2.getVectorComponent(Component.ComponentType.POSITION).toString(), e2.getVectorComponent(Component.ComponentType.VELOCITY).toString(), gravityStrength, gravity.toString());
            }
        }
    }

    @Override
    protected List<Component.ComponentType> requiredComponentTypes() {
        return requiredComponentTypes;
    }
}
