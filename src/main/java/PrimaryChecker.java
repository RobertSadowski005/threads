import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimaryChecker {
    public void checkPrimeFromFIle() throws FileNotFoundException {

        Scanner odczyt = new Scanner(new File("C:\\Users\\Robert\\Downloads\\numbers.txt"));

        Long primeCounter = 0L;
        while (odczyt.hasNextLong()) {
            Long numberFromFile = odczyt.nextLong();
            boolean result = isPrime(numberFromFile);
            if (result) {
                primeCounter++;
            }
        }
        System.out.println("liczb pierwszych jest: " + primeCounter);
        odczyt.close();


    }

    public static boolean isPrime(Long value) {
        boolean result = true;
        if (value < 2) return false;
        if (value == 2) return true;

        for (long i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return result;
    }
}
