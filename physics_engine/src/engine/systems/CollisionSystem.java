package engine.systems;

import engine.components.Component;
import engine.entities.Entity;
import util.Vector2;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem extends AbstractSystem {
    private static final List<Component.ComponentType> requiredComponentTypes = new ArrayList<>();
    static {
        requiredComponentTypes.add(Component.ComponentType.POSITION);
        requiredComponentTypes.add(Component.ComponentType.VELOCITY);
        requiredComponentTypes.add(Component.ComponentType.MASS);
        requiredComponentTypes.add(Component.ComponentType.RADIUS);
        requiredComponentTypes.add(Component.ComponentType.RESTITUTION);
    }

    public CollisionSystem() {
        super(SystemType.COLLISION);
    }

    @Override
    public void act() {
        for (int i = 0; i < entities.size() - 1; i++) {
            for (int j = i + 1; j < entities.size(); j++) {
                Entity e1 = entities.get(i);
                Entity e2 = entities.get(j);

                float r = e1.getScalarComponent(Component.ComponentType.RADIUS) + e2.getScalarComponent(Component.ComponentType.RADIUS);
                float d = e1.getVectorComponent(Component.ComponentType.POSITION).distanceTo(e2.getVectorComponent(Component.ComponentType.POSITION));
                if (d > r) { continue; }
                if (d != 0) {
                    resolveCollision(e1, e2, r - d, e2.getVectorComponent(Component.ComponentType.POSITION).iSub(e1.getVectorComponent(Component.ComponentType.POSITION)).div(d));
                } else {
                    resolveCollision(e1, e2, e1.getScalarComponent(Component.ComponentType.RADIUS), new Vector2(1, 0));
                }
            }
        }
    }

    private void resolveCollision(Entity e1, Entity e2, float penetration, Vector2 normal) {
        // java.lang.System.out.printf("P: %.3f | N: %s%n", penetration, normal.toString());
        Vector2 rv = e2.getVectorComponent(Component.ComponentType.VELOCITY).iSub(e1.getVectorComponent(Component.ComponentType.VELOCITY));
        float velAlongNormal = rv.dotProduct(normal);
        if (velAlongNormal > 0) { return; }
        float e = Math.min(e1.getScalarComponent(Component.ComponentType.RESTITUTION), e2.getScalarComponent(Component.ComponentType.RESTITUTION));
        float j = -(1 + e) * velAlongNormal;
        j /= 1 / e1.getScalarComponent(Component.ComponentType.MASS) + 1 / e2.getScalarComponent(Component.ComponentType.MASS);
        Vector2 impulse = normal.mult(j);
        e1.getVectorComponent(Component.ComponentType.VELOCITY).sub(impulse.iMult(1 / e1.getScalarComponent(Component.ComponentType.MASS)));
        e2.getVectorComponent(Component.ComponentType.VELOCITY).add(impulse.mult(1 / e2.getScalarComponent(Component.ComponentType.MASS)));

        final float percent = 0.2f;
        final float slop = 0.01f;
        Vector2 correction = normal.mult(Math.max(penetration - slop, 0) / (1 / e1.getScalarComponent(Component.ComponentType.MASS) + 1 / e2.getScalarComponent(Component.ComponentType.MASS)) * percent);
        e1.getVectorComponent(Component.ComponentType.POSITION).sub(correction.iMult(1 / e1.getScalarComponent(Component.ComponentType.MASS)));
        e2.getVectorComponent(Component.ComponentType.POSITION).add(correction.mult(1 / e2.getScalarComponent(Component.ComponentType.MASS)));
    }

    @Override
    protected List<Component.ComponentType> requiredComponentTypes() {
        return requiredComponentTypes;
    }
}
