import java.io.File;
import java.util.Scanner;

public class Ex10_ListFiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = sc.nextLine();
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            System.out.println("\nFiles in the directory:");
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path.");
        }
        sc.close();
    }
}
