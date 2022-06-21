package GUI;

import PeselValidator.PeselValidator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccoutGui extends JFrame {

    private JPanel menuPanel;
    private JLabel labelApp;
    private JTextField textPesel;
    private JButton buttonCheckPesel;
    private JButton buttonBackToMain;
    private JLabel wrongPeselLabel;

    public CreateAccoutGui() {
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
        buttonCheckPesel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var peselValidator = new PeselValidator();
                System.out.println(textPesel.getText());
                if (peselValidator.validatePesel(textPesel.getText())) {
                    new ApprovedCreateAccountGui(textPesel.getText());
                    dispose();
                    wrongPeselLabel.setText("");
                } else {
                    wrongPeselLabel.setText("Błędny PESEL");
                }
            }
        });
    }
}
