package Interface;

import DataStructure.Board;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class GuiWelcome extends GuiTemplate{

    public GuiWelcome() {
        JLabel welcome = new JLabel();
        welcome.setFont(new Font("Papyrus", Font.BOLD, 140));
        welcome.setText("WELCOME!");
        this.add(welcome,BorderLayout.CENTER);
        this.setVisible(true);
    }
}
