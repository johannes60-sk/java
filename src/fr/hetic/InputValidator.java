package fr.hetic;

public class InputValidator {
    public static boolean isValidInput(String[] args) {
        if (args.length != 3) {
            System.err.println("Il faut 3 arguments : deux nombres et un opérateur (+, - ou *)");
            return false;
        }
        try {
            Double.parseDouble(args[0]);
            Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Les deux premiers arguments doivent être des nombres");
            return false;
        }
        String operator = args[2];
        if (!operator.matches("[+\\-*]")) {
            System.err.println("L'opérateur doit être +, - ou *");
            return false;
        }
        return true;
    }
}

