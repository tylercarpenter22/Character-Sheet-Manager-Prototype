import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Character creation panel that allows users to create a character
 * with options for race, subrace, class, and other details.
 */
public class CharacterCreation extends JPanel {

    // Declare UI components for the character creation form
    private JComboBox<String> characterTypeComboBox;  // Dropdown for character type (Player, Enemy, NPC)
    private JPanel formPanel;  // Panel to hold the form components dynamically
    private JComboBox<String> raceComboBox;  // Dropdown for Race
    private JComboBox<String> classComboBox;  // Dropdown for Class
    private JTextField nameField;  // TextField for Name input
    private JComboBox<String> backgroundComboBox;  // Dropdown for Background input
    private JSpinner levelSpinner;  // Spinner for selecting level
    private JComboBox<String> subraceComboBox;  // Dropdown for Subrace
    private JLabel subraceLabel;  // Label for Subrace dropdown

    // Labels to display character stats
    private JLabel acLabel;
    private JLabel initiativeLabel;
    private JLabel hitDiceLabel;
    private JLabel hitPointsLabel;

    /**
     * Constructor for the CharacterCreation panel. Sets up the UI components and the layout.
     * @param app Reference to the main application to switch between panels.
     */
    public CharacterCreation(MainApp app) {
        // Set the layout for the main panel
        setLayout(new BorderLayout());

        // Create a panel for the top section (Character Type drop-down)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel characterTypeLabel = new JLabel("Character Type:");
        String[] characterTypes = { "Player", "Enemy", "NPC" };
        characterTypeComboBox = new JComboBox<>(characterTypes);

        // Add components to the top panel
        topPanel.add(characterTypeLabel);
        topPanel.add(characterTypeComboBox);
        add(topPanel, BorderLayout.NORTH);

        // Create the form panel (will update dynamically based on character type)
        formPanel = new JPanel(new GridBagLayout());
        add(formPanel, BorderLayout.CENTER);

        // Add the Back button to navigate back to the main menu
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> app.showPanel("MainMenu"));

