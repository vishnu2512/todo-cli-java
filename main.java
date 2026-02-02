import java.util.*;

public class Main {
    static List<String> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
            else break;
        }
    }
}
