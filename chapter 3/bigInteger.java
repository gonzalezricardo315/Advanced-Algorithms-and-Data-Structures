import java.math.BigInteger;
import java.util.Random;

public class bigInteger {
    public static void main(String[] args) {
        //both big integer for loop that keeps changing n
        Random ran = new Random();
        for(int i = 10; i < Integer.MAX_VALUE; i *= 10){

            //using a class in BigIntegers that already creates random numbers that have the same bit size.
            BigInteger num1 = new BigInteger(i, ran);
            BigInteger num2 = new BigInteger(i, ran);

            long startTime = System.nanoTime();
            BigInteger answer = num1.multiply(num2);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            double seconds = (double)totalTime/1000000000;
            System.out.println(i + ": " + seconds);
        }

        /*
        //i have the division commented out because it won't run because of the multiplication
        //for loop for the division same as the multiplication
        for(int i = 10; i < Integer.MAX_VALUE; i *= 10){

            BigInteger num1 = new BigInteger(i, ran);
            BigInteger num2 = new BigInteger(i, ran);
            //dividing the random number by 2 so it is half as much as the first number.
            long divide = 2;
            num2 = num1.divide(BigInteger.valueOf(divide));

            long startTime = System.nanoTime();
            BigInteger answer = num1.divide(num2);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            double seconds = (double)totalTime/1000000000;
            System.out.println(i + ": " + seconds);
        }
         */
    }
}
