import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private List<Player> playerList = new ArrayList<>(); // List to store Player objects

    public MainApp() {
        setTitle("Character Sheet Manager");
        setSize(690, 690);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up CardLayout for switching views
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create the different panels
        MainMenu mainMenu = new MainMenu(this);
        CharacterCreation createCharacterPanel = new CharacterCreation(this);

        // Add panels to the CardLayout container
        cardPanel.add(mainMenu, "MainMenu");
        cardPanel.add(createCharacterPanel, "CreateCharacter");

        // Add the cardPanel to the frame
        add(cardPanel);

        // Show the MainMenu first
        cardLayout.show(cardPanel, "MainMenu");
    }

    // Method to switch to a specific panel
    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }

    // Method to add a player to the list
    public void addPlayer(Player player) {
        playerList.add(player);
    }

    // Method to get the player list
    public List<Player> getPlayerList() {
        return playerList;
    }

    // Method to access the cardPanel
    public JPanel getCardPanel() {
        return cardPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }
}
