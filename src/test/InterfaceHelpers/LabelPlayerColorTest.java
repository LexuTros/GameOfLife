package InterfaceHelpers;


import org.junit.jupiter.api.Test;

import javax.swing.border.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class LabelPlayerColorTest {
    @Test
    public void constructorTest() {
        LabelPlayerColor lpc = new LabelPlayerColor();
        Border b = lpc.getBorder();

        assertEquals(130, lpc.getX());
        assertEquals(15, lpc.getY());
        assertEquals(20, lpc.getWidth());
        assertEquals(20, lpc.getHeight());
        assertEquals(Color.darkGray, ((LineBorder) b).getLineColor());
        assertEquals(1, ((LineBorder) b).getThickness());
        assertTrue(lpc.isOpaque());
    }
}
