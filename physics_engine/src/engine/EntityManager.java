package engine;

import engine.entities.Entity;
import engine.systems.System;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManager {
    private List<Entity> entities;
    private Map<System.SystemType, System> systems;
    private Renderer renderer;

    public EntityManager() {
        entities = new ArrayList<>();
        systems = new HashMap<>();
        renderer = new Renderer();
    }

    public void update() {
        for (System system : systems.values()) {
            system.act();
        }
    }

    public void registerEntity(Entity e, System.SystemType ... systemTypes) {
        entities.add(e);
        for (System.SystemType type : systemTypes) {
            systems.get(type).addEntity(e);
        }
    }

    public void addSystem(System s) {
        systems.put(s.getType(), s);
    }

    public void render(Graphics2D g2d, float alpha) {
        for (Entity e : entities) {
            renderer.render(e, g2d, alpha);
        }
    }
}
