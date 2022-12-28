package InterfaceHelpers;

import javax.swing.*;
import java.awt.*;

public class TextFieldlGetPlayerName extends JTextField {

    public TextFieldlGetPlayerName(){
        this.setFont(new Font("Consolas", Font.PLAIN, 35));
        this.setForeground(Color.green);
        this.setBackground(Color.black);
        this.setCaretColor(Color.white);
        this.setPreferredSize(new Dimension(400,80));
    }
}
