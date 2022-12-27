package Interface;

import DataStructure.Player;

import javax.swing.*;
import java.awt.*;

public class GuiWinner extends GuiTemplate {


    public GuiWinner(Player winner) {
        JLabel labelWin = new JLabel();
        labelWin.setFont(new Font("Papyrus", Font.BOLD, 140));
        labelWin.setText("CONGRATULATIONS "+winner.getPlayerName());
        this.add(labelWin, BorderLayout.CENTER);
        this.setVisible(true);
    }
}

