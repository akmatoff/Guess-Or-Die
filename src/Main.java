import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] agrs) {
            Random rand = new Random();
            Scanner scanner = new Scanner(System.in);
            int num = 1;
            int score = 0;
            while (num <= 5) {
                int compnum = rand.nextInt(6) + 1;
                num++;
                System.out.println("Угадайте число от 1 до 6: ");
                int usernum = scanner.nextInt();

                int point = Math.abs(compnum - usernum);
                if (point == 0) {
                    score = score + 6;
                } else if (point == 1) {
                    score = score + 5;
                } else if (point == 2) {
                    score = score + 4;
                } else if (point == 3) {
                    score = score + 3;
                } else if (point == 4) {
                    score = score + 2;
                } else if (point == 5) {
                    score = score + 1;
                } else if (point == 6) {
                    score = score + 0;
                }
            }
            System.out.println("Вы набрали "+ score+ " баллов");
            if (score >= 25){
                System.out.println("Поздравляю, вы победили!");
            }
            else {
                System.out.println("Вы проиграли! Попробуйте ещё рыз");
            }
        }
    }

