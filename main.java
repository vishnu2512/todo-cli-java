import java.util.*;
import java.io.*;

public class Main {

    static List<String> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {

        loadTasks(); // load when program starts

        while (true) {
            System.out.println("\n1.Add  2.List  3.Delete  4.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Task: ");
                tasks.add(sc.nextLine());
            }
            else if (choice == 2) {
                for (int i = 0; i < tasks.size(); i++)
                    System.out.println(i + " -> " + tasks.get(i));
            }
            else if (choice == 3) {
                System.out.print("Index: ");
                int idx = sc.nextInt();
                if (idx < tasks.size()) tasks.remove(idx);
            }
            else {
                saveTasks(); // save before exit
                break;
            }
        }
    }

    // SAVE tasks to file
    static void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.println(task);
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks");
        }
    }

    // LOAD tasks from file
    static void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            // first time file may not exist, ignore
        }
    }
}
