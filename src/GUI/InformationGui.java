package GUI;

import PeselValidator.PeselModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationGui extends JFrame {
    private JPanel menuPanel;
    private JLabel peselLabel;
    private JButton buttonBackToMain;
    private JList<String> listOfMessages;
    private DefaultListModel<String> messagesList = new DefaultListModel<>();

    public InformationGui(PeselModel peselModel) {
        this.setMessagesList(peselModel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.menuPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(600, 400);
        peselLabel.setText(peselModel.getPeselNumber());
        buttonBackToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainGui("AppBankMobile");
                dispose();
            }
        });
    }

    public void setMessagesList(PeselModel peselModel) {
        if (!peselModel.isAdult()) {
            messagesList.addElement("  * Możliwość założenia powyżej 18 roku życia");
        }
        if (peselModel.isAccountExist()) {
            messagesList.addElement("  * Konto z podanym nr PESEL już istnieje");
        }
        if (!peselModel.isAvaiable()) {
            messagesList.addElement("  * Niestety brak zdolności do założenia konta");
        }
        listOfMessages.setModel(messagesList);
    }
}
