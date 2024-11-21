import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * The Character class represents a playable character in the D&D simulator game.
 * It allows for interactive creation of a character by selecting attributes such as
 * name, race, background, class, and stats. The character sheet can also be displayed
 * to show current details of the character.
 * 
 * Attributes include the character's name, race, background, class, and core stats.
 * The class uses enums for Race, Background, and CharacterClass for structured input.
 * 
 * @author Tyler Carpenter
 * @since 2024-11-09
 */
public class Character {

    // Fields representing key character attributes
    private String name;              // Character's name
    private int level;                // Character's level (initially set)
    //private int health;               // Character's health
    //private String size;              // Character's size (small, medium, large)
    private Race race;                // Character's race (enum)
    private Background background;    // Character's background (enum)
    private CharacterClass charclass; // Character's class (enum)
    private Stats stats;              // Character's stats (object for Strength, etc.)
    private Scanner scanner = new Scanner(System.in); // Scanner for user input


    /**
     * Constructor for creating a character with a specified race but no subrace.
     * This variant is used when the character's race does not have a subrace.
     * 
     * @param name The character's name
     * @param level The character's initial level
     * @param race The character's race (enum)
     * @param background The character's background (enum)
     * @param charclass The character's class (enum)
     * @param stats The character's core stats (Strength, Dexterity, etc.)
     */
    public Character(String name, int level, Race race, Background background, CharacterClass charclass, Stats stats) {
        this.name = name;
        this.level = level;
        this.race = race;
        this.background = background;
        this.charclass = charclass;
        this.stats = stats;
    }


    /**
     * Default constructor to create a character with default values.
     * The default character will have level 1, race Human, background Soldier,
     * class Warrior, and default stats.
     */
    public Character() {
        this.name = "Unnamed Hero";
        this.level = 1;
        this.race = RacePresets.HUMAN;  // Default to HUMAN race
        this.background = Background.SOLDIER;  // Default to SOLDIER background
        this.charclass = CharacterClass.FIGHTER;  // Default to WARRIOR class
        this.stats = new Stats();  // Default balanced stats
    }

    // Getter methods to retrieve character attributes
    public String getName() { return name; }
    public int getLevel() { return level; }
    public Race getRace() { return race; }
    public Background getBackground() { return background; }
    public CharacterClass getCharclass() { return charclass; }
    public Stats getStats(){ return stats; }



    // TERMINAL METHODS
    // THESE ARE METHODS NOT USED IN THE GUI INTENDED TO TEST BACK-END LOGIC
    /**
     * Displays the character sheet, showing all relevant information including
     * name, race, background, class, and stats. If null, it will not be displayed.
     */
    public void displayCharacterSheet() {
        System.out.println("\nCharacter Sheet:");
        if(this.name != null) System.out.printf("Name: %s\n", this.name);
        System.out.printf("Level: %d\n", this.level);
        if(this.race != null) System.out.printf("Race: %s\n", this.race);
        if(this.background != null) System.out.printf("Background: %s\n", this.background);
        if(this.charclass != null) System.out.printf("Class: %s\n", this.charclass);
        if(this.stats != null) this.stats.displayStats();
        System.out.println();
    }

