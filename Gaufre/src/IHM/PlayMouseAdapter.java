package IHM;

import Arbitre.ControlMediator;
import Arbitre.Move;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayMouseAdapter extends MouseAdapter {
    GameInterface gi;
    ControlMediator cm;

    PlayMouseAdapter(ControlMediator cm, GameInterface gi) {
        this.cm = cm;
        this.gi = gi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton b = (JButton) e.getComponent(); // On récupère le bouton.
        String[] cr = b.getName().split(":"); // Récupération des coordonnées dans le nom du bouton.
        int col = Integer.parseInt(cr[1])-1, row = Integer.parseInt(cr[0])-1;
        if (cm.MouseClick(row, col)) {
            System.out.println("Joueur "+ (cm.current ? 2 : 1) + " > Coup joué en " + GameInterface.caseName(Integer.parseInt(cr[1]), Integer.parseInt(cr[0])) + ".");
            cm.h.addMove(new Move(row, col));
            GraphicInterface.refreshGraphicBoard(cm.gameboard, gi);
        }
    }
}