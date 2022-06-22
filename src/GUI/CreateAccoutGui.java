package GUI;

import Controllers.AccountController;
import PeselValidator.PeselValidator;
import PeselValidator.PeselModel;

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
                if (peselValidator.validatePesel(textPesel.getText())) {
                    var accountController = new AccountController();
                    var peselModel = accountController.getPeselData(textPesel.getText());
                    if (peselModel.isAvaiable() && !peselModel.isAccountExist() && peselModel.isAdult()) {
                        new ApprovedCreateAccountGui(textPesel.getText());
                        dispose();
                    } else {
                        new InformationGui(peselModel);
                        dispose();

                    }

                    wrongPeselLabel.setText("");
                } else {
                    wrongPeselLabel.setText("Błędny PESEL");
                }
            }
        });
    }
}
