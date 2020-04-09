import javax.swing.*;
import java.awt.*;

public class GraphicInterface implements Runnable , UserInterface {
    JFrame frame;
    boolean maximized;

    GraphicInterface(){

    }

    @Override
    public void ToogleFullScreen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        if (maximized) {
            device.setFullScreenWindow(null);
            maximized = false;
        } else {
            device.setFullScreenWindow(frame);
            maximized = true;
        }
    }

    @Override
    public void run() {
        frame = new JFrame("Gauffre empoisonée");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setVisible(true);
        JButton b = new JButton();

    }

    public static void main(String[] args) {
        GraphicInterface g = new GraphicInterface();

        g.run();
    }


}

