package Droids;

public class Battle {
    public static BattleResult fight(Droid droid1, Droid droid2) {
        System.out.println("Fight between " + droid1.getName() + " and " + droid2.getName());
        Droid winner = null;  // Ініціалізуємо переможця як null
        int damageDealt = 0;  // Ініціалізуємо пошкодження як 0

        while (droid1.getHealth() > 0 && droid2.getHealth() > 0) {
            droid1.attack(droid2);
            if (droid2.getHealth() <= 0) {
                System.out.println(droid1.getName() + " winner!");
                winner = droid1;
                damageDealt = droid1.getDamage() * (droid1.getHealth() > 0 ? 1 : 0);  // Обчислюю пошкодження
                break;
            }
            droid2.attack(droid1);
            if (droid1.getHealth() <= 0) {
                System.out.println(droid2.getName() + " winner!");
                winner = droid2;
                damageDealt = droid2.getDamage() * (droid2.getHealth() > 0 ? 1 : 0);  // Обчислюю пошкодження
                break;
            }
        }

        if (winner == null) {
            System.out.println("The fight ended in a draw!");
        }

        return new BattleResult(droid1, droid2, winner, damageDealt);
    }
}

