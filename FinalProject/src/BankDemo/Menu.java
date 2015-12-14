package BankDemo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	//initializes
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User currentUser;
	
	public Menu(User theUser) {
		
		setForeground(Color.BLUE);
		currentUser = theUser;

		setIconImage(Toolkit.getDefaultToolkit().getImage("\\\\mark14\\mredman$\\My Documents\\My Pictures\\bank-512.png"));
		setBackground(Color.BLUE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 436);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new MatteBorder(10, 9, 7, 9, (Color) Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Transfer = new JButton("Transfer");
		Transfer.setFont(new Font("Tahoma", Font.BOLD, 16));
		Transfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATM thing = new ATM();
			ATM.transferFunds(currentUser);
			}
		});
		Transfer.setBackground(new Color(0, 0, 0));
		Transfer.setForeground(Color.WHITE);
		Transfer.setBounds(32, 273, 159, 36);
		contentPane.add(Transfer);
		
		JButton Withdraw = new JButton("Withdraw");
		Withdraw.setFont(new Font("Tahoma", Font.BOLD, 16));
		Withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATM thing = new ATM();
				ATM.withdrawFunds(currentUser);
			}});
		Withdraw.setForeground(Color.WHITE);
		Withdraw.setBackground(new Color(0, 0, 0));
		Withdraw.setBounds(32, 226, 159, 36);
		contentPane.add(Withdraw);
		
		JButton History = new JButton("History");
		History.setFont(new Font("Tahoma", Font.BOLD, 16));
		History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ATM thing = new ATM();
		ATM.showTransHistory(currentUser);
			}});
		History.setForeground(Color.WHITE);
		History.setBackground(new Color(0, 0, 0));
		History.setBounds(34, 323, 157, 36);
		contentPane.add(History);
		
		JButton Deposit = new JButton("Deposit");
		Deposit.setFont(new Font("SansSerif", Font.BOLD, 16));
		Deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATM thing = new ATM();
				ATM.depositFunds(currentUser);
			}
		});
		Deposit.setForeground(Color.WHITE);
		Deposit.setBackground(new Color(0, 0, 0));
		Deposit.setBounds(32, 176, 159, 39);
		contentPane.add(Deposit);
		
		JButton Exit = new JButton("Exit");
		Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		Exit.addActionListener(new ActionListener(
				) {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Thank you for Banking with us!", null, 0);
				System.exit(0);
			}
		});
		Exit.setForeground(Color.WHITE);
		Exit.setBackground(new Color(0, 0, 0));
		Exit.setBounds(509, 323, 159, 36);
		contentPane.add(Exit);
		
		JLabel lblWelcomeToThe = DefaultComponentFactory.getInstance().createLabel("Thanks for choosing");
		lblWelcomeToThe.setBackground(new Color(0, 0, 0));
		lblWelcomeToThe.setForeground(Color.WHITE);
		lblWelcomeToThe.setFont(new Font("Verdana", Font.BOLD, 21));
		lblWelcomeToThe.setBounds(58, -1, 443, 108);
		contentPane.add(lblWelcomeToThe);
		
		JLabel lblNewLabel = new JLabel("Bank of Mackenzie");
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(322, 3, 347, 102);
		contentPane.add(lblNewLabel);
		
		JLabel lblHowMayWe = new JLabel("How may we help you?");
		lblHowMayWe.setFont(new Font("Verdana", Font.BOLD, 21));
		lblHowMayWe.setForeground(Color.WHITE);
		lblHowMayWe.setBounds(185, 57, 303, 108);
		contentPane.add(lblHowMayWe);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("\\\\mark14\\mredman$\\My Documents\\My Pictures\\blue.jpg"));
		lblNewLabel_1.setBounds(-15, 0,710,398);
		contentPane.add(lblNewLabel_1);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
