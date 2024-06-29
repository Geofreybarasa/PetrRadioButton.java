import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetSelector extends JFrame {
    private JRadioButton dogButton;
    private JRadioButton catButton;
    private JRadioButton rabbitButton;
    private JRadioButton birdButton;
    private JRadioButton fishButton;
    private JLabel petLabel;
    private JLabel petImageLabel;

    public PetSelector() {
        setTitle("Pet Selector");
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //setResizable(false);
        // ImageIcon image = new ImageIcon("GoddieImage.PNG");
        //setIconImage(image.getImage());

        // Create radio buttons
        dogButton = new JRadioButton("Dog");
        catButton = new JRadioButton("Cat");
        rabbitButton = new JRadioButton("Rabbit");
        birdButton = new JRadioButton("Bird");
        fishButton = new JRadioButton("Fish");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(dogButton);
        group.add(catButton);
        group.add(rabbitButton);
        group.add(birdButton);
        group.add(fishButton);

        // Add action listeners to radio buttons
        dogButton.addActionListener(new PetButtonListener());
        catButton.addActionListener(new PetButtonListener());
        rabbitButton.addActionListener(new PetButtonListener());
        birdButton.addActionListener(new PetButtonListener());
        fishButton.addActionListener(new PetButtonListener());

        // Create a panel to hold the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.add(dogButton);
        radioPanel.add(catButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(birdButton);
        radioPanel.add(fishButton);

        // Create a label to display the selected pet
        petLabel = new JLabel("Select a pet", SwingConstants.CENTER);
        petLabel.setFont(new Font("Serif", Font.BOLD, 24));

        // Create a label to display the pet image
        petImageLabel = new JLabel("", SwingConstants.CENTER);

        // Add components to the frame
        add(radioPanel, BorderLayout.WEST);
        add(petLabel, BorderLayout.NORTH);
        add(petImageLabel, BorderLayout.CENTER);
    }

    private class PetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton selectedButton = (JRadioButton) e.getSource();
            petLabel.setText("Selected pet: " + selectedButton.getText());

            String imagePath = "";
            switch (selectedButton.getText()) {
                case "Dog":
                    imagePath = "DogImage.png";
                    break;
                case "Cat":
                    imagePath = "CatImage.PNG";
                    break;
                case "Rabbit":
                    imagePath = "RabbitImage.PNG";
                    break;
                case "Bird":
                    imagePath = "BirdImage.PNG";
                    break;
                case "Fish":
                    imagePath = "FishImage.PNG";
                    break;
            }

            ImageIcon icon = new ImageIcon(imagePath);
            if (icon.getIconWidth() == -1) {
                petImageLabel.setText("Image not found");
                petImageLabel.setIcon(null);
            } else {
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImg);
                petImageLabel.setIcon(icon);
                petImageLabel.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetSelector frame = new PetSelector();
            frame.setVisible(true);
        });
    }
}
