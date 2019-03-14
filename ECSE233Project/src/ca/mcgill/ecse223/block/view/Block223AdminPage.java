package ca.mcgill.ecse223.block.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.block.application.Block223Application;
import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOGame;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Block223AdminPage extends JFrame {
	
	//error message
	private String error = "";
	private JLabel lblErrorMessage;
	
	//Games
	private HashMap<Integer, String> games;
	private JComboBox<String> comboBoxGames;

	private JPanel contentPane;
	private JTextField textFieldGameName;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public Block223AdminPage() {
		setTitle("ADMIN PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblErrorMessage = new JLabel("Errror message");
		lblErrorMessage.setForeground(Color.RED);
		
		JLabel lblGame = new JLabel("Game Name");
		lblGame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textFieldGameName = new JTextField();
		textFieldGameName.setColumns(10);
		
		JButton btnCreateGame = new JButton("Create");
		btnCreateGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createGameActionPerformed(e);
			}
		});
		
		JLabel lblGames = new JLabel("Games");
		lblGames.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBoxGames = new JComboBox<String>();
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Block223Application.openLogInPage("Admin page");
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblErrorMessage, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGame)
										.addComponent(lblGames))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBoxGames, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textFieldGameName, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(btnCreateGame)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnBack)
							.addGap(94))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorMessage)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGame)
						.addComponent(textFieldGameName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreateGame))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGames)
						.addComponent(comboBoxGames, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(421, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createGameActionPerformed(java.awt.event.ActionEvent evt) {
		String gameName = textFieldGameName.getText();
		if (gameName != null && gameName.length() > 0) {
			try {
				Block223Controller.createGame(gameName);
			} catch (InvalidInputException e) {
				error = e.getMessage();
			}
		}else {
			error = "The name of a game cannot be empty";
		}
		refreshData();
		
	}
	
	private void refreshData() {
		lblErrorMessage.setText(error);
		if (error != null ||error.length() == 0) {
			
			// Game
			textFieldGameName.setText("");
			
			//Game list
			Integer index = 0;
			games = new HashMap<Integer, String>();
			List<TOGame> gameList = new ArrayList<TOGame>();
			try {
				gameList = Block223Controller.getDesignableGames();
				comboBoxGames.removeAllItems();
				for (TOGame game : gameList) {
					games.put(index, game.getName());
					comboBoxGames.addItem(game.getName());
					index++;
				}
				index = 0;
				comboBoxGames.setSelectedIndex(-1);
			} catch (InvalidInputException e){
				lblErrorMessage.setText(e.getMessage());
			}
			
		}
	}
}
