package Droids;

public class Droid {
    private String name;
    private int health;
    private int damage;
    private int speed;
    private int energy;
    private String team;

    public Droid(String name, int health, int damage, int speed, int energy, String team) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.energy = energy;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void attack(Droid target) {
        int damageDealt = this.damage;
        System.out.println(this.name + " attacks " + target.name + " and causes " + damageDealt + " damage.");
        target.health -= damageDealt;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Heakth: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Speed: " + speed);
        System.out.println("Energy: " + energy);
        System.out.println("Team: " + team);
    }


}