        // Add the Confirm button to finalize character creation
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            // Create a Player object based on user input
            Player newPlayer = createPlayer();
            // Display confirmation with the player's name
            // If the player is created successfully, add them to the list
            if (newPlayer != null) {
                app.addPlayer(newPlayer);
                // Display confirmation with the player's name
                JOptionPane.showMessageDialog(CharacterCreation.this, 
                        "Character Created: " + newPlayer.getName());
            }
        });

        // Add the Back and Confirm buttons to the bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);
        bottomPanel.add(confirmButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Set action listener for character type drop-down to update the form
        characterTypeComboBox.addActionListener(e -> {
            String selectedType = (String) characterTypeComboBox.getSelectedItem();
            updateForm(selectedType);
        });

        // Initially display the Player form
        updateForm("Player");
    }

    /**
     * Method to update the form based on the selected character type.
     * This will dynamically show or hide form fields.
     * @param characterType The selected character type (Player, Enemy, NPC).
     */
    private void updateForm(String characterType) {
        // Clear all components from the form panel before adding new components
        formPanel.removeAll();  

        // If the selected character type is "Player", display the Player creation form
        if ("Player".equals(characterType)) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(5, 5, 5, 5);  // Set spacing for components
            gbc.anchor = GridBagConstraints.WEST;

            // Player Name field
            formPanel.add(new JLabel("Name:"), gbc);
            gbc.gridx = 1;
            nameField = new JTextField(20);
            formPanel.add(nameField, gbc);

            // Race drop-down
            gbc.gridx = 0;
            gbc.gridy++;
            formPanel.add(new JLabel("Race:"), gbc);
            gbc.gridx = 1;
            String[] races = { 
                "Dragonborn", 
                "Dwarf", 
                "Elf", 
                "Half-Elf", 
                "Gnome", 
                "Half-Orc", 
                "Halfling", 
                "Human", 
                "Tiefling" 
            }; 
            raceComboBox = new JComboBox<>(races);
            raceComboBox.setRenderer(new CustomComboBoxRenderer());
            formPanel.add(raceComboBox, gbc);

            // Subrace (initially hidden)
            gbc.gridx = 2; // Place subrace dropdown next to the race field
            subraceLabel = new JLabel("Subrace:");
            formPanel.add(subraceLabel, gbc);
            gbc.gridx = 3;
            subraceComboBox = new JComboBox<>();  // Empty for now, will be updated based on race selection
            subraceComboBox.setRenderer(new CustomComboBoxRenderer());
            formPanel.add(subraceComboBox, gbc);

            // Initially hide subrace components
            subraceLabel.setVisible(false);
            subraceComboBox.setVisible(false);

            // Add action listener for the raceComboBox to update subraces dynamically
            raceComboBox.addActionListener(e -> updateSubraceOptions());

            // Class drop-down
            gbc.gridx = 0;
            gbc.gridy++;
            formPanel.add(new JLabel("Class:"), gbc);
            gbc.gridx = 1;
            String[] classes = { 
                "Barbarian", 
                "Bard", 
                "Cleric", 
                "Druid", 
                "Fighter",
                "Monk", 
                "Paladin", 
                "Ranger", 
                "Rogue", 
                "Sorcerer", 
                "Warlock", 
                "Wizard" 
            };  
            classComboBox = new JComboBox<>(classes);
            classComboBox.setRenderer(new CustomComboBoxRenderer());
            formPanel.add(classComboBox, gbc);

            // Background field (dropdown for selecting background)
            gbc.gridx = 0;
            gbc.gridy++;
            formPanel.add(new JLabel("Background:"), gbc);
            gbc.gridx = 1;
            String[] backgrounds = { 
                "Acolyte", 
                "Charlatan", 
                "Criminal", 
                "Entertainer", 
                "Folk Hero", 
                "Guild Artisan", 
                "Noble", 
                "Outlander", 
                "Sage", 
                "Soldier", 
                "Urchin" 
            };
            backgroundComboBox = new JComboBox<>(backgrounds);  // Initialize backgroundComboBox
            backgroundComboBox.setRenderer(new CustomComboBoxRenderer());
            formPanel.add(backgroundComboBox, gbc);

            // Level spinner
            gbc.gridx = 0;
            gbc.gridy++;
            formPanel.add(new JLabel("Level:"), gbc);
            gbc.gridx = 1;
            SpinnerModel levelModel = new SpinnerNumberModel(1, 1, 20, 1);  // Min: 1, Max: 20
            levelSpinner = new JSpinner(levelModel);
            formPanel.add(levelSpinner, gbc);

            // Add a panel to display character stats
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 2;
            JPanel statsPanel = new JPanel(new GridLayout(1, 10, 10, 10));
            statsPanel.setBorder(BorderFactory.createTitledBorder("Character Stats"));

            acLabel = new JLabel("AC: ");
            initiativeLabel = new JLabel("Initiative: ");
            hitDiceLabel = new JLabel("Hit Dice: ");
            hitPointsLabel = new JLabel("Hit Points: ");

            statsPanel.add(acLabel);
            statsPanel.add(initiativeLabel);
            statsPanel.add(hitDiceLabel);
            statsPanel.add(hitPointsLabel);

            formPanel.add(statsPanel, gbc);
        }

        // Revalidate and repaint the form panel to apply changes
        formPanel.revalidate();
        formPanel.repaint();
    }

    /**
     * Method to update the subrace options based on the selected race.
     * For example, Elves have High Elf and Wood Elf as subraces.
     */
    private void updateSubraceOptions() {
        String selectedRace = (String) raceComboBox.getSelectedItem();
        String[] subraces = {};

        // Define subrace options based on the selected race
        if ("Elf".equals(selectedRace)) {
            subraces = new String[] { "High Elf", "Wood Elf" };
        } else if ("Dwarf".equals(selectedRace)) {
            subraces = new String[] { "Cavern Dwarf", "Hill Dwarf" };
        } else if ("Halfling".equals(selectedRace)) {
            subraces = new String[] { "Lightfoot Halfling", "Green Halfling" };
        } else if ("Human".equals(selectedRace)) {
            subraces = new String[] { "None", "Variant Human" };
        }

        // Update subraceComboBox with the new subraces
        subraceComboBox.setModel(new DefaultComboBoxModel<>(subraces));

        // Show or hide subrace components based on the number of subraces available
        if (subraces.length > 0) {
            subraceLabel.setVisible(true);
            subraceComboBox.setVisible(true);
        } else {
            subraceLabel.setVisible(false);
            subraceComboBox.setVisible(false);
        }
    }

    public Player createPlayer() {

        // Collect values from the form fields
        String playerName = nameField.getText();
        String selectedRaceName = (String) raceComboBox.getSelectedItem();
        String selectedClassName = (String) classComboBox.getSelectedItem();
        String selectedSubrace = (String) subraceComboBox.getSelectedItem();
        String background = (String) backgroundComboBox.getSelectedItem();
        int level = (int) levelSpinner.getValue();

        // Determine Race using the RacePresets helper method
        Race selectedRace = RacePresets.findRaceByName(selectedRaceName);
        // Handle case when no race is found
        if (selectedRace == null) {
            JOptionPane.showMessageDialog(this, "Race not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // If there's a subrace, set the subrace in the Race object (optional, depending on your Race structure)
        if (selectedSubrace != null && selectedRace.hasSubrace()) {
            selectedRace.setSubraceName(selectedSubrace); // Assuming you have a setter in Race class
        }

        // Determine Background
        Background selectedBackground = Background.findBackgroundByName(background);

        if (selectedBackground == null) {
            JOptionPane.showMessageDialog(this, "Background not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Determine Class
        CharacterClass selectedClass = CharacterClass.findClassByName(selectedClassName);

        if (selectedClass == null) {
            JOptionPane.showMessageDialog(this, "Class not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Use Default Stats
        // TODO
        Stats tStats = new Stats();

        // Create and return a new Player object with the selected attributes
        Player newPlayer = new Player(playerName, level, selectedRace, selectedBackground, selectedClass, tStats);

        return newPlayer;
    }

    /**
     * Custom renderer for JComboBox to display additional information.
     */
    private class CustomComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            // Customize the label to display additional information
            // For example, you can set an icon or additional text based on the value
            label.setText(value.toString());
            return label;
        }
    }
}