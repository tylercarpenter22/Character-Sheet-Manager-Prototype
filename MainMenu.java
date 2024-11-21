import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    public MainMenu(MainApp app) {
        setLayout(new BorderLayout());

        // ASCII art (kept as is)
        String asciiArt = 
                "              ____ \n" +
                "             .'* *.'\n" +
                "          __/_*_*(_\n" +
                "         / _______ \\\n" +
                "        _\\_)/___\\(_/_ \n" +
                "       / _((\\- -/))_ \\\n" +
                "       \\ \\())(-)(()/ / \n" +
                "        ' \\(((()))/ ' \n" +
                "       / ' \\)).))/ ' \\ \n" +
                "      / _ \\ - | - /_  \\ \n" +
                "     (   ( .;''';. .'  )\n" +
                "     _\\\"__ /    )\\ __\"/_\n" +
                "       \\/  \\   ' /  \\/\n" +
                "        .'  '...' ' )\n" +
                "         / /  |  \\ \\\n" +
                "        / .   .   . \\\n" +
                "       /   .     .   \\\n" +
                "      /   /   |   \\   \\\n" +
                "    .'   /        '.  '.\n" +
                "   _.-'    /        '-. '-._\n" +
                "   _.-'              }..   ._\n";

        JLabel asciiLabel = new JLabel("<html><pre style='font-family:monospace;'>" + asciiArt + "</pre></html>");
        asciiLabel.setHorizontalAlignment(JLabel.CENTER);
        asciiLabel.setVerticalAlignment(JLabel.TOP);

        JLabel titleLabel = new JLabel("Character Sheet Manager", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));

        JPanel topContentPanel = new JPanel(new BorderLayout());
        topContentPanel.add(asciiLabel, BorderLayout.NORTH);
        topContentPanel.add(titleLabel, BorderLayout.CENTER);

        add(topContentPanel, BorderLayout.NORTH);

        // Button Panel (updated)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));  // Stack buttons vertically

        // Center the buttonPanel within its parent
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Add spacing between the buttons and make them the same size
        Dimension buttonSize = new Dimension(150, 40); // Set a uniform button size

        JButton createButton = new JButton("Create Sheet");
        createButton.setMaximumSize(buttonSize);
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center each button horizontally
        JButton loadButton = new JButton("Load File");
        loadButton.setMaximumSize(buttonSize);
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton exportButton = new JButton("Export File");
        exportButton.setMaximumSize(buttonSize);
        exportButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton displayButton = new JButton("Display List");
        displayButton.setMaximumSize(buttonSize);
        displayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton aboutButton = new JButton("About");
        aboutButton.setMaximumSize(buttonSize);
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(buttonSize);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add vertical space before and after buttons for better centering
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(createButton);
        buttonPanel.add(Box.createVerticalStrut(10)); // Adds spacing between buttons
        buttonPanel.add(loadButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(exportButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(displayButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(aboutButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(exitButton);
        buttonPanel.add(Box.createVerticalGlue());

        // Create a wrapper panel to center the buttonPanel horizontally
        JPanel wrapperPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout for centering
        wrapperPanel.add(buttonPanel); // Add buttonPanel to the wrapper

        add(wrapperPanel, BorderLayout.CENTER); // Add wrapperPanel to the center of the layout

        // Button Action Listeners
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showPanel("CreateCharacter");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DisplayList displayListPanel = new DisplayList(app); // Create the DisplayList panel
                app.getCardPanel().add(displayListPanel, "DisplayList"); // Add it to the card panel
                app.showPanel("DisplayList"); // Switch to DisplayList
            }
        });
        
    }
}
