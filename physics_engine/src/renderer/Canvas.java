package renderer;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    Canvas() {
        setPreferredSize(new Dimension(640, 480));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
    }
}
