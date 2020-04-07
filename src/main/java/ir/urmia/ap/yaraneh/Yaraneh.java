package ir.urmia.ap.yaraneh;

import java.util.Arrays;
import java.util.Random;

public class Yaraneh {
    public static void main(String[] args) {
        int population = 10;
        int tax = 1_000_000;
        int initialWealth = 100_000_000;
        int iterations = 100000;
        int[] peopleWealth = new int[population];
        for (int i = 0; i < peopleWealth.length; i++) {
            peopleWealth[i] = initialWealth;
        }

        Random random = new Random();
        for (int iter = 0; iter < iterations; iter++) {
            for (int i = 0; i < peopleWealth.length; i++) {
                if(peopleWealth[i]>tax) {
                    peopleWealth[i] -= tax;
                    peopleWealth[random.nextInt(population)] += tax;
                }
            }
        }
        System.out.println(Arrays.toString(peopleWealth));
    }
}
