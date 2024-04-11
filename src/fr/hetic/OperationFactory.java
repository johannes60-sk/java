package fr.hetic;

// Factory pour créer les instances d'Operation en fonction de l'opérateur
public class OperationFactory {
    public static Operation createOperation(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            default:
                throw new IllegalArgumentException("Opérateur non pris en charge: " + operator);
        }
    }
}

