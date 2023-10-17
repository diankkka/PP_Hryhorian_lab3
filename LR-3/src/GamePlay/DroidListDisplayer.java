package GamePlay;
import Droids.Droid;
import java.util.List;
public class DroidListDisplayer {
    public static void displayDroidList(List<Droid> droids) {
        System.out.println("List of created droids:");
        for (Droid droid : droids) {
            droid.showDetails();
            System.out.println("----------------------------");
        }
    }

    public static void displayDroidStatistics(List<Droid> droids) {
        System.out.println("Droid statistics:");
        for (Droid droid : droids) {
            System.out.println("Name: " + droid.getName());
            System.out.println("Health: " + droid.getHealth());
            System.out.println("Damage: " + droid.getDamage());
            System.out.println("Speed: " + droid.getSpeed());
            System.out.println("Energy: " + droid.getEnergy());
            System.out.println("Team: " + droid.getTeam());
            System.out.println("----------------------------");
        }
    }
}
