package Interface;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GuiTemplateTest {
    @Test
    public void constructorTest() {
        GuiTemplate gui = new GuiTemplate();

        assertEquals(1200, gui.getWidth());
        assertEquals(750, gui.getHeight());
        assertFalse(gui.isResizable());
        assertEquals("Game of Life", gui.getTitle());
        assertEquals(new Color(0, 150, 240), gui.getContentPane().getBackground());
    }
}
