package IHM;

import Arbitre.ControlMediator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RedoMouseAdapter extends MouseAdapter {
    GameInterface gi;
    ControlMediator cm;

    RedoMouseAdapter(ControlMediator cm, GameInterface gi) {
        this.cm = cm;
        this.gi = gi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cm.changeGameBoard(cm.h.redo(cm.h.future.size()-1, cm.gameboard)); // On refait le coup annulé avant.
        GraphicInterface.refreshGraphicBoard(cm.gameboard, gi); // On rafraîchit l'affichage de la gaufre.
        cm.playerTurn(); // On repasse la main au joueur à qui on a annulé le coup.
    }
}
