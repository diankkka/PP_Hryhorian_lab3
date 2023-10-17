package GamePlay;
import Droids.BattleResult;
import Droids.Droid;
import Droids.Battle;
import java.util.List;
import java.util.Scanner;
public class BattleManager {
    public static BattleResult startOneOnOneBattle(List<Droid> droids) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose two droids for a 1v1 battle:");
        DroidListDisplayer.displayDroidList(droids);

        System.out.print("Enter the number of the first droid: ");
        int index1 = scanner.nextInt() - 1;

        System.out.print("Enter the number of the second droid: ");
        int index2 = scanner.nextInt() - 1;

        if (index1 < 0 || index1 >= droids.size() || index2 < 0 || index2 >= droids.size()) {
            System.out.println("Incorrect choice of droids.");
            return null;
        }

        Droid droid1 = droids.get(index1);
        Droid droid2 = droids.get(index2);

        return Battle.fight(droid1, droid2);
    }

}
