package fr.hetic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculateurFactoryTest {
    CalculateurFactory calculateurFactory = new CalculateurFactory();

    @Test
    public void testAddition() {
        long result = calculateurFactory.calculer(5L, 2L, "+");
        assertEquals(7, result);
    }

    @Test
    public void testSoustraction() {
        long result = calculateurFactory.calculer(5L, 2L, "-");
        assertEquals(3, result);
    }

    @Test
    public void testMultiplication() {
        long result = calculateurFactory.calculer(5L, 2L, "*");
        assertEquals(10, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculerError() {
        calculateurFactory.calculer(5L, 2L, "a");
    }

    @Test
    public void testCalculFichier() {
        String result = calculateurFactory.calculFichier("5", "2", "+");
        assertEquals("7", result);
    }

    @Test
    public void testCalculFichierError() {
        String result = calculateurFactory.calculFichier("5", "2", "a");
        assertEquals("ERREUR", result);
    }

    @Test
    public void testCalculFichierError2() {
        String result = calculateurFactory.calculFichier("5", "a", "+");
        assertEquals("ERREUR", result);
    }


}