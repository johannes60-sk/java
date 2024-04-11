package fr.hetic;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculateur {

    public static double calculate(String num1, String num2, String operator) {
        double a, b;
        try {
            a = Double.parseDouble(num1);
            b = Double.parseDouble(num2);
        } catch (NumberFormatException e) {
            return Double.NaN; // Return NaN for invalid arguments
        }

        Map<String, BinaryOperator<Double>> operations = new HashMap<>();
        operations.put("+", (x, y) -> x + y);
        operations.put("-", (x, y) -> Math.abs(x - y));

        BinaryOperator<Double> operation = operations.get(operator);
        if (operation == null) {
            return Double.NaN; // Return NaN for invalid operator
        }

        return operation.apply(a, b);
    }
}