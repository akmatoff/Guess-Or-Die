import java.util.Random;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        Authorize.authOrReg();
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        int score = 0;
        while (num <= 5) {
            int compnum = rand.nextInt(6) + 1;
            num++;
            System.out.println(Colors.CYAN + "Угадайте число от 1 до 6: " + Colors.RESET);
            int usernum = scanner.nextInt();

            int point = Math.abs(compnum - usernum);
            if (point == 0) {
                score = score + 6;
                System.out.println(Colors.YELLOW + "Разница между вашим числом, и числом, загаданным компьютером равна " + Colors.RESET + Colors.CYAN_BOLD + "0" + Colors.RESET);
                System.out.println(Colors.GREEN + "Вы набрали " + Colors.RESET + Colors.CYAN + "6 " + Colors.RESET + Colors.GREEN + "очков!" + Colors.RESET);
            } else if (point == 1) {
                score = score + 5;
                System.out.println(Colors.YELLOW + "Разница между вашим числом, и числом, загаданным компьютером равна " + Colors.RESET + Colors.CYAN_BOLD + "1" + Colors.RESET);
                System.out.println(Colors.GREEN + "Вы набрали " + Colors.RESET + Colors.CYAN + "5 " + Colors.RESET + Colors.GREEN + "очков!" + Colors.RESET);
            } else if (point == 2) {
                score = score + 4;
                System.out.println(Colors.YELLOW + "Разница между вашим числом, и числом, загаданным компьютером равна " + Colors.RESET + Colors.CYAN_BOLD + "2" + Colors.RESET);
                System.out.println(Colors.GREEN + "Вы набрали " + Colors.RESET + Colors.CYAN + "4 " + Colors.RESET + Colors.GREEN + "очка!" + Colors.RESET);
            } else if (point == 3) {
                score = score + 3;
                System.out.println(Colors.YELLOW + "Разница между вашим числом, и числом, загаданным компьютером равна " + Colors.RESET + Colors.CYAN_BOLD + "3" + Colors.RESET);
                System.out.println(Colors.GREEN + "Вы набрали " + Colors.RESET + Colors.CYAN + "3 " + Colors.RESET + Colors.GREEN + "очка!" + Colors.RESET);
            } else if (point == 4) {
                score = score + 2;
                System.out.println(Colors.YELLOW + "Разница между вашим числом, и числом, загаданным компьютером равна " + Colors.RESET + Colors.CYAN_BOLD + "4" + Colors.RESET);
                System.out.println(Colors.GREEN + "Вы набрали " + Colors.RESET + Colors.CYAN + "2 " + Colors.RESET + Colors.GREEN + "очка!" + Colors.RESET);
            } else if (point == 5) {
                score = score + 1;
                System.out.println(Colors.YELLOW + "Разница между вашим числом, и числом, загаданным компьютером равна " + Colors.RESET + Colors.CYAN_BOLD + "5" + Colors.RESET);
                System.out.println(Colors.GREEN + "Вы набрали " + Colors.RESET + Colors.CYAN + "1 " + Colors.RESET + Colors.GREEN + "очко!" + Colors.RESET);
            } else if (point == 6) {
                score = score + 0;
                System.out.println(Colors.YELLOW + "Разница между вашим числом, и числом, загаданным компьютером равна " + Colors.RESET + Colors.CYAN_BOLD + "6" + Colors.RESET);
                System.out.println(Colors.GREEN + "Вы набрали " + Colors.RESET + Colors.CYAN + "0 " + Colors.RESET + Colors.GREEN + "очко!" + Colors.RESET);
            }
        }

        Authorize auth = new Authorize();
        String login = auth.getLogin();
        String scoreToString = "" + score;

        if (score == 30) {
            System.out.println(Colors.GREEN + "Поздравляем, вы победили и попали в список лидеров!" + Colors.RESET);
            try {
                FileWriter fw = new FileWriter("leaders.csv", true);
                PrintWriter pw = new PrintWriter(fw);

                pw.append(login);
                pw.append(",");
                pw.append(scoreToString);
                pw.append("\n");

                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Не удалось записать результаты!");
            }
        } else {
            System.out.println(Colors.RED + "Вы проиграли! Попробуйте ещё раз!" + Colors.RESET);
        }
        System.out.println(Colors.BLUE + "Ваш результат: " + Colors.RESET + Colors.PURPLE + score + Colors.RESET + " баллов");

        try {
            FileWriter fw = new FileWriter("results.csv", true);
            PrintWriter pw = new PrintWriter(fw);

            pw.append(login);
            pw.append(",");
            pw.append(scoreToString);
            pw.append("\n");

            pw.close();
        } catch (Exception e) {
            System.out.println("Не удалось записать результаты!");
        }

        Results.showResults();

    }
}
