package Interface;

import javax.swing.*;
import java.awt.*;

public class GuiTemplate extends JFrame {

    GuiTemplate(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // without this, frame only gets hidden (NO_ACTION, not possible to close)
        this.setSize(1200, 750);
        this.setResizable(false); // prevent frame from being manually resized
        this.setLayout(new BorderLayout());
        this.setTitle("Game of Life");
        this.setLocationRelativeTo(null); // places in middle of Screen
        this.getContentPane().setBackground(new Color(0, 150, 240)); // set background with RGB

        this.add(new PanelTitleBanner(), BorderLayout.NORTH);
        this.setVisible(true);

    }

}
