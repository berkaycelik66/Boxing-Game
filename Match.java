public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {
        if (isCheck()) {
            int i = 0;
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("==== ROUND " + (i + 1) + " ====");
                int chance = Math.round((float) Math.random());

                if (chance == 0) {
                    this.f2.health = this.f1.hit(f2);
                    if (isWin()) {
                        break;
                    }

                    this.f1.health = this.f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                } else if (chance == 1) {
                    this.f1.health = this.f2.hit(f1);
                    if (isWin()) {
                        break;
                    }

                    this.f2.health = this.f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                }
                System.out.println(this.f1.name + " Health: " + this.f1.health);
                System.out.println(this.f2.name + " Health: " + this.f2.health);
                i++;
            }
        } else {
            System.out.println("The weights of the athletes do not match.");
        }
    }

    public boolean isCheck() {
        return ((this.f1.weight >= minWeight) && (this.f1.weight <= maxWeight)) && ((this.f2.weight >= minWeight) && (this.f2.weight <= maxWeight));
    }

    public boolean isWin() {
        System.out.println();
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " WON !");
            return true;
        }

        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " WON !");
            return true;
        }

        return false;
    }
}
