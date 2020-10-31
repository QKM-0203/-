import java.math.BigInteger;
import  java.util.Scanner;

public class Biginteger {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            BigInteger bigInteger = scanner.nextBigInteger();
            int num = 0;
            if(bigInteger.isProbablePrime(10)) {
                    System.out.println(bigInteger);
                    num++;
            }
            BigInteger bigInteger1 = new BigInteger("1");

            int num1 = scanner.nextInt();
            while(num != num1){

                    BigInteger bigInteger2 = bigInteger.nextProbablePrime();
                    if (bigInteger2.isProbablePrime(10)) {
                            System.out.println(bigInteger2);
                            num++;
                    }
                    bigInteger = bigInteger2;
            }
    }
}

