package Interface;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PanelTitleBannerTest {
    @Test
    public void constructorTest() {
        PanelTitleBanner ptb = new PanelTitleBanner();
        JLabel l = (JLabel) ptb.getComponent(0);
        Font f = l.getFont();

        assertEquals(0, ptb.getX());
        assertEquals(5, ptb.getY());
        assertEquals(1200, ptb.getWidth());
        assertEquals(50, ptb.getHeight());
        assertEquals(Color.darkGray, ptb.getBackground());
        assertEquals("Game of Life by Dario, Lenny, Valentin & Remo", l.getText());
        assertEquals(JLabel.CENTER, l.getHorizontalTextPosition());
        assertEquals(JLabel.BOTTOM, l.getVerticalTextPosition());
        assertEquals("PAPYRUS", f.getName());
        assertEquals(Font.ITALIC, f.getStyle());
        assertEquals(30, f.getSize());
        assertEquals(Color.white, l.getForeground());
        assertTrue(ptb.isVisible());
    }
}


