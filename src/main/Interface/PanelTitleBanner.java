package Interface;

import javax.swing.*;
import java.awt.*;

public class PanelTitleBanner extends JPanel{

    PanelTitleBanner()
    {
        this.setBounds(0, 5, 1200, 50);
        this.setBackground(Color.darkGray);

        JLabel label = new JLabel(); // create a label
        label.setText("Game of Life by Dario, Lenny, Valentin & Remo"); // set text of label
        this.add(label);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition((JLabel.BOTTOM));
        label.setFont(new Font("PAPYRUS", Font.ITALIC, 30));
        label.setForeground(Color.white);

        this.setVisible(true);
    }
}
