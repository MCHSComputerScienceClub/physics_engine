package renderer;

import engine.components.Component;
import engine.entities.Entity;
import util.Vector2;

import java.awt.*;

public class Renderer {
    public void render(Entity entity, Graphics2D g2d, float alpha) {
        Vector2 renderPosition = entity.getVectorComponent(Component.ComponentType.PREV_POSITION).mult(alpha).add(entity.getVectorComponent(Component.ComponentType.POSITION).iMult(1.0f - alpha));
        g2d.fillOval(renderPosition.getRoundedX() - Math.round(entity.getScalarComponent(Component.ComponentType.RADIUS)), renderPosition.getRoundedY() - Math.round(entity.getScalarComponent(Component.ComponentType.RADIUS)), Math.round(entity.getScalarComponent(Component.ComponentType.RADIUS) * 2), Math.round(entity.getScalarComponent(Component.ComponentType.RADIUS) * 2));
        entity.getVectorComponent(Component.ComponentType.PREV_POSITION).set(entity.getVectorComponent(Component.ComponentType.POSITION).copy());
    }
}
