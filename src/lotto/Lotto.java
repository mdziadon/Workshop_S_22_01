package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {
        int[] tab = generateNumbers();
        String elements = Arrays.toString(tab);
        System.out.println(elements);
    }

    static int[] generateNumbers() {
        int[] result = new int[6];
        Random random = new Random();
        int index = 0;
        while (index < 6) {
            int number = random.nextInt(49) + 1;
            if (!containsValue(result, number)) {
                result[index] = number;
                index++;
            }
        }
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


