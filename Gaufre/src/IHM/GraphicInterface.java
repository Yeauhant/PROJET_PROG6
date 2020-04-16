package IHM;

import Arbitre.Board;

import javax.swing.*;
import java.awt.*;

public class GraphicInterface implements Runnable, UserInterface {
    JFrame f;
    boolean maximized;
    Board b;
    EventsCollector e;


    public GraphicInterface() {}
    public GraphicInterface(Board b, EventsCollector e){
        this.b = b;
        this.e = e;
    }

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
        // VARIABLES TEMPORAIRES
        final int COLN = b.get_width();
        final int ROWN = b.get_height();
        // ====================

        GameInterface game = new GameInterface(COLN, ROWN);
        game.fill();

        f = new JFrame("Gaufre Empoisonnée");
        f.setContentPane(game.panelMain);
        f.setMinimumSize(new Dimension(300+COLN*20,200+ROWN*20));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    // FONCTION TEMPORAIRE
    public static void main(String[] args) {
        GraphicInterface g = new GraphicInterface();
        g.run();
    }
    // ===================


}
