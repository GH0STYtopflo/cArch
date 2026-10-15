import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int n = readInput();

        if (n < 0) {
            System.out.println("\033[30mInvalid input.\033[0m");
            return;
        }

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        System.out.printf("\033[32mThe result is %d\033[0m\n", result);
    }

    private static int readInput() {
        Scanner scn = new Scanner(System.in);
        int number = 0;

        try {
            System.out.println("Please enter the value of n: ");
            number = scn.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scn.close();
        }
        return number;
    }
}
