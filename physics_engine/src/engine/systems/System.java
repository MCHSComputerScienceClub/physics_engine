package engine.systems;

import engine.entities.Entity;

public interface System {
    SystemType getType();

    enum SystemType {
        FORCE,
        GRAVITY,
        COLLISION
    }
    void addEntity(Entity e);
    void act();
}
