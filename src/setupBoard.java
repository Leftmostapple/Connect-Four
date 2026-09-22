import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Timer;

public class setupBoard {
    JFrame mainFrame = new JFrame();
    JPanel statusPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JLabel statusLabel = new JLabel("");
    GridLayout layout = new GridLayout(6, 7);
    JButton[][] buttons = new JButton[6][7];

    public JButton[][] createBoard(){

        mainFrame.setSize(800, 700);
        mainFrame.setTitle("Connect Four");
        mainFrame.add(statusPanel, BorderLayout.NORTH);
        mainFrame.add(boardPanel, BorderLayout.CENTER);

        statusPanel.setBackground(Color.GRAY);
        statusPanel.add(statusLabel);
        boardPanel.setLayout(layout);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons[i].length; j++){
                JButton button = new JButton();
                boardPanel.add(button);
                button.setBackground(Color.WHITE);

                buttons[i][j] = button;
            }
        }

        mainFrame.setVisible(true);
        return buttons;
    }

    public void changeStatusLabel(String newStatus, Color color){
        statusLabel.setForeground(color);
        statusLabel.setText(newStatus);
    }

    public void endGame(Color color){
        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons[i].length; j++){
                buttons[i][j].setBackground(color);
            }
        }
        Timer timer = new Timer(5000, e -> {
            mainFrame.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }
}
