package FileIO;
import java.io.FileWriter;
import java.io.IOException;
import Droids.BattleResult;
import java.util.List;

public class SaveToFile {
    public static void saveBattleToFile(List<BattleResult> results) {
        try {
            FileWriter writer = new FileWriter("D:\\nulp\\applied programming\\lr3.txt");

            for (BattleResult result : results) {
                writer.write("Fight between " + result.getDroid1().getName() + " and " + result.getDroid2().getName() + "\n");
                writer.write(result.getWinner().getName() + " winner!\n");
                writer.write("Damage: " + result.getDamageDealt() + "\n");
                writer.write("----------------------------\n");
            }

            writer.close();
            System.out.println("The results of the battle are saved in the file D:\\nulp\\applied programming\\lr3.txt");
        } catch (IOException e) {
            System.err.println("Error saving battle results to file.");
            e.printStackTrace();
        }
    }
}
