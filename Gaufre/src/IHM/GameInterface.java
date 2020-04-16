package IHM;

import javax.swing.*;
import java.awt.*;

public class GameInterface {
    public JPanel panelMain;
    private JButton annulerButton;
    private JButton sauvegarderButton;
    private JButton chargerButton;
    private JButton refaireButton;
    public JList moveList;
    public JPanel gamePanel;
    public JButton[][] gameButtons;

    public int rows;
    public int cols;
    public EventsCollector ec;

    GameInterface(int cols, int rows, EventsCollector ec){
        moveList.setMaximumSize(new Dimension((int)(panelMain.getWidth()*0.25), (int)(panelMain.getHeight()*0.9)));
        moveList.setPreferredSize(new Dimension((int)(panelMain.getWidth()*0.25), (int)(panelMain.getHeight()*0.9)));
        this.cols = cols;
        this.rows = rows;
        this.ec = ec;
        this.gameButtons = new JButton[cols][rows];
    }

    public static String caseName(int c, int l) {
        String cn = "";
        if (!(c == 0 && l == 0))
            cn = colName(c)+l;
        return cn;
    }

    public static String colName(int col) {
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
                    b.setName(i+":"+j);
                    b.setMinimumSize(new Dimension(20, 20));
                    b.addMouseListener(new PlayMouseAdapter(ec, this));
                    gameButtons[i-1][j-1] = b;
                    gamePanel.add(b);
                }
            }
        }
    }

}
