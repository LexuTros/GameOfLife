package Interface;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class GuiWelcomeTest {
    private final GuiWelcome gui = new GuiWelcome();
    private final JLabel welcomeLabel = gui.getWelcomeLabel();

    JButton welcomeButton = gui.getWelcomeButton();
    Font f = welcomeButton.getFont();
    Rectangle bounds = welcomeButton.getBounds();
    @Test
    public void constructorTest() {


        assertEquals("WELCOME!", welcomeLabel.getText());
        assertEquals("okaaaay, let's go!", welcomeButton.getText());
        assertEquals("Comic Sans", f.getName());
        assertEquals(Font.BOLD, f.getStyle());
        assertEquals(30, f.getSize());
        assertEquals(JButton.CENTER, welcomeButton.getHorizontalTextPosition());
        assertEquals(JButton.BOTTOM, welcomeButton.getVerticalTextPosition());
        assertEquals(400, bounds.width);
        assertEquals(50, bounds.height);
    }


    @Test
    public void actionPerformedTest() {
        welcomeButton.doClick();
        String labelText = welcomeLabel.getText();
        assertEquals("WELCOME!", labelText);
    }

}
