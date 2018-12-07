package renderer;

import engine.EntityManager;
import engine.entities.EntityFactory;
import engine.systems.CollisionSystem;
import engine.systems.ForceSystem;
import engine.systems.GravitySystem;
import engine.systems.System;
import util.Constants;
import util.Vector2;

import javax.swing.*;

public class Window {
    private final JFrame frame;

    private final EntityManager manager;
    private final EntityFactory entityFactory;

    public Window(String title) {
        frame = new JFrame(title);
        manager = new EntityManager();
        manager.addSystem(new GravitySystem());
        manager.addSystem(new ForceSystem());
        manager.addSystem(new CollisionSystem());
        entityFactory = new EntityFactory();
        manager.registerEntity(entityFactory.create(6e14f, new Vector2(220, 380), 15), System.SystemType.GRAVITY, System.SystemType.FORCE, System.SystemType.COLLISION);
        manager.registerEntity(entityFactory.create(6e14f, new Vector2(320, 280), 15), System.SystemType.GRAVITY, System.SystemType.FORCE, System.SystemType.COLLISION);
        manager.registerEntity(entityFactory.create(6e14f, new Vector2(420, 380), 15), System.SystemType.GRAVITY, System.SystemType.FORCE, System.SystemType.COLLISION);
        manager.registerEntity(entityFactory.create(6e14f, new Vector2(320, 350), 15), System.SystemType.GRAVITY, System.SystemType.FORCE, System.SystemType.COLLISION);
    }

    public void show() {
        final Canvas canvas = new Canvas(manager);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        float accumulator = 0;

        float frameStart = java.lang.System.nanoTime() / 1e9f;

        while (true) {
            final float currentTime = java.lang.System.nanoTime() / 1e9f;
            // java.lang.System.out.printf("FS: %.5f | CT: %.5f | AC: %.5f | DT: %.5f%n", frameStart, currentTime, accumulator, Constants.TIME_STEP);
            accumulator += currentTime - frameStart;
            frameStart = currentTime;
            accumulator = Math.min(accumulator, Constants.TIME_STEP * 20);
            while (accumulator > Constants.TIME_STEP) {
                manager.update();
                accumulator -= Constants.TIME_STEP;
            }
            canvas.setAlpha(accumulator / Constants.TIME_STEP);
            frame.repaint();
        }
    }
}
