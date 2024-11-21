public enum CharacterClass {

    BARBARIAN,
    BARD,
    CLERIC,
    DRUID,
    FIGHTER,
    MONK,
    PALADIN,
    RANGER,
    ROGUE,
    SORCERER,
    WARLOCK,
    WIZARD;

    @Override
    public String toString() {
        // Capitalize the first letter and keep the rest of the string in lowercase
        String str = name().toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }   

    /**
     * Finds a CharacterClass by name, ignoring case.
     * @param name The name of the class to find (e.g., "Fighter")
     * @return The matching CharacterClass, or null if no match is found.
     */
    public static CharacterClass findClassByName(String name) {
        for (CharacterClass characterClass : CharacterClass.values()) {
            if (characterClass.name().equalsIgnoreCase(name)) {
                return characterClass;
            }
        }
        return null; // Return null if no match is found
    }
}
