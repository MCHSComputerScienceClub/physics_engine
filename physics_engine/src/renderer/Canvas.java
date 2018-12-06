package renderer;

import engine.EntityManager;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    private EntityManager manager;
    private float alpha;
    private int count;

    Canvas(EntityManager manager) {
        setPreferredSize(new Dimension(640, 480));
        this.manager = manager;
        alpha = 0;
        count = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        // System.out.printf("Frame: %d%n", count++);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        manager.render(g2d, alpha);
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
}
