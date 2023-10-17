package GamePlay;
import Droids.Droid;
import java.util.List;
import java.util.Scanner;

public class ImproveDroids {
    public static void improveDroids(List<Droid> droids) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a droid to upgrade:");
        DroidListDisplayer.displayDroidList(droids);

        System.out.print("Enter the droid number: ");
        int droidIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (droidIndex < 0 || droidIndex >= droids.size()) {
            System.out.println("Incorrect droid selection.");
            return;
        }

        Droid selectedDroid = droids.get(droidIndex);

        System.out.println("Select an option to improve:");
        System.out.println("1. Health");
        System.out.println("2. Damage");
        System.out.println("3. Speed");
        System.out.print("Your choice: ");
        int statChoice = scanner.nextInt();
        scanner.nextLine();

        int increaseAmount = 0;

        switch (statChoice) {
            case 1:
                System.out.print("Enter the amount of health to upgrade: ");
                increaseAmount = scanner.nextInt();
                selectedDroid.setHealth(selectedDroid.getHealth() + increaseAmount);
                break;
            case 2:
                System.out.print("Enter the amount of damage to improve: ");
                increaseAmount = scanner.nextInt();
                selectedDroid.setDamage(selectedDroid.getDamage() + increaseAmount);
                break;
            case 3:
                System.out.print("Enter the amount of speed to improve: ");
                increaseAmount = scanner.nextInt();
                selectedDroid.setSpeed(selectedDroid.getSpeed() + increaseAmount);
                break;
            default:
                System.out.println("Incorrect parameter selection.");
                return;
        }

        System.out.println("The improvement is complete. New droid characteristics:");
        selectedDroid.showDetails();
    }

}