    /**
     * The createCharacter method allows the user to create a character through a menu system.
     * The user can set various attributes like name, race, background, stats, and class.
     */
    public void createCharacter() {
        boolean creating = true;
        while (creating) {
            int choice = charCreationMenu();

            switch (choice) {
                case 1: 
                    System.out.print("Enter character name: ");
                    name = scanner.nextLine();
                    break;
                case 2: 
                    race = selectRace();
                    break;
                case 3: 
                    background = selectBackground();
                    break;
                case 4: 
                    stats = createStats();
                    break;
                case 5: 
                    charclass = selectClass();
                    break;
                case 6: 
                    if (name == null) {
                        System.out.println("Character creation cannot be completed without a name.");
                    } else {
                        creating = false;
                        System.out.println("Character creation complete.");
                        break;
                    }
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    /**
     * Displays the character creation menu and prompts the user for a choice.
     * @return The user's choice as an integer.
     */
    private int charCreationMenu() {
        int choice = -1; // Initialize choice to an invalid number
        boolean validInput = false; // Flag for valid input

        while (!validInput) {
            System.out.println("\nCharacter Creation Menu:");
            System.out.println("1. Name: " + (name != null ? name : "Not Set"));
            System.out.println("3. Background: " + (background != null ? background : "Not Set"));
            System.out.println("4. Stats: " + (stats != null ? "Set" : "Not Set"));
            System.out.println("5. Class: " + (charclass != null ? charclass : "Not Set"));
            System.out.println("6. Finish Character Creation");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                } else {
                    validInput = true; // Valid input received
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return choice;
    }

    /**
     * Prompts the user to select a race from the available race options.
     * This method continues until a valid race is selected.
     * @return The selected Race.
     */
    private Race selectRace() {
        Race selectedRace = null; // Initialize selectedRace to null
        boolean validInput = false; // Flag to track valid input

        while (!validInput) { // Loop until a valid race is selected
            System.out.println("\nAvailable Races:");
            
            // Display all available races
            Map<String, Race> raceMap = new HashMap<>();
            raceMap.put("DRAGONBORN", RacePresets.DRAGONBORN);
            raceMap.put("DWARF", RacePresets.DWARF_CAVERN); // Just displaying one Dwarf, will handle subraces later
            raceMap.put("ELF", RacePresets.ELF_HIGH); // Just displaying one Elf, will handle subraces later
            raceMap.put("HALF_ELF", RacePresets.HALF_ELF);
            raceMap.put("GNOME", RacePresets.GNOME);
            raceMap.put("HALF_ORC", RacePresets.HALF_ORC);
            raceMap.put("HALFLING", RacePresets.HALFLING_GREEN); // Just displaying one Halfling, will handle subraces later
            raceMap.put("HUMAN", RacePresets.HUMAN); // Default Human, will handle variant later
            raceMap.put("TIEFLING", RacePresets.TIEFLING);

            for (String raceKey : raceMap.keySet()) {
                System.out.println(raceKey);
            }

            System.out.print("Enter race: ");
            String input = scanner.nextLine().toUpperCase();

            // Try to find the race in the map
            if (raceMap.containsKey(input)) {
                selectedRace = raceMap.get(input);
                validInput = true;
            } else {
                System.out.println("Invalid race selected. Please try again.");
            }
        }

        return selectedRace; // Return the selected race
    }

    /**
     * Prompts the user to select a background from the available background options.
     * This method assumes Background is an enum type.
     * @return The selected Background.
     */
    private Background selectBackground() {
        Background selectedBackground = null; // Initialize selectedBackground to null
        boolean validInput = false; // Flag to track valid input
    
        while (!validInput) { // Loop until a valid background is selected
            System.out.println("Available Backgrounds:");
            for (Background bg : Background.values()) {
                System.out.println(bg);
            }
            System.out.print("Enter background: ");
            String input = scanner.next().toUpperCase();
    
            try {
                selectedBackground = Background.valueOf(input); // Attempt to get the enum constant
                validInput = true; // If successful, set validInput to true
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid background selected. Please try again."); // Inform the user of the invalid input
            }
        }
        return selectedBackground; // Return the selected background
    }

    /**
     * Prompts the user to select a class from the available class options.
     * This method assumes CharacterClass is an enum type.
     * @return The selected CharacterClass.
     */
    private CharacterClass selectClass() {
        System.out.println("Available Classes:");
        for (CharacterClass cc : CharacterClass.values()) {
            System.out.println(cc);
        }
        System.out.print("Enter class: ");
        String input = scanner.next().toUpperCase();
        return CharacterClass.valueOf(input);  // Validating user input for enum
    }

    /**
     * Prompts the user to input character stats: strength, dexterity, constitution,
     * intelligence, wisdom, and charisma.
     * @return A Stats object with the entered values.
     */
    private Stats createStats() {
        System.out.println("Enter stats (Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma): ");
        System.out.println("Recommended player stat spread: Standard array = 15 14 13 12 10 8, +1 + 2");
        int str = scanner.nextInt();
        int dex = scanner.nextInt();
        int con = scanner.nextInt();
        int intl = scanner.nextInt();
        int wis = scanner.nextInt();
        int cha = scanner.nextInt();
        return new Stats(str, dex, con, intl, wis, cha);
    }
}
