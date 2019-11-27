import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[]agrs){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        while(num > 5){
            int a = random.nextInt(num + 6);
            System.out.print(a);
        }
    }
}
