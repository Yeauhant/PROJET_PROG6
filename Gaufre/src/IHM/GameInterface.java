package IHM;

import javax.swing.*;
import java.awt.*;

public class GameInterface {
    public JPanel panelMain;
    private JButton annulerButton;
    private JButton sauvegarderButton;
    private JButton chargerButton;
    private JButton refaireButton;
    private JList list1;
    private JPanel GamePanel;

    GameInterface(){
        list1.setMaximumSize(new Dimension((int)(panelMain.getWidth()*0.25), (int)(panelMain.getHeight()*0.9)));
        list1.setPreferredSize(new Dimension((int)(panelMain.getWidth()*0.25), (int)(panelMain.getHeight()*0.9)));

    }

    public void remplissage(){
        GamePanel.setLayout(new GridLayout(5,5));
        for(int i = 0; i<5;i++){
            for (int j = 0; j < 5; j++) {
                JButton b = new JButton();
                b.setName(""+i+j);
                b.setAlignmentX(i);
                b.setAlignmentY(j);
                b.setMaximumSize(new Dimension(100,100));
                b.setPreferredSize(new Dimension(10,10));
                b.setHorizontalAlignment(2);
                b.setVerticalAlignment(0);
                b.setText(""+i+";"+j);
                GamePanel.add(b);
            }
        }
    }

}
