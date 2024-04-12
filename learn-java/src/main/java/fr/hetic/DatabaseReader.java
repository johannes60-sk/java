package fr.hetic;

import java.sql.*;

public class DatabaseReader {

    public void readAndProcessData() {
        String url = "jdbc:postgresql://SG-hetic-mt4-java-5275-pgsql-master.servers.mongodirector.com:5432/TP";
        
        String user = "etudiant";
        String password = "MT4@hetic2324";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie à la base de données.");
            String sql = "SELECT PARAM1, PARAM2, OPERATEUR FROM LIGNE WHERE FICHIER_ID IN (SELECT ID FROM FICHIER WHERE TYPE = 'OP')";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int param1 = resultSet.getInt("PARAM1");
                int param2 = resultSet.getInt("PARAM2");
                String operateur = resultSet.getString("OPERATEUR");
                // int index = resultSet.getInt("INDEX");

                // Traitez les données récupérées ici selon vos besoins
                double result = calculate(param1, param2, operateur);
                System.out.println("Résultat de l'opération : " + result);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private double calculate(int param1, int param2, String operator) {
        switch (operator) {
            case "+":
                return param1 + param2;
            case "-":
                return param1 - param2;
            case "*":
                return param1 * param2;
            default:
                System.out.println("Opérateur non supporté : " + operator);
                return Double.NaN;
        }
    }
}
