package guessing;

import java.util.Random;
import java.util.Scanner;

public class Guess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(100) + 1;

        System.out.println("Zgadnij liczbę z przedziału od 1 do 100:");

        int guess = -1;
        while (guess != number) {
            guess = getNumber(scanner);
            if (guess > number) {
                System.out.println("Za dużo!");
                System.out.println("Zgadnij liczbę:");
            } else if (guess < number) {
                System.out.println("Za mało!");
                System.out.println("Zgadnij liczbę:");
            } else {
                System.out.println("Zgadłeś");
            }
        }

    }

    static int getNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Wartość nie jest liczbą, podaj jeszcze raz:");
        }
        return scanner.nextInt();
    }
}
