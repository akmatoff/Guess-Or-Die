import java.awt.event.InputEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Authorize {
    public static String login;
    public static String password;

    public Authorize() {
        login = this.getLogin();
    }

    public String getLogin() {
        return login;
    }

    static void authOrReg() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите " + Colors.GREEN_BOLD + "1 " + Colors.RESET + "для авторизации, " + Colors.CYAN_BOLD + "2 " + Colors.RESET + "для регистрации: ");


        try {
            int authReg = scanner.nextInt();
            if (authReg == 1) {
                loginForm();
            } else if (authReg == 2) {
                registerForm();
            } else {
                System.out.println(Colors.RED + "Ошибка: принимает только цифры 1 или 2!" + Colors.RESET);
                authOrReg();
            }
        } catch (InputMismatchException e) {
            System.out.println(Colors.RED + "Ошибка: Введите число 1 или 2!" + Colors.RESET);
            System.exit(0);
        }
    }

    static void registerForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Регистрация ----------");
        System.out.println("Введите логин: ");
        login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        password = scanner.nextLine();
        System.out.println("Введите пароль еще раз для подтверждения: ");
        String confirm = scanner.nextLine();
        if (!confirm.equals(password)) {
            System.out.println(Colors.RED + "Пароли не совпадают! Повторите попытку!" + Colors.RESET);
            registerForm();
        }

        try {
            File file = new File("users.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            String[] row = {};
            while ((line = br.readLine()) != null) {
                row = line.split(",");
                while (login.equals(row[0])) {
                    System.out.println(Colors.RED + "Пользователь уже существует! Авторизуйтесь или введите другой логин!" + Colors.RESET);
                    authOrReg();
                }
            }
            if (!login.equals(row[0])) {
                System.out.println(Colors.GREEN + "Добро пожаловать, " + Colors.RESET + Colors.PURPLE + login + "!" + Colors.RESET);
                System.out.println(Colors.GREEN + "Регистрация прошла успешно!" + Colors.RESET);
                try {
                    FileWriter fw = new FileWriter("users.csv", true);
                    PrintWriter pw = new PrintWriter(fw);

                    pw.append(login);
                    pw.append(",");
                    pw.append(password);
                    pw.append("\n");

                    pw.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void loginForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Авторизация ----------");
        System.out.println("Введите логин: ");
        login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        password = scanner.nextLine();

        try {
            File file = new File("users.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            String[] row = {};
            while ((line = br.readLine()) != null) {
                row = line.split(",");

                if (login.equals(row[0]) && password.equals(row[1])) {
                    System.out.println(Colors.GREEN + "Добро пожаловать, " + Colors.RESET + Colors.PURPLE + login + "!" + Colors.RESET);
                    break;
                }
            }
            if (!login.equals(row[0]) || !password.equals(row[1])) {
                System.out.println(Colors.RED + "Неверный логин или пароль! Повторите попытку!" + Colors.RESET);
                loginForm();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
