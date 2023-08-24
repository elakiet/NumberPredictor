// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.lang.String;
abstract class NumberPredictor {
    abstract boolean isFibonacci(int number);
    abstract int predictLuckyNumber(int dateOfBirth);
    abstract String predictUnluckyNumber(int dateOfBirth);
}

class LuckyNumberPredictor extends NumberPredictor {
    @Override
    public boolean isFibonacci(int number) {
        int a = 0, b = 1;
        while (b < number) {
            int c = b;
            b = a + b;
            a = c;
        }
        return b == number;
    }

    @Override
    public int predictLuckyNumber(int dateOfBirth) {
        int closestFibonacci = 0;
        for (int i = 1; i <= dateOfBirth; i++) {
            if (isFibonacci(i)) {
                closestFibonacci = i;
            }
        }
        return closestFibonacci;
    }

    @Override
    String predictUnluckyNumber(int dateOfBirth) {
        String message = "Your Unlucky number for "+dateOfBirth+" is not available now.";
        return message;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your date of birth: ");
        int dateOfBirth = scanner.nextInt();

        LuckyNumberPredictor predictor = new LuckyNumberPredictor();

        int luckyNumber = predictor.predictLuckyNumber(dateOfBirth);
        System.out.println("Your lucky number is: " + luckyNumber);
        System.out.println(predictor.predictUnluckyNumber(dateOfBirth));

    }
}