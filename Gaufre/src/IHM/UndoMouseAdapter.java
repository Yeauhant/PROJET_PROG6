package IHM;

import Arbitre.ControlMediator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UndoMouseAdapter extends MouseAdapter {
    GameInterface gi;
    ControlMediator cm;

    UndoMouseAdapter(ControlMediator cm, GameInterface gi) {
        this.cm = cm;
        this.gi = gi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cm.changeGameBoard(cm.h.undo(cm.h.past.size()-1, cm.gameboard)); // On annule le coup précédent.
        GraphicInterface.refreshGraphicBoard(cm.gameboard, gi); // On rafraîchit l'affichage de la gaufre.
        cm.playerTurn(); // On repasse la main au joueur à qui on a annulé le coup.
    }
}
