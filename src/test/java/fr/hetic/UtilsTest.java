package fr.hetic;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilsTest {
    Utils utils = new Utils();

    @Test
    public void testIsLong() {
        boolean result = utils.isLong("5");
        assertTrue(result);
    }

    @Test
    public void testIsLongError() {
        boolean result = utils.isLong("a");
        assertFalse(result);
    }

}
