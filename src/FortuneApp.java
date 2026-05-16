import java.awt.*;
import javax.swing.*;

/* 
Description: This is a Fortune Teller application and this code
designs the layout of the popup window.

@author: Yushi Kawashima
@author: Han Yardimic
@since: 5/10/26
*/

public class FortuneApp {


    

    private JFrame frame;
    private JTextArea outputArea;

    // Fortune manager
    private FortuneManager manager;

    public FortuneApp() {

        
        // Manager

        manager = new FortuneManager();

        
        // Popup window's design (Scale, Title, and Exit option)

        frame = new JFrame("Fortune Teller");

        frame.setSize(900, 700);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout(10, 10));

        
        // 

        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        JLabel title = new JLabel("Welcome to Fortune Teller",JLabel.CENTER);

        title.setFont(new Font("Arial", Font.BOLD, 28));

        title.setForeground(Color.BLACK);

        JLabel instructions = new JLabel(
                "Use the buttons below to get a fortune, add, or remove fortunes.",JLabel.CENTER);

        instructions.setFont(new Font("Arial", Font.PLAIN, 16));

        topPanel.add(title);
        topPanel.add(instructions);

        frame.add(topPanel, BorderLayout.NORTH);

        
        // Central Text Area

        outputArea = new JTextArea();
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane scrollPane =
                new JScrollPane(outputArea);

        frame.add(scrollPane, BorderLayout.CENTER);

        // 4 button to select option. ( Random, Show all Fortune, Add, or Remove Fortune)

        JButton randomBtn =
                new JButton("Get Random Fortune");

        JButton showBtn =
                new JButton("Show All Fortunes");

        JButton addBtn =
                new JButton("Add Fortune");

        JButton removeBtn =
                new JButton("Remove Fortune");

        // Text Field

        JTextField addField = new JTextField();
        JTextField removeField = new JTextField();

        // Layout of all buttons

        JPanel topButtons =
                new JPanel(new GridLayout(1, 2, 10, 0));

        topButtons.add(randomBtn);
        topButtons.add(showBtn);

        // Add Fortune Option

        JPanel addPanel =
                new JPanel(new BorderLayout(10, 0));

        addPanel.add(
                new JLabel("New Fortune:"),
                BorderLayout.WEST);

        addPanel.add(addField, BorderLayout.CENTER);
        addPanel.add(addBtn, BorderLayout.EAST);

        // Remove Fortune Option

        JPanel removePanel =
                new JPanel(new BorderLayout(10, 0));

        removePanel.add(
                new JLabel("Remove Index:"),
                BorderLayout.WEST);

        removePanel.add(removeField,
                BorderLayout.CENTER);

        removePanel.add(removeBtn,
                BorderLayout.EAST);

        // In the Bottom

        JPanel bottomPanel = new JPanel();

        bottomPanel.setLayout(
                new GridLayout(3, 1, 0, 10));

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 10, 10, 10));

        bottomPanel.add(topButtons);
        bottomPanel.add(addPanel);
        bottomPanel.add(removePanel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // All Option's connection between App and Manager code

        // Random Fortune Option
        randomBtn.addActionListener(e -> {

            outputArea.setText(
                    manager.getRandomFortune());
        });

        // Show All Fortunes
        showBtn.addActionListener(e -> {

            outputArea.setText(
                    manager.getAllFortunes());
        });

        // Add Fortune Option
        addBtn.addActionListener(e -> {

            try {

                String text =
                        addField.getText().trim();

                manager.addFortune(text);

                outputArea.setText(
                        "Fortune has been added");

                addField.setText("");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Remove Fortune Option
        removeBtn.addActionListener(e -> {

            try {

                int index =
                        Integer.parseInt(
                                removeField.getText().trim());

                manager.removeFortune(index);
                outputArea.setText("Fortune has been removed");
                removeField.setText("");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Showing the window

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new FortuneApp();
        });
    }
}
