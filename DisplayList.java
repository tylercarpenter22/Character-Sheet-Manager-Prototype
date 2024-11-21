import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayList extends JPanel {
    private MainApp app;

    public DisplayList(MainApp app) {
        this.app = app;
        setLayout(new BorderLayout());

        // Create a scrollable area for the player list
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Fetch the list of players
        List<Player> players = app.getPlayerList();

        // Build the display text for each player
        StringBuilder displayText = new StringBuilder();
        for (Player player : players) {
            displayText.append("Name: ").append(player.getName()).append("\n")
                    .append("Level: ").append(player.getLevel()).append("\n")
                    .append("Race: ").append(player.getRace()).append("\n")
                    .append("Background: ").append(player.getBackground()).append("\n")
                    .append("Class: ").append(player.getCharclass()).append("\n")
                    .append("Stats: ").append(player.getStats()).append("\n")
                    .append("=================================\n");
        }

        // Set the text to the JTextArea
        displayArea.setText(displayText.toString());

        // Add the JTextArea to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Back button to return to MainMenu
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> app.showPanel("MainMenu"));
        add(backButton, BorderLayout.SOUTH);
    }
}
