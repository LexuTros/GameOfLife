package InterfaceHelpers;

import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class TextFieldGetPlayerNameTest {
    @Test
    public void constructorTest() {
        TextFieldGetPlayerName tfgpn = new TextFieldGetPlayerName();
        Font f = tfgpn.getFont();

        assertEquals("Consolas", f.getName());
        assertEquals(Font.PLAIN, f.getStyle());
        assertEquals(35, f.getSize());
        assertEquals(Color.green, tfgpn.getForeground());
        assertEquals(Color.black, tfgpn.getBackground());
        assertEquals(Color.white, tfgpn.getCaretColor());
        assertEquals(new Dimension(400, 80), tfgpn.getPreferredSize());
    }
}
