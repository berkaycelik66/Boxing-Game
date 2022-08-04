public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    double dodge;

    public Fighter(String name, int damage, int health, int weight, double dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;

        if (dodge >= 0 && dodge <= 100) {
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }
    }

    public int hit(Fighter foe) {

        System.out.println(this.name + " attacked " + foe.name + " => Result: " + this.damage + " Damage");

        if (foe.isDodge()) {
            System.out.println("*** " + foe.name + " covered the incoming damage.");
            return foe.health;
        }

        if ((foe.health - this.damage) < 0) {
            return 0;
        }

        return (foe.health - this.damage);
    }

    public boolean isDodge() {
        double randomValue = Math.random() * 100;
        return randomValue <= this.dodge;
    }
}
