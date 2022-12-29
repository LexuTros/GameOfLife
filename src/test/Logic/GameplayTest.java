package Logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameplayTest extends Gameplay{
    @Test
    public void testGetActivePlayer() {
        activePlayer = player1;
        assertEquals(player1, getActivePlayer());
    }

    @Test
    public void testGetGeneration() {

        generation = 5;
        assertEquals(5, getGeneration());
    }

    @Test
    public void testGetToKill() {
        toKill = true;
        assertTrue(getToKill());

        toKill = false;
        assertFalse(getToKill());
    }

    @Test
    public void testSetToKill() {
        toKill = true;
        assertTrue(toKill);

        toKill = false;
        assertFalse(toKill);
    }

    @Test
    public void testGetToCreate() {
        toCreate = true;
        assertTrue(getToCreate());
    }

    @Test
    public void testSetToCreate() {
        setToCreate(true);
        assertTrue(toCreate);
    }

}
