package renderer;

import engine.EntityManager;
import engine.components.Component;
import engine.components.ScalarComponent;
import engine.components.VectorComponent;
import engine.entities.Entity;
import engine.entities.EntityFactory;
import engine.entities.GenericEntity;
import engine.systems.ForceSystem;
import engine.systems.GravitySystem;
import engine.systems.System;
import util.Vector2;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    private EntityManager manager;
    private EntityFactory entityFactory;
    private Entity entity;

    Canvas() {
        setPreferredSize(new Dimension(640, 480));
        manager = new EntityManager();
        manager.addSystem(new GravitySystem());
        manager.addSystem(new ForceSystem());
        entityFactory = new EntityFactory();
        entity = entityFactory.create(1, new Vector2(320, 0));
        manager.registerEntity(entity, System.SystemType.GRAVITY, System.SystemType.FORCE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        manager.update();
        if (entity.getVectorComponent(Component.ComponentType.POSITION).getRoundedY() > 480) {
            entity.getVectorComponent(Component.ComponentType.VELOCITY).mult(-1);
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillOval(entity.getVectorComponent(Component.ComponentType.POSITION).getRoundedX(), entity.getVectorComponent(Component.ComponentType.POSITION).getRoundedY(), 50, 50);
    }
}
