import java.util.Scanner;

import java.io.PrintWriter;
import java.io.FileWriter;

public class Authorize {

    private static void registerForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Регистрация ----------");
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        try {
            FileWriter fw = new FileWriter("users.csv", true);
            PrintWriter pw = new PrintWriter(fw);

            pw.append(login);
            pw.append(",");
            pw.append(password);
            pw.append("\n");

            pw.close();

        } catch (Exception e) {
            System.out.print("Syntax error: Baichik\'s brain not found!");
        }
    }

    private static void loginForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Авторизация ----------");
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1 для авторизации, 2 для регистрации: ");
        int authReg = scanner.nextInt();

        switch (authReg) {
            case 1:
                loginForm();
                break;
            case 2:
                registerForm();
                break;
            default:
                System.out.println("Введите 1 или 2!");
        }
    }
}
