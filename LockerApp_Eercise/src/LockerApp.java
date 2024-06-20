import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApp extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPasswordField passwordField;
    private JButton enterButton;
    private JLabel statusLabel;
    private String savedPassword = null;

    public LockerApp() {
        // Initialize the frame
        setTitle("Locker Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        passwordField = new JPasswordField(20);
        enterButton = new JButton("Enter");
        statusLabel = new JLabel("Please set your password.");

        // Set layout
        setLayout(new FlowLayout());
        add(new JLabel("Password:"));
        add(passwordField);
        add(enterButton);
        add(statusLabel);

        // Add action listener to the button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePassword();
            }
        });
    }

    private void handlePassword() {
        char[] input = passwordField.getPassword();
        String inputPassword = new String(input);

        if (savedPassword == null) {
            // First time setting the password
            savedPassword = inputPassword;
            statusLabel.setText("Password Set");
        } else {
            // Verifying the entered password
            if (savedPassword.equals(inputPassword)) {
                statusLabel.setText("Correct Password");
            } else {
                statusLabel.setText("Incorrect Password");
            }
        }
    }
}