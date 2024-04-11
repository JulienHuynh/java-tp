package fr.hetic;

import java.util.function.BiFunction;

public class CalculateurFactoryFonctionnel {
    private final BiFunction<Long, Long, Long> addition = (a, b) -> a + b;
    private final BiFunction<Long, Long, Long> soustraction = (a, b) -> a - b;
    private final BiFunction<Long, Long, Long> multiplication = (a, b) -> a * b;
    private final Utils utils = new Utils();

    public CalculateurFactoryFonctionnel() {
    }

    Long calculer(Long number1, Long number2, String operation) {
        BiFunction<Long, Long, Long> operationFunction = switch (operation) {
            case "+" -> addition;
            case "-" -> soustraction;
            case "*" -> multiplication;
            default -> throw new IllegalArgumentException("L'opération n'est pas supportée");
        };
        return operationFunction.apply(number1, number2);
    }

    String calculFichier(String number1, String number2, String operation) {
        if (!utils.isLong(number1) || !utils.isLong(number2)) {
            return "ERREUR";
        }

        long number1Long = Long.parseLong(number1);
        long number2Long = Long.parseLong(number2);

        BiFunction<Long, Long, Long> operationFunction = switch (operation) {
            case "+" -> addition;
            case "-" -> soustraction;
            case "*" -> multiplication;
            default -> throw new IllegalArgumentException("L'opération n'est pas supportée");
        };
        return String.valueOf(operationFunction.apply(number1Long, number2Long));
    }
}
