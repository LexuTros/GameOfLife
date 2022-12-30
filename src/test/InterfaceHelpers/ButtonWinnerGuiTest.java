package InterfaceHelpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.awt.*;

public class ButtonWinnerGuiTest {
    @Test
    public void constructorTest() {
        ButtonWinnerGui bwg = new ButtonWinnerGui();
        Font f = bwg.getFont();

        assertEquals(JButton.CENTER, bwg.getHorizontalTextPosition());
        assertEquals(JButton.BOTTOM, bwg.getVerticalTextPosition());
        assertEquals("Comic Sans", f.getName());
        assertEquals(Font.BOLD, f.getStyle());
        assertEquals(20, f.getSize());
        assertFalse(bwg.isFocusable());
    }
}
