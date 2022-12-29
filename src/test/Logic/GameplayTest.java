package Logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameplayTest {
    @Test
    public void getActivePlayerTest() {
        Gameplay.activePlayer = Gameplay.player1;
        assertEquals(Gameplay.player1, Gameplay.getActivePlayer());
    }

    @Test
    public void getGenerationTest() {

        Gameplay.generation = 10;
        assertEquals(10, Gameplay.getGeneration());
    }

    @Test
    public void getToKillTest() {
        Gameplay.toKill = true;
        assertTrue(Gameplay.getToKill());

        Gameplay.toKill = false;
        assertFalse(Gameplay.getToKill());
    }

    @Test
    public void setToKillTest() {
        assertFalse(Gameplay.toKill);
        Gameplay.setToKill(true);
        assertTrue(Gameplay.toKill);
    }

    @Test
    public void getToCreateTest() {
        Gameplay.toCreate = true;
        assertTrue(Gameplay.getToCreate());
    }

    @Test
    public void setToCreateTest() {
        Gameplay.setToCreate(true);
        assertTrue(Gameplay.toCreate);
    }

}
