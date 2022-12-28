package InterfaceHelpers;

import javax.swing.*;
import java.awt.*;

public class LabelPlayerColor extends JLabel {

    public LabelPlayerColor() {

        this.setBounds(130, 15, 20, 20);
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        this.setOpaque(true);
    }
}
