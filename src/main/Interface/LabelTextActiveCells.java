package Interface;

import javax.swing.*;
import java.awt.*;

public class LabelTextActiveCells extends JLabel {

    LabelTextActiveCells() {
        this.setFont(new Font("Comic Sans", Font.ITALIC, 14));
        this.setBounds(10, 40, 100, 30);
        this.setText("Active cells:");
    }
}