package InterfaceHelpers;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class LabelTextActiveCellsTest {
    @Test
    public void constructorTest() {
        LabelTextActiveCells lta = new LabelTextActiveCells();
        Font f = lta.getFont();

        assertEquals("Comic Sans", f.getName());
        assertEquals(Font.ITALIC, f.getStyle());
        assertEquals(14, f.getSize());
        assertEquals(10, lta.getX());
        assertEquals(40, lta.getY());
        assertEquals(100, lta.getWidth());
        assertEquals(30, lta.getHeight());
        assertEquals("Active cells:", lta.getText());
    }
}
