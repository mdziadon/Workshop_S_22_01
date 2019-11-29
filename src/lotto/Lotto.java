package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {
        // Wczytywanie liczb
        int[] picked = pickNumbers();
        System.out.println("Podane liczby:");
        System.out.println(Arrays.toString(picked));

        // Losowanie liczb
        int[] generated = generateNumbers();
        System.out.println("Wylosowane liczby:");
        System.out.println(Arrays.toString(generated));
    }

    static int[] pickNumbers() {
        int[] result = new int[6];
        int index = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj 6 liczb z zakresu 1-49:");
        while (index < 6) {
            int number = getNumber(scanner);
            if (number < 1 || number > 49) {
                System.out.println("Liczba powinna być z zakresu 1-49");
            } else if (containsValue(result, number)) {
                System.out.println("Taka liczba już została podana");
            } else {
                result[index++] = number;
            }
        }
        Arrays.sort(result);
        return result;
    }

    static int[] generateNumbers() {
        int[] result = new int[6];
        Random random = new Random();
        int index = 0;
        while (index < 6) {
            int number = random.nextInt(49) + 1;
            if (!containsValue(result, number)) {
                result[index++] = number;
            }
        }
        Arrays.sort(result);
        return result;
    }

    static boolean containsValue(int[] tab, int value) {
        for (int element : tab) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    static int getNumber(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("To nie jest liczba, podaj jeszcze raz");
            scan.next();
        }
        return scan.nextInt();
    }
}


