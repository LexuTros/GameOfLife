package Interface;

import DataStructure.Player;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class PanelInfosTest {

    Player p1 = new Player("Philipp", Color.GREEN);
    Player p2 = new Player("Johnny", Color.PINK);

    final private PanelInfos pI = new PanelInfos(p1,p2,p1);
    JButton buttonDone = pI.getButtonDone();

    @Test
    public void testActionPerformed_buttonDone() {
        ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null);
        pI.actionPerformed(event);
        assertTrue(buttonDone.isEnabled());
    }

}

