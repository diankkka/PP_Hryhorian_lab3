package Droids;
public class BattleResult {
    Droid droid1;
    Droid droid2;
    Droid winner;
    private int damageDealt;

    public BattleResult(Droid droid1, Droid droid2, Droid winner, int damageDealt) {
        this.droid1 = droid1;
        this.droid2 = droid2;
        this.winner = winner;
        this.damageDealt = damageDealt;
    }

    public Droid getDroid1() {
        return droid1;
    }

    public Droid getDroid2() {
        return droid2;
    }

    public Droid getWinner() {
        return winner;
    }

    public void setWinner(Droid winner) {
        this.winner = winner;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }
    public int getDamageDealt() {
        return damageDealt;
    }
}

