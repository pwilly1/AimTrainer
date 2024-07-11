//Preston Willis
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private AimTrainer gamePanel;
    private JPanel gameOverPanel;
    private JLabel yourScore;
    

    public main() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // create and add the menu panel
        JPanel menuPanel = createMenuPanel();
        mainPanel.add(menuPanel, "Menu");

        // create and add the game panel
        gamePanel = new AimTrainer(this);
        mainPanel.add(gamePanel, "Game");

        // create and add the game over panel
        gameOverPanel = createGameOverPanel();
        mainPanel.add(gameOverPanel, "GameOver");

        // et up the frame
        this.setTitle("Aim Trainer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // use gridbaglayout to center the components

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some space around the components

        // Create and add the title label
        JLabel titleLabel = new JLabel("Aim Trainer Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size and style
        titleLabel.setForeground(Color.WHITE); // Set the font color

        panel.add(titleLabel, gbc);

        // Create and customize the play button
        JButton playButton = new JButton("Play");
        playButton.setBackground(Color.BLUE); // Set background color
        playButton.setForeground(Color.WHITE); // Set text color
        playButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        playButton.setMargin(new Insets(10, 20, 10, 20)); // Add padding
        playButton.setBorderPainted(false); // Remove border
        playButton.setFocusPainted(false); // Remove focus border
        playButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add margin

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Game");
                gamePanel.startGame(); // Reset and start the game
                gamePanel.requestFocusInWindow(); // Focus on the game panel for keyboard and mouse events
            }
        });

        gbc.gridy = 1; // move to the next row
        panel.add(playButton, gbc);

        panel.setBackground(Color.BLACK); // set background color for the menu panel

        return panel;
    }
    
    private JPanel createGameOverPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GBL to center the components

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some space around the components

        
            
        yourScore = new JLabel("Score: 0"); 
        yourScore.setFont(new Font("Arial", Font.BOLD, 15)); 
        yourScore.setForeground(Color.MAGENTA); 

        panel.add(yourScore, gbc);

        // Create and add the title label
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size and style
        gameOverLabel.setForeground(Color.RED); // Set the font color

        gbc.gridy = 1;
        panel.add(gameOverLabel, gbc);

        // Create and customize the try again button
        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.setBackground(Color.BLUE); // Set background color
        tryAgainButton.setForeground(Color.WHITE); // Set text color
        tryAgainButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        tryAgainButton.setMargin(new Insets(10, 20, 10, 20)); // Add padding
        tryAgainButton.setBorderPainted(false); // Remove border
        tryAgainButton.setFocusPainted(false); // Remove focus border
        tryAgainButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add margin

        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Game");
                gamePanel.startGame(); // Reset and start the game
                gamePanel.requestFocusInWindow(); // Focus on the game panel for keyboard/mouse events
            }
        });

        gbc.gridy = 2; // Move to the next row
        panel.add(tryAgainButton, gbc);

        panel.setBackground(Color.BLACK); // Set background color for the game over panel

        return panel;
    }
    
    public void showGameOverPanel() {
        yourScore.setText("Score" + gamePanel.getScore());
        cardLayout.show(mainPanel, "GameOver");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new main();
            }
        });
    }
}

