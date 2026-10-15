import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Mul {
    public static void main() {
        int[] arr = readInput();

        // I'm using AtomicInteger instances because I don't want to deal with arrays
        AtomicInteger a = new AtomicInteger(arr[0]);
        AtomicInteger b = new AtomicInteger(arr[1]);

        prepareInput(a, b);

        int result = 0;
        for (int i = 0; i < b.get(); i++) {
            result += a.get();
        }


        System.out.printf("\033[32mThe result is %d\033[0m\n", result);
    }

    private static int[] readInput() {
        Scanner scn = new Scanner(System.in);
        int[] numbers = new int[2];

        try {
            System.out.println("Please enter the value of a: ");
            numbers[0] = scn.nextInt();

            // Consume the leftover new line character
            scn.nextLine();
        
            System.out.println("\nPlease enter the value of b: ");
            numbers[1] = Integer.parseInt(scn.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scn.close();
        }
        return numbers;
    }

    private static void prepareInput(AtomicInteger a, AtomicInteger b) {
        if (a.get() < 0 && b.get() < 0) {
            a.set(a.get() * -1); 
            b.set(b.get() * -1);
        }

        if (0 < a.get() && b.get() < 0) {
            a.set(b.get() + a.get());
            b.set(a.get() - b.get());
            a.set(a.get() - b.get());
        }
    }
}