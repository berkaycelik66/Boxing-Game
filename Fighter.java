public class Fighter {
    String name;
    int maxDamage;
    int health;
    int weight;
    double dodge;

    public Fighter(String name, int maxDamage, int health, int weight, double dodge) {
        this.name = name;
        this.maxDamage = maxDamage;
        this.health = health;
        this.weight = weight;

        if (dodge >= 0 && dodge <= 100) {
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }
    }

    public int hit(Fighter foe) {
        int damage = (int)(Math.random() * maxDamage) + 1;

        System.out.println(this.name + " attacked " + foe.name + " => Result: " + damage + " Damage");

        if (foe.isDodge()) {
            System.out.println("*** " + foe.name + " covered the incoming damage.");
            return foe.health;
        }

        if ((foe.health - damage) < 0) {
            return 0;
        }

        return (foe.health - damage);
    }

    public boolean isDodge() {
        double randomValue = Math.random() * 100;
        return randomValue <= this.dodge;
    }
}
