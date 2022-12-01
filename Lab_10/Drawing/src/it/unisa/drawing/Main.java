package it.unisa.drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 300;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CircleComponent bigCircle = new CircleComponent(Color.blue, Color.blue, frame.getWidth(), 0, 0);
        frame.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                bigCircle.setSize(frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

        String[] options = {"Una circonferenza con un certo raggio", "Due cerchi pieni: uno rosa e uno viola", "Una grande ellisse"};
        String userSelection = (String)JOptionPane.showInputDialog(null, "Cosa vuoi disegnare?",
                "Ellissi", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (userSelection) {
            case "Una circonferenza con un certo raggio" -> {
                String input = JOptionPane.showInputDialog("radius:");
                float radius = Float.parseFloat(input);
                CircleComponent emptyCircle = new CircleComponent(radius, 0, 0);
                frame.add(emptyCircle);
                frame.setVisible(true);
            }
            case "Due cerchi pieni: uno rosa e uno viola" -> {
                Color violet = new Color(238, 130, 238);
                CircleComponent pinkFullCircle = new CircleComponent(Color.pink, Color.pink, 60, 0, 0);
                CircleComponent violetFullCircle = new CircleComponent(violet, violet, 60, 0, 60);
                frame.add(pinkFullCircle);
                frame.setVisible(true);
                frame.add(violetFullCircle);
                frame.setVisible(true);
            }
            case "Una grande ellisse" -> {
                frame.add(bigCircle);
                frame.setVisible(true);
            }
        }

    }
}