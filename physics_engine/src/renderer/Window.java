package renderer;

import util.Constants;

import javax.swing.*;

public class Window {
    private JFrame frame;

    public Window(String title) {
        frame = new JFrame(title);
    }

    public void show() {
        frame.setContentPane(new Canvas());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        while (true) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {}
            frame.repaint();
        }
    }
}
