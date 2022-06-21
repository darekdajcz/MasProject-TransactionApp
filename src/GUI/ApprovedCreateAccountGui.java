package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApprovedCreateAccountGui extends JFrame {
    private JPanel menuPanel;
    private JButton createAccountButton;
    private JButton buttonBackToMain;
    private JLabel aproovedLabel;
    private JLabel peselLabel;

    public ApprovedCreateAccountGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.menuPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(600, 400);
        buttonBackToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainGui("AppBankMobile");
                dispose();
            }
        });
    }
}
