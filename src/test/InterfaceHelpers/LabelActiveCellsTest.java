package InterfaceHelpers;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class LabelActiveCellsTest {
    @Test
    public void constructorTest() {
        LabelActiveCells lac = new LabelActiveCells();
        Font f = lac.getFont();

        assertEquals("Comic Sans", f.getName());
        assertEquals(Font.ITALIC, f.getStyle());
        assertEquals(14, f.getSize());
        assertEquals(100, lac.getBounds().getX());
        assertEquals(40, lac.getBounds().getY());
        assertEquals(50, lac.getBounds().getWidth());
        assertEquals(30, lac.getBounds().getHeight());
    }
}
