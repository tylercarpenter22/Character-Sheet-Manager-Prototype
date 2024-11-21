public enum Background {
    
    ACOLYTE,
    CHARLATAN,
    CRIMINAL,
    ENTERTAINER,
    FOLK_HERO,
    GUILD_ARTISAN,
    NOBLE,
    OUTLANDER,
    SAGE,
    SOLDIER,
    URCHIN;

    @Override
    public String toString() {
        // Replace underscores with spaces and split by space
        String[] words = name().toLowerCase().replace("_", " ").split(" ");
        
        // Capitalize each word and join them back together
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }

        // Remove the trailing space and return the result
        return result.toString().trim();
    } 
    
    // Helper method to find a Background by its name (ignoring case and underscores)
    public static Background findBackgroundByName(String name) {
        for (Background background : values()) {
            if (background.toString().equalsIgnoreCase(name)) {
                return background;
            }
        }
        return null; // Return null if no matching background is found
    }
}
