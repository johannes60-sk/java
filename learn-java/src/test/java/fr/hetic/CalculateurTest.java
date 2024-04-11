package fr.hetic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateurTest {

    @Test
    public void testAddition() {
        double result = Calculateur.calculate("5", "3", "+");
        assertEquals(8.0, result);
    }

    @Test
    public void testSubtraction() {
        double result = Calculateur.calculate("10", "4", "-");
        assertEquals(6.0, result);
    }

    @Test
    public void testInvalidOperator() {
        double result = Calculateur.calculate("5", "3", "*");
        assertEquals(Double.NaN, result); // NaN (Not-a-Number) expected for invalid operator
    }

    @Test
    public void testInvalidArguments() {
        double result = Calculateur.calculate("abc", "3", "+");
        assertEquals(Double.NaN, result); // NaN (Not-a-Number) expected for invalid arguments
    }
}
