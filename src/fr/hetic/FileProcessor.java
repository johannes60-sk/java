package fr.hetic;

import java.io.*;

public class FileProcessor {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(" Vous devez spécifier le chemin du dossier contenant les fichiers '.op' à traiter.");
            return;
        }

        String path = args[0];
        File folder = new File(path);

        if (!folder.isDirectory()) {
            System.out.println("Le chemin spécifié n'est valide.");
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".op"));

        if (files == null || files.length == 0) {
            System.out.println("Aucun fichier avec l'extension '.op' trouvé dans le dossier spécifié.");
            return;
        }

        try {
            for (File file : files) {
                processFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(File inputFile) throws IOException {
        String outputFileName = inputFile.getName().replace(".op", ".res");
        File outputFile = new File(inputFile.getParent(), outputFileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(";");
                    if (parts.length != 3) {
                        throw new InvalidLineFormatException("Format de ligne invalide : " + line);
                    }

                    double num1 = Double.parseDouble(parts[0]);
                    double num2 = Double.parseDouble(parts[1]);
                    String operator = parts[2];

                    double result;
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        default:
                            throw new UnsupportedOperatorException("Opérateur non supporté : " + operator);
                    }

                    writer.write(String.valueOf(result));
                    writer.newLine();
                } catch (NumberFormatException | InvalidLineFormatException | UnsupportedOperatorException e) {
                    writer.write("ERROR: " + e.getMessage());
                    writer.newLine();
                }
            }
        }
    }

    // gestion des exceptions
    static class InvalidLineFormatException extends Exception {
        public InvalidLineFormatException(String message) {
            super(message);
        }
    }

    static class UnsupportedOperatorException extends Exception {
        public UnsupportedOperatorException(String message) {
            super(message);
        }
    }
}
