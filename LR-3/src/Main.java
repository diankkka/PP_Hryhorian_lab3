import Droids.Droid;
import FileIO.SaveFromFile;
import GamePlay.DroidCreator;
import GamePlay.DroidListDisplayer;
import GamePlay.BattleManager;
import GamePlay.ImproveDroids;
import FileIO.SaveToFile;
import Droids.BattleResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Droid> droids = new ArrayList<>();
        List<BattleResult> results = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\tLet's start the game - the battle of the droids");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Create a droid");
            System.out.println("2. Show list of droids");
            System.out.println("3. Start a one-on-one battle");
            System.out.println("4. Improve droids");
            System.out.println("5. Save the battle results to a file");
            System.out.println("6. Download battle results from a file");
            System.out.println("7. Exit the program");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    Droid droid = DroidCreator.createDroid();
                    droids.add(droid);
                }
                case 2 -> DroidListDisplayer.displayDroidList(droids);
                case 3 -> {
                    BattleResult result = BattleManager.startOneOnOneBattle(droids);
                    results.add(result); // Додайте результат бою до списку
                }
                case 4 -> {
                    ImproveDroids improveManager = new ImproveDroids();
                    improveManager.improveDroids(droids);
                }
                case 5 -> {
                    SaveToFile saveToFile = new SaveToFile();
                    saveToFile.saveBattleToFile(results);
                }
                case 6 -> {
                    List<BattleResult> battleResults = SaveFromFile.loadBattleFromFile("D:\\nulp\\applied programming\\lr3.txt", droids);
                    // Вивід інформації про бої
                    for (BattleResult res : battleResults) {
                        Droid droid1 = res.getDroid1();
                        Droid droid2 = res.getDroid2();
                        Droid winner = res.getWinner();
                        int damageDealt = res.getDamageDealt();

                        System.out.println("Fight between " + droid1.getName() + " and " + droid2.getName());
                        System.out.println(winner.getName() + " winner!");
                        System.out.println("Damage: " + damageDealt);
                        System.out.println("----------------------------");
                    }
                }
                case 7 -> {
                    System.out.println("Game over.");
                    return;
                }
                default -> System.out.println("Incorrect choice. Try again.");
            }
        }

    }
}


