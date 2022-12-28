package InterfaceHelpers;

import javax.swing.*;
import java.awt.*;

public class ButtonWinnerGui extends JButton {

    public ButtonWinnerGui() {

        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
        this.setFont(new Font("Comic Sans", Font.BOLD, 20));
        this.setFocusable(false);
    }
}