public class Player extends Character {

    // Default constructor
    public Player() {
        super(); // Call the superclass (Character) constructor with default values
    }

    // Parameterized constructor
    public Player(String name, int level, Race race, Background background, CharacterClass charclass, Stats stats) {
        super(name, level, race, background, charclass, stats); // Call the superclass constructor with parameters
    }
}
