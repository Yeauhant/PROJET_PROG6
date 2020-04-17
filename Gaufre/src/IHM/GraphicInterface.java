package IHM;

import Arbitre.Board;

import javax.swing.*;
import java.awt.*;

public class GraphicInterface implements Runnable, UserInterface {
    JFrame f;
    boolean maximized;
    Board b;
    EventsCollector ec;

    public GraphicInterface() {}
    public GraphicInterface(Board b, EventsCollector ec){
        this.b = b;
        this.ec = ec;
    }

    // Fonction de mise à jour de la gaufre graphique
    public static boolean refreshGraphicBoard(Board b, GameInterface gi) {
        if (b.tab[0].length != gi.gameButtons.length || b.tab.length != gi.gameButtons[0].length) return false;
        for (int i = 0; i < b.tab.length; i++)
            for (int j = 0; j < b.tab[i].length; j++)
                gi.gameButtons[j][i].setVisible(b.tab[i][j]);

        return true;
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
        GameInterface gi = new GameInterface(b.get_width(), b.get_height(), ec);
        gi.fill();

        f = new JFrame("Gaufre Empoisonnée");
        f.setContentPane(gi.panelMain);
        f.setMinimumSize(new Dimension(300+b.get_width()*20,200+b.get_height()*20));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
