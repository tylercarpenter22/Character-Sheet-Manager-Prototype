import java.util.Arrays;
import java.util.List;

/**
 * Contains predefined races and subraces for the character creation system.
 */
public class RacePresets {

    // Dragonborn Race Preset
    public static final Race DRAGONBORN = new Race("Dragonborn", "Proud dragon-like humanoids");

    // Dwarf Race Presets - Subraces: CAVERN_DWARF, HILL_DWARF
    public static final Race DWARF_CAVERN = new Race("Dwarf", "Short, sturdy humanoids known for their resilience", true, "Cavern Dwarf");
    public static final Race DWARF_HILL = new Race("Dwarf", "Short, sturdy humanoids known for their resilience", true, "Hill Dwarf");

    // Elf Race Presets - Subraces: HIGH_ELF, WOODLAND_ELF
    public static final Race ELF_HIGH = new Race("Elf", "Graceful, magical humanoids", true, "High Elf");
    public static final Race ELF_WOODLAND = new Race("Elf", "Graceful, magical humanoids", true, "Woodland Elf");

    // Half-Elf Race Preset
    public static final Race HALF_ELF = new Race("Half-Elf", "Part human, part elf");

    // Gnome Race Preset
    public static final Race GNOME = new Race("Gnome", "Small, clever humanoids");

    // Half-Orc Race Preset
    public static final Race HALF_ORC = new Race("Half-Orc", "Part human, part orc");

    // Halfling Race Presets - Subraces: GREEN_HALFLING, LIGHTFOOT_HALFLING
    public static final Race HALFLING_GREEN = new Race("Halfling", "Small, nimble humanoids", true, "Green Halfling");
    public static final Race HALFLING_LIGHTFOOT = new Race("Halfling", "Small, nimble humanoids", true, "Lightfoot Halfling");

    // Human Race Presets - Subrace: VARIANT_HUMAN
    public static final Race HUMAN = new Race("Human", "Adaptable and diverse race");
    public static final Race HUMAN_VARIANT = new Race("Human", "Adaptable and diverse race", true, "Variant Human");

    // Tiefling Race Preset
    public static final Race TIEFLING = new Race("Tiefling", "Humanoids with demonic heritage");

    // Overall Default Race List
    public static final List<Race> defaultRaces = Arrays.asList(
        DRAGONBORN, DWARF_CAVERN, DWARF_HILL, ELF_HIGH, ELF_WOODLAND, 
        HALF_ELF, GNOME, HALF_ORC, HALFLING_GREEN, HALFLING_LIGHTFOOT, 
        HUMAN, HUMAN_VARIANT, TIEFLING
    );

    /**
     * Finds a race from the default races list by its name.
     * @param raceName The name of the race to search for.
     * @return The matching Race object, or null if not found.
     */
    public static Race findRaceByName(String raceName) {
        for (Race race : defaultRaces) {
            if (race.getRacename().equalsIgnoreCase(raceName)) {
                return race;
            }
        }
        return null; // Return null if no matching race is found
    }
}
