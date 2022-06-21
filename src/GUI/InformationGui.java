package GUI;

import javax.swing.*;

public class InformationGui extends JFrame {
    private JPanel menuPanel;
    private JLabel peselLabel;
    private JButton buttonBackToMain;

    public InformationGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.menuPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(600, 400);
    }
}
