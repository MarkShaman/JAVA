package org.example;

import org.example.Calculator;
import org.example.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        Assertions.assertEquals(5.0, calc.add(2, 3));
    }

    @Test
    void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }

    @Test
    void testSqrtNegative() {
        Assertions.assertThrows(InvalidInputException.class, () -> {
            calc.sqrt(-5);
        });
    }
}