package engine.systems;

import engine.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSystem implements System {
    private SystemType type;
    protected List<Entity> entities;

    public AbstractSystem(SystemType type) {
        this.type = type;
        entities = new ArrayList<>();
    }

    @Override
    public SystemType getType() {
        return type;
    }

    @Override
    public void addEntity(Entity e) {
        entities.add(e);
    }
}
