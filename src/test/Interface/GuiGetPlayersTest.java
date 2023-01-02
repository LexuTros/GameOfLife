package Interface;

import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GuiGetPlayersTest {
    @Test
    public void actionPerformedTest() {
        GuiGetPlayers guiGetPlayers = new GuiGetPlayers();
        ActionEvent eventContinueButton = new ActionEvent(guiGetPlayers.buttonContinue, ActionEvent.ACTION_PERFORMED, null);
        guiGetPlayers.actionPerformed(eventContinueButton);

        assertNotNull(GuiGetPlayers.players);
    }


}
