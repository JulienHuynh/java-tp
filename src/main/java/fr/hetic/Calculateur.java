package fr.hetic;

public class Calculateur {
    public static void main(String[] args) {
        CalculateurFactory calculateurFactory = new CalculateurFactory();

        if (args.length != 3) {
            System.out.println("Usage: java fr.hetic.Calculatrice <nombre1> <nombre2> <+, -, '*'>");
            return;
        }

        long number1 = Long.parseLong(args[0]);
        long number2 = Long.parseLong(args[1]);
        String operation = args[2];

        System.out.println(calculateurFactory.calculer(number1, number2, operation));
    }
}
