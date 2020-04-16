package IHM;

import Arbitre.ControlMediator;
import Arbitre.Move;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayMouseAdapter extends MouseAdapter {
    GameInterface gi;
    ControlMediator ec;

    PlayMouseAdapter(EventsCollector ec, GameInterface gi) {
        this.ec = (ControlMediator) ec;
        this.gi = gi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton b = (JButton) e.getComponent(); // On récupère le bouton
        String[] cr = b.getName().split(":"); // Récupération des coordonnées dans le nom du bouton
        int r = Integer.parseInt(cr[1])-1, c = Integer.parseInt(cr[0])-1;
        boolean v = ec.MouseClick(r, c);
        if (v) {
            System.out.println(ec.current + " > Coup joué en " + GameInterface.caseName(Integer.parseInt(cr[1]), Integer.parseInt(cr[0])) + ".");
            ec.h.addMove(new Move(r, c));
            for (int i = c; i < ec.gameboard.get_width(); i++)
                for (int j = r; j < ec.gameboard.get_height(); j++)
                    gi.gameButtons[i][j].setVisible(false);
        }
        System.out.println("(Col. "+c+", Row "+r+")");
        // ec.h.printPast();
    }
}