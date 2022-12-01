package it.unisa.drawing;

import javax.swing.*;
import java.awt.*;

public class ColoredSquareComponent extends JComponent {

    private final Color fillColor;

    public ColoredSquareComponent(Color aColor) {
        fillColor = aColor;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Select color into graphics context
        g2.setColor(fillColor);

        // Construct and fill a square whose center is the center of the window
        final int SQUARE_LENGTH = 100;

        Rectangle square = new Rectangle(
                (getWidth() - SQUARE_LENGTH) / 2,
                (getHeight() - SQUARE_LENGTH) / 2,
                SQUARE_LENGTH,
                SQUARE_LENGTH);

        g2.fill(square);
    }
}
