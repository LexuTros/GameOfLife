package Interface;

import DataStructure.Player;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class PanelInfosTest {

    private final Player p1 = new Player("Philipp", Color.GREEN);
    private final Player p2 = new Player("Johnny", Color.PINK);

    private final PanelInfos pI = new PanelInfos(p1,p2,p1);
    private final JButton buttonDone = pI.getButtonDone();

    @Test
    public void actionPerformedTest() {
        ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null);
        pI.actionPerformed(event);
        assertFalse(buttonDone.isEnabled());
    }

}

