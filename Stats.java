public class Stats {
    
    // Stats
    private int Strength;
    private int Dexterity;
    private int Constitution;
    private int Intelligence;
    private int Wisdom;
    private int Charisma;

    // Constructors
    public Stats( int str, int dex, int con, int intl, int wis, int cha){
        this.Strength = str;
        this.Dexterity = dex;
        this.Constitution = con;
        this.Intelligence = intl;
        this.Wisdom = wis;
        this.Charisma = cha;
    }
    // Default Constructor
    public Stats(){
        this.Strength = 10;
        this.Dexterity = 10;
        this.Constitution = 10;
        this.Intelligence = 10;
        this.Wisdom = 10;
        this.Charisma = 10;
    }

    // Instance Methods
    public void displayStats() {
        System.out.println("Stats");
        System.out.println("------");
        System.out.printf("Strength: %d\n", this.Strength);
        System.out.printf("Dexterity: %d\n", this.Dexterity);
        System.out.printf("Constitution: %d\n", this.Constitution);
        System.out.printf("Intelligence: %d\n", this.Intelligence);
        System.out.printf("Wisdom: %d\n", this.Wisdom);
        System.out.printf("Charisma: %d\n", this.Charisma);
    }
}
