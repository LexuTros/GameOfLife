package InterfaceHelpers;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class LabelPlayerNameTest {
    @Test
    public void constructorTest() {
        LabelPlayerName lpn = new LabelPlayerName();
        Font f = lpn.getFont();

        assertEquals(10, lpn.getX());
        assertEquals(10, lpn.getY());
        assertEquals(120, lpn.getWidth());
        assertEquals(30, lpn.getHeight());
        assertEquals(Color.BLACK, lpn.getForeground());
        assertEquals("MV Boli", f.getName());
        assertEquals(Font.BOLD, f.getStyle());
        assertEquals(20, f.getSize());
        assertTrue(lpn.isOpaque());
        assertTrue(lpn.isVisible());
    }
}
