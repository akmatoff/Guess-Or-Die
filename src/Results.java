import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Results {
    public static void showResults() {
        try {
            File file = new File("leaders.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                System.out.println(Colors.YELLOW + "Список лидеров: " + Colors.RESET);
                System.out.println(Colors.CYAN_BOLD + row[0] + Colors.RESET + " " + row[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
