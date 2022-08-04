public class Main {
    public static void main(String[] args) {
        Fighter marc = new Fighter("Marc", 25, 100, 90, 40);
        Fighter alex = new Fighter("Alex", 25, 95, 100, 30);
        Match match = new Match(marc, alex, 90, 100);
        match.run();
    }
}
