package engine;

import engine.entities.Entity;
import engine.systems.System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManager {
    List<Entity> entities;
    Map<System.SystemType, System> systems;

    public EntityManager() {
        entities = new ArrayList<>();
        systems = new HashMap<>();
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
}
