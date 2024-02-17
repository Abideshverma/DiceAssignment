import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        // Create a Random object to generate random numbers
        Random random = new Random();

        // Roll both dice and get their values
        // Die A has at most 5 spots and Die B has at most 12 spots
        // to ensure that the probabilities of obtaining the sums remain the same
        int rollA = random.nextInt(5) + 1; // Die A has at most 5 spots
        int rollB = random.nextInt(12) + 1; // Die B has at most 12 spots

        // Calculate the sum of the rolls
        int sum = rollA + rollB;

        // Print the results
        System.out.println("Die A: " + rollA);
        System.out.println("Die B: " + rollB);
        System.out.println("Sum: " + sum);

        // Calculate the number of combinations
        int[][] combinations = new int[5][12];
        int count = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 12; j++) {
                combinations[i - 1][j - 1] = count++;
            }
        }

        // Calculate the probability of each sum
        double[] probabilities = new double[23];
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 12; j++) {
                int sumValue = i + j;
                // Add the probability of obtaining sumValue with this combination
                // to the probability array
                probabilities[sumValue] += 1.0 / combinations[i-1][j-1];
            }
        }

        // Print the probabilities
        System.out.println("\nProbabilities:");
        for (int i = 2; i < probabilities.length; i++) {
            System.out.printf("P(Sum = %d) = %.4f\n", i, probabilities[i]);
        }
    }
}