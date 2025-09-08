import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        loginPage();
    }

    static void loginPage() {
        JFrame frame = new JFrame("Bank Login");
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JLabel accLabel = new JLabel("Account No:");
        JTextField accField = new JTextField();
        JLabel pinLabel = new JLabel("PIN:");
        JPasswordField pinField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> {
            try {
                int accno = Integer.parseInt(accField.getText().trim());
                int pin = Integer.parseInt(new String(pinField.getPassword()));
                User usr = BankOps.login(accno, pin);
                if (usr != null) {
                    frame.dispose();
                    dashPage(usr);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid login.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
            }
        });

        frame.add(accLabel);
        frame.add(accField);
        frame.add(pinLabel);
        frame.add(pinField);
        frame.add(new JLabel());
        frame.add(loginBtn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void dashPage(User usr) {
        JFrame frame = new JFrame("Dashboard");
        frame.setSize(400, 250);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        frame.setLocationRelativeTo(null);

        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton checkBalanceBtn = new JButton("Check Balance");
        JButton logoutBtn = new JButton("Logout");

        Dimension btnSize = new Dimension(150, 30);
        depositBtn.setPreferredSize(btnSize);
        withdrawBtn.setPreferredSize(btnSize);
        checkBalanceBtn.setPreferredSize(btnSize);
        logoutBtn.setPreferredSize(btnSize);

        depositBtn.addActionListener(e -> {
            String amtStr = JOptionPane.showInputDialog(frame, "Enter deposit amount:");
            if (amtStr != null) {
                try {
                    double amt = Double.parseDouble(amtStr);
                    BankOps.deposit(usr.getAccno(), amt);
                    usr.setBalance(usr.getBalance() + amt);
                    JOptionPane.showMessageDialog(frame, "Amount deposited successfully.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
                }
            }
        });

        withdrawBtn.addActionListener(e -> {
            String amtStr = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:");
            if (amtStr != null) {
                try {
                    double amt = Double.parseDouble(amtStr);
                    if (amt > usr.getBalance()) {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance.");
                    } else {
                        BankOps.withdraw(usr.getAccno(), amt);
                        usr.setBalance(usr.getBalance() - amt);
                        JOptionPane.showMessageDialog(frame, "Amount withdrawn successfully.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.");
                }
            }
        });

        checkBalanceBtn.addActionListener(e ->
            JOptionPane.showMessageDialog(frame, "Current Balance: ₹" + usr.getBalance())
        );

        logoutBtn.addActionListener(e -> {
            frame.dispose();
            loginPage();
        });

        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(checkBalanceBtn);
        frame.add(logoutBtn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
