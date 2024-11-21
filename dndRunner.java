import java.util.Random;
import javax.swing.SwingUtilities;

public class dndRunner {
    
    // Method to roll dice
    public static int roll(int numRolls, int numSides) {
            Random random = new Random(); //S Create a new random object
            int total = 0;
    
            // Roll the die 'numRolls' times
            for (int i = 0; i < numRolls; i++) {
                total += random.nextInt(numSides) + 1;  // Roll the die and add the result to total
            }
            System.out.printf("\nRolling %dd%d dice.. \n", numRolls, numSides);
            return total;  // Return the total sum of the rolls
        }


        public static void main(String args[]){
            
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new MainMenu(null).setVisible(true);
                }
            });
            
     }
}
            /* 
            Stats joeStats = new Stats();
            Mob Goblin = new Mob("Goblin Joe", 2, "Humanoid", joeStats);
            Goblin.displayCharacterSheet();
            
            Stats ellaStats = new Stats(10, 14, 12, 18, 15, 16);
            Character Ella = new Character("Ella", 3, Race.ELF, Subrace.WOODLAND_ELF, Background.NOBLE, CharacterClass.SORCERER, ellaStats);
            Ella.displayCharacterSheet();

            System.out.println(roll(3,8));
            

             // Create a new Character object
            Character myCharacter = new Character(null, 1, null, null, null, null);

            // Start character creation process
            myCharacter.createCharacter();

            // After creation, display the character sheet
            System.out.println("\nYour character has been created:");
            myCharacter.displayCharacterSheet();


            // Run the application
            SwingUtilities.invokeLater(() -> new DnDCharacterManagerGUI().createAndShowGUI());
            */
            
