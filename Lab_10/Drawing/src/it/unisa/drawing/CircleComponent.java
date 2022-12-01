package it.unisa.drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleComponent extends JComponent {

    private final Ellipse2D.Double circle;
    private final Ellipse2D.Double circleBorder;
    private final Color fillColor;
    private final Color borderColor;

    public CircleComponent(float radius, float x, float y) {
        this.fillColor = new Color(0, 0, 0, 1);
        this.borderColor = Color.BLACK;
        this.circle = new Ellipse2D.Double(x, y, radius, radius);
        this.circleBorder = new Ellipse2D.Double(x, y, radius, radius);
    }

    public CircleComponent(Color fillColor, Color borderColor, float radius, float x, float y) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.circle = new Ellipse2D.Double(x, y, radius, radius);
        this.circleBorder = new Ellipse2D.Double(x, y, radius, radius);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(fillColor);
        g2.fill(circle);
        g2.setColor(borderColor);
        g2.draw(circleBorder);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        circle.setFrame(circle.getX(), circle.getY(), width, height);
        circleBorder.setFrame(circleBorder.getX(), circleBorder.getY(), width, height);
        repaint();
    }
}
