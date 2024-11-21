public class Mob extends Character {
    private String type;  // Type of enemy (e.g., Beast, Undead)

    // Constructor
    public Mob(String name, int level, String type, Stats stats) {
        super(name, level, null, null, null, stats);  // Calling the parent (Entity) constructor
        this.type = type;
    }

    // Getter for type
    public String getType() {
        return this.type;
    }
}
