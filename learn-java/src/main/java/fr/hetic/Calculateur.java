package fr.hetic;

public class Calculateur {

    public static void main(String[] args) {
        DatabaseReader reader = new DatabaseReader();
        reader.readAndProcessData();
    }
}