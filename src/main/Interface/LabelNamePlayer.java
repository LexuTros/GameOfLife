package Interface;

import javax.swing.*;
import java.awt.*;

public class LabelNamePlayer extends JLabel {
    LabelNamePlayer() {
        this.setBounds(10, 10, 120, 30);
        this.setForeground(Color.BLUE);
        this.setFont(new Font("MV Boli", Font.BOLD, 20));
        this.setOpaque(true);
        this.setVisible(true);
    }
}