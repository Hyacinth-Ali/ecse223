package ca.mcgill.ecse223.block.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Block223LogInPage extends JFrame {
	
	//Error messages
	private String loginError;
	private String registerError;
	private JTextField textField_userName_Login;
	private JTextField textField_userName_register;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel lblErrorMessage;
	
	JLabel lblerrorMessage_register;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Block223LogInPage frame = new Block223LogInPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Block223LogInPage() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		setTitle("BLOCK 233 GAME");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 484);
		
		JLabel welcomeLabel = new JLabel("Welcome to Block 233 Game");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.BLUE);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.MAGENTA);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField_userName_Login = new JTextField();
		textField_userName_Login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_userName_Login.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setText("What is happening");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginActionPerformed(arg0);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblUserName_register = new JLabel("User Name");
		
		textField_userName_register = new JTextField();
		textField_userName_register.setColumns(10);
		
		JLabel lblPlayerPassword_register = new JLabel("Player Password");
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnAdmin.isSelected()) {
					passwordField_2.setEnabled(true);
				} else {
					passwordField_2.setEnabled(false);
				}
			}
		});
		
		
		JLabel lblAdminPassword = new JLabel("Admin Password");
		lblAdminPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerActionPerformed(arg0);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.MAGENTA);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBackground(Color.MAGENTA);
		
		passwordField = new JPasswordField();
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		
		passwordField_1 = new JPasswordField();
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setEnabled(false);
		
		JCheckBox chckbxShowPassword_1 = new JCheckBox("Show Password");
		passwordField_1.setEchoChar('*');
		chckbxShowPassword_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxShowPassword_1.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				} else {
					passwordField_1.setEchoChar('*');
				}
			}
		});
		
		JCheckBox chckbxShowPassword_2 = new JCheckBox("Show Password");
		passwordField_2.setEchoChar('*');
		chckbxShowPassword_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxShowPassword_2.isSelected()) {
					passwordField_2.setEchoChar((char)0);
				} else {
					passwordField_2.setEchoChar('*');
				}
			}
		});
		
		lblerrorMessage_register = new JLabel("");
		lblerrorMessage_register.setText(registerError);
		lblerrorMessage_register.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(lblUserName)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(textField_userName_Login, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(19)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
										.addComponent(chckbxShowPassword)
										.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblErrorMessage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPassword))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPlayerPassword_register)
								.addComponent(lblUserName_register)
								.addComponent(rdbtnAdmin)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblAdminPassword)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordField_1)
									.addComponent(textField_userName_register, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
									.addComponent(chckbxShowPassword_1))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(chckbxShowPassword_2, Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(passwordField_2, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
									.addComponent(btnRegister, Alignment.LEADING))))
						.addComponent(lblerrorMessage_register, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
					.addGap(129))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblerrorMessage_register)
								.addComponent(lblErrorMessage))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUserName)
								.addComponent(textField_userName_register, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUserName_register)
								.addComponent(textField_userName_Login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlayerPassword_register)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxShowPassword_1)
									.addGap(8)
									.addComponent(rdbtnAdmin)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAdminPassword))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxShowPassword_2))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxShowPassword)
									.addGap(46)
									.addComponent(btnLogin)))
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addComponent(btnRegister)
							.addGap(23))
						.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
						.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	
	private void loginActionPerformed(java.awt.event.ActionEvent evt) {
		//clear error
		loginError = null;
		String userName = textField_userName_Login.getText();
		char[] pass = passwordField.getPassword();
		String password = new String(pass);
		
		if (userName != null && userName.length() > 0) {
			if (password != null && password.length() > 0) {
				try {
					Block223Controller.login(userName, password);
				} catch (InvalidInputException e) {
					loginError = e.getMessage();
				}
			} else {
				loginError = "You can't log in with empt password";
			}
		} else {
			loginError = "You can't log in with empt user name";
		}
		
		//update visuals
		refreshData();
	}
	
	private void registerActionPerformed(java.awt.event.ActionEvent evt) {
		//clear error
		registerError = null;
		String userName = textField_userName_register.getText();
		char [] playerPassword = passwordField_1.getPassword();
		String password1 = new String(playerPassword);
		char [] adminPassword = passwordField_2.getPassword();
		String password2 = new String(adminPassword);
		
		if (userName != null && userName.length() > 0) {
			if (password1 != null && password1.length() > 0) {
				try {
					Block223Controller.register(userName, password1, password2);
				} catch (InvalidInputException e) {
					registerError = e.getMessage();
					}
			} else {
				registerError = "You can't register with empty player password.";
			}
		} else {
			registerError = "You can't register with empty user name.";
		}
		//Update visual
		refreshData();
		}
	
	private void refreshLogin() {
		lblErrorMessage.setText(loginError);
		
		// log in information
		textField_userName_Login.setText("");
		passwordField.setText("");
	}
	
	private void refreshData() {
		lblerrorMessage_register.setText(registerError);
		
		//register page
		textField_userName_register.setText("");
		passwordField_1.setText("");
		passwordField_2.setText("");
		
	}
}
