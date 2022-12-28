package InterfaceHelpers;

import javax.swing.*;
import java.awt.*;

public class LabelPlayerName extends JLabel {
    public LabelPlayerName() {
        this.setBounds(10, 10, 120, 30);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("MV Boli", Font.BOLD, 20));
        this.setOpaque(true);
        this.setVisible(true);
    }
}