package fr.hetic;

public class CalculateurFactory {
    Addition addition = new Addition();
    Soustraction soustraction = new Soustraction();
    Multiplication multiplication = new Multiplication();
    Utils utils = new Utils();

    public CalculateurFactory() {
    }

    Long calculer(Long number1, Long number2, String operation) {
        return switch (operation) {
            case "+" -> addition.apply(number1, number2);
            case "-" -> soustraction.apply(number1, number2);
            case "*" -> multiplication.apply(number1, number2);
            default -> throw new IllegalArgumentException("L'opération n'est pas supportée");
        };
    }

    String calculFichier(String number1, String number2, String operation) {
        if (!utils.isLong(number1) || !utils.isLong(number2)) {
            return "ERREUR";
        }

        long number1Long = Long.parseLong(number1);
        long number2Long = Long.parseLong(number2);

        return switch (operation) {
            case "+" -> String.valueOf(addition.apply(number1Long, number2Long));
            case "-" -> String.valueOf(soustraction.apply(number1Long, number2Long));
            case "*" -> String.valueOf(multiplication.apply(number1Long, number2Long));
            default -> "ERREUR";
        };
    }

}
