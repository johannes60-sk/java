package fr.hetic;

public class Calculateur {
    public static void main(String[] args) {
        if (!InputValidator.isValidInput(args)) {
            System.exit(1);
        }

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);
        String operator = args[2];

        Operation operation = OperationFactory.createOperation(operator);
        double result = operation.calculate(num1, num2);

        System.out.println("Résultat de l'opération: " + result);
    }
}
