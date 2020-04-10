package ir.urmia.ap.wealth;

import java.util.Arrays;
import java.util.Random;

public class WealthDistribution {

    public static void main(String[] args) {
        int population = 1000;
        int initialWealth = 100_000_000;
        int donation = 1_000_000;
        int experimentMonths = 100 * 12;

        int[] personalWealth = new int[population];
        Arrays.fill(personalWealth, initialWealth);
        Random random = new Random();

        for (int month = 0; month < experimentMonths; month++) {
            for (int person = 0; person < population; person++) {
                if (personalWealth[person] >= donation) {
                    int targetPerson = random.nextInt(population);
                    personalWealth[person] = personalWealth[person] - donation;
                    personalWealth[targetPerson] += donation;
                }
            }
        }

        int richest = 0;
        int poorest = 0;

        for (int i = 0; i < population; i++) {
            if (personalWealth[i] < personalWealth[poorest])
                poorest = i;
            if (personalWealth[i] > personalWealth[richest])
                richest = i;
        }

        System.out.printf("The poorest person wealth: %,d\n", personalWealth[poorest]);
        System.out.printf("The richest person wealth: %,d\n", personalWealth[richest]);
        System.out.println(Arrays.toString(personalWealth));
    }
}
