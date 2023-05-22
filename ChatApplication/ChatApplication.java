import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatApplication {
    private JFrame frame;
    private JPanel panel;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    public ChatApplication() {
        frame = new JFrame("Chat Application");
        panel = new JPanel();
        chatArea = new JTextArea(15, 30);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        messageField = new JTextField(20);
        sendButton = new JButton("Send");

        // Set up GUI
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(messageField, BorderLayout.PAGE_END);
        panel.add(sendButton, BorderLayout.LINE_END);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        // Add ActionListener to send button
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Pressing Enter in the message field will also send the message
        messageField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatArea.append("You: " + message + "\n");
            messageField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatApplication();
            }
        });
    }
}
