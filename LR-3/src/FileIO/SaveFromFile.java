package FileIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Droids.BattleResult;
import Droids.Droid;
import java.util.ArrayList;
import java.util.List;

public class SaveFromFile {
    public static List<BattleResult> loadBattleFromFile(String fileName, List<Droid> droids) {
        List<BattleResult> battleResults = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            BattleResult currentResult = null;

            while ((line = reader.readLine()) != null) {
                // Якщо рядок містить "Fight between", це новий запис про бій
                if (line.startsWith("Fight between")) {
                    if (currentResult != null) {
                        battleResults.add(currentResult);
                    }

                    String[] parts = line.split(" ");
                    if (parts.length >= 4) {
                        String droid1Name = parts[2];
                        String droid2Name = parts[4];

                        Droid droid1 = findDroidByName(droid1Name, droids);
                        Droid droid2 = findDroidByName(droid2Name, droids);

                        if (droid1 != null && droid2 != null) {
                            currentResult = new BattleResult(droid1, droid2, null, 0);
                        }
                    }
                } else if (line.endsWith("winner!")) {
                    String[] parts = line.split(" ");
                    String winnerName = parts[0];
                    // Визначення переможця
                    Droid winner = findDroidByName(winnerName, droids);

                    if (winner != null && currentResult != null) {
                        currentResult.setWinner(winner);
                    }
                } else if (line.startsWith("Damage:")) {
                    String[] parts = line.split(" ");
                    if (parts.length >= 2) {
                        int damageDealt = Integer.parseInt(parts[1].trim());

                        if (currentResult != null) {
                            currentResult.setDamageDealt(damageDealt);
                        }
                    }
                }

            }

            // Додаю останній запис, якщо він існує
            if (currentResult != null) {
                battleResults.add(currentResult);
            }
        } catch (IOException e) {
            System.err.println("Error loading battle from file.");
            e.printStackTrace();
        }

        return battleResults;
    }

    // Метод для пошуку дроїда за ім'ям
    private static Droid findDroidByName(String name, List<Droid> droids) {
        for (Droid droid : droids) {
            if (droid.getName().equals(name)) {
                return droid;
            }
        }
        return null;
    }
}
