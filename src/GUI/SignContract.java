package GUI;

import ClientModels.Client;
import Controllers.AccountController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignContract extends JFrame {
    private JPanel menuPanel;
    private JTextField bankTextField;
    private JButton wyślijProśbęONowąButton;
    private JLabel nameLabel;
    private JButton wyświetlPodpisaneUmowyZButton;

    public SignContract(Client client) {
        nameLabel.setText(client.getFirstName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.menuPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(600, 400);


        wyślijProśbęONowąButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               var bank = new AccountController().getBank(bankTextField.getText());
               new SignContract2(bank, client);
               dispose();
            }
        });
        wyświetlPodpisaneUmowyZButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AccountController().getContractList(String.valueOf(client.getClientNumber()));
                System.out.println();
            }
        });
    }
}
