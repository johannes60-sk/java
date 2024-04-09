package fr.hetic;

public class Calculateur {
     public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Il faut 3 arguments : deux nombres et un opérateur (+, - ou *)");
            return;
        }
        double a = 0;
        double b = 0;
        try {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers arguments doivent être des nombres");
            return;
        }
        String operator = args[2];
        double result = 0;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                if(a > b)
                    result = a - b;
                else
                    result = b - a;
                break;
            case "*":
                result = a * b;
                break;
            default:
                System.out.println("L'opérateur doit être +, - ou *");
                return;
        }
        System.out.println(result);
    }
}