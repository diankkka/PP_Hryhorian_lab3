package GamePlay;
import Droids.Droid;
import java.util.Scanner;
public class DroidCreator {

    public static Droid createDroid() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a droid name:");
        String name = scanner.nextLine();

        System.out.println("Enter the droid's health:");
        int health = scanner.nextInt();

        System.out.println("Enter droid damage:");
        int damage = scanner.nextInt();

        System.out.println("Enter the speed of the droid:");
        int speed = scanner.nextInt();

        System.out.println("Enter droid energy:");
        int energy = scanner.nextInt();

        scanner.nextLine();  // очистка буфера

        System.out.println("Enter the team the droid belongs to:");
        String team = scanner.nextLine();

        System.out.println("Droid " + name + " created successfully!");

        return new Droid(name, health, damage, speed, energy, team);
    }


}
