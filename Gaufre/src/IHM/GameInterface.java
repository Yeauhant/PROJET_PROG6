package IHM;

import javax.swing.*;
import java.awt.*;

public class GameInterface {
    public JPanel panelMain;
    private JButton annulerButton;
    private JButton sauvegarderButton;
    private JButton chargerButton;
    private JButton refaireButton;
    private JList moveList;
    private JPanel gamePanel;
    public int rows;
    public int cols;

    GameInterface(int cols, int rows){
        moveList.setMaximumSize(new Dimension((int)(panelMain.getWidth()*0.25), (int)(panelMain.getHeight()*0.9)));
        moveList.setPreferredSize(new Dimension((int)(panelMain.getWidth()*0.25), (int)(panelMain.getHeight()*0.9)));
        this.cols = cols;
        this.rows = rows;
    }

    public String caseName(int c, int l) {
        String cn = "";
        if (!(c == 0 && l == 0))
            cn = colName(c)+l;
        return cn;
    }

    public String colName(int col) {
        char c = (char) ((col-1) % 26 + 65);
        if ((col-1)/26 == 0)
            return ""+c;
        return colName((col-1)/26)+c;
    }

    public void fill() {
        gamePanel.setLayout(new GridLayout(rows+1, cols+1));
        for (int i = 0; i <= rows; i++){
            JLabel l;
            JButton b;
            String t;
            if (i == 0) t = "";
            else t = ""+i;

            l = new JLabel(t);
            l.setHorizontalAlignment(0);
            l.setVerticalAlignment(0);
            gamePanel.add(l);

            for (int j = 1; j <= cols; j++) {
                if (i == 0) {
                    t = colName(j);
                    l = new JLabel(t);
                    l.setHorizontalAlignment(0);
                    l.setVerticalAlignment(0);
                    gamePanel.add(l);
                } else {
                    b = new JButton();
                    b.setName(caseName(j, i));
                    b.setMinimumSize(new Dimension(20, 20));
                    gamePanel.add(b);
                }
            }
        }
    }

}
