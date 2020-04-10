package IHM;

import javax.swing.*;
import java.awt.*;

public class GraphicInterface implements Runnable, UserInterface {
    JFrame f;
    boolean maximized;
    public final static Dimension BUTTON_MAXSIZE = new Dimension(100,50);

    GraphicInterface() {}

    @Override
    public void ToggleFullScreen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        if (maximized) {
            device.setFullScreenWindow(null);
            maximized = false;
        } else {
            device.setFullScreenWindow(f);
            maximized = true;
        }
    }

    @Override
    public void run() {
        f = new JFrame("Gaufre Empoisonnée");

        f.setContentPane(new StartInterface().StartPanel);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f.setSize(500,300);

        // JButton b = new JButton();
        // b.setText("Test");
        // b.setBounds(130,100,100, 40);

        // f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        GraphicInterface g = new GraphicInterface();

        g.run();
    }


}
