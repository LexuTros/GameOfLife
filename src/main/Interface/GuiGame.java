package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class GuiGame extends GuiTemplate{

    GuiGame() {
        this.add(new PanelGrid(),BorderLayout.WEST);
        this.add(new PanelInfos(),BorderLayout.EAST);
        this.setVisible(true);
            }

    public static void main(String[] args) {
        GuiGame game = new GuiGame();
    }
}
