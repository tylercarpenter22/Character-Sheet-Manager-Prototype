import java.util.ArrayList;
import java.util.List;

public class Race {

    // Instance Variables
    private String racename;
    private String description;
    private boolean hasSubrace;
    private String subrace;

    // Constructor for Race with subrace
    public Race(String racename, String description, boolean hasSubrace, String subrace){
        this.racename = racename;
        this.description = description;
        this.hasSubrace = hasSubrace;
        this.subrace = subrace;
    }

    // Constructor for Race without subrace
    public Race(String racename, String description){
        this.racename = racename;
        this.description = description;
        this.hasSubrace = false;
        this.subrace = null;
    }

    // Getters
    public String getRacename() {
        return racename;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasSubrace() {
        return hasSubrace;
    }

    public String getSubrace() {
        return subrace;
    }
    public void setSubraceName(String subrace){
        this.subrace = subrace;
    }

    @Override
    public String toString() {
        return racename + (hasSubrace ? " (Subrace: " + subrace + ")" : "");
    }

    // Static method to create default races
    public List<Race> getDefaultRaces() {
        List<Race> races = new ArrayList<>();

        // Dragonborn Race Preset
        races.add(new Race("Dragonborn", "Proud dragon-like humanoids"));

        // Dwarf Race Presents - Subraces  CAVERN_DWARF HILL_DWARF
        races.add(new Race("Dwarf", "Short, sturdy humanoids known for their resilience", true, "Cavern Dwarf"));
        races.add(new Race("Dwarf", "Short, sturdy humanoids known for their resilience", true, "Hill Dwarf"));
        
        // Elf Race Presets - Subraces HIGH_ELF WOODLAND_ELF,
        races.add(new Race("Elf", "Graceful, magical humanoids", true, "High Elf"));
        races.add(new Race("Elf", "Graceful, magical humanoids", true, "Woodland Elf"));
        
        //Half-Elf Race Preset
        races.add(new Race("Half-Elf", "Part human, part elf"));

        // Gnome Race Preset
        races.add(new Race("Gnome", "Small, clever humanoids"));

        // Half-Orc Race Preset
        races.add(new Race("Half-Orc", "Part human, part orc"));

        // Halfling Race Presets - Subraces GREEN_HALFLING LIGHTFOOT_HALFLING
        races.add(new Race("Halfling", "Small, nimble humanoids", true, "Green Halfling"));
        races.add(new Race("Halfling", "Small, nimble humanoids", true, "Lightfoot Halfling"));

        // Human Race Presets - Subrace VARIRANT_HUMAN
        races.add(new Race("Human", "Adaptable and diverse race"));
        races.add(new Race("Human", "Adaptable and diverse race", true, "Variant Human"));

        // Tiefling Race Preset
        races.add(new Race("Tiefling", "Humanoids with demonic heritage"));

        return races;
    }
}
