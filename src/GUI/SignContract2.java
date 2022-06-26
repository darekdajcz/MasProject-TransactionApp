package GUI;

import BankModels.Bank;
import BankModels.Contract;
import ClientModels.Client;
import Controllers.AccountController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignContract2 extends JFrame {
    private JPanel panel1;
    private JLabel aprooveLabel;
    private JButton nieButton;
    private JButton takButton;
    private JTextField contractNumber;

    public SignContract2(Bank bank, Client client) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.panel1);
        this.pack();
        this.setVisible(true);
        this.setSize(600, 400);

        nieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainGui("AppBankMobile");
            }
        });
        takButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gratulacje");
                Contract contract = new Contract(true, true, contractNumber.getText());
                contract.addBank(bank);
                contract.addClient(client);
                new AccountController().signContract(contract);
                System.out.println(contract);
                new MainGui("AppBank");
                dispose();
            }
        });
    }
}
