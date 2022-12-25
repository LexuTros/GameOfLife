package DataStructure;

import static org.junit.jupiter.api.Assertions.*;

import DataStructure.Color;
import org.junit.jupiter.api.Test;

public class ColorTest {

    @Test
    void TestToLowerCase() {
        assertEquals("green", Color.GREEN.toLowerCase());
    }

}
