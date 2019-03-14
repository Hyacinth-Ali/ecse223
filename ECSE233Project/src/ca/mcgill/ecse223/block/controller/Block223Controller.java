package ca.mcgill.ecse223.block.controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse.btms.application.BtmsApplication;
import ca.mcgill.ecse.btms.model.Driver;
import ca.mcgill.ecse223.block.application.Block223Application;
import ca.mcgill.ecse223.block.model.Admin;
import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.Player;
import ca.mcgill.ecse223.block.model.User;
import ca.mcgill.ecse223.block.model.UserRole;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;
import ca.mcgill.ecse223.block.view.Block223AdminPage;
import ca.mcgill.ecse223.block.view.Block223LogInPage;

public class Block223Controller {
	
	private static String error = "";
	private static final String ADMIN_PAGE = "Admin page";
	private static final String PLAYER_PAGE = "Player page";

	// ****************************
	// Modifier methods
	// ****************************
	public static void createGame(String name) throws InvalidInputException {
		Block223 block223 = Block223Application.getBlock223();
		Admin admin = (Admin) Block223Application.getCurrentUserRole();
		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to create a game.");
		}
		if(checkDuplicateName(name)) {
			throw new InvalidInputException("The name of a game must be unique.");
		}
		
		try {
			Game game = new Game(name, 1, admin, 1, 1, 1, 10, 10, block223);
			Block223Persistence.save(block223);
		} catch(RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
	
	private static Game findGame(String name) {
		Game foundGame = null;
		for (Game game : Block223Application.getBlock223().getGames()) {
			if (game.getName() == name) {
				foundGame = game;
				break;
			}
		}
		return foundGame;
	}
	
	public static boolean checkDuplicateName(String name){
		boolean duplicate = false;
		for (Game game : Block223Application.getBlock223().getGames()) {
			if (game.getName().equals(name)) {
				duplicate = true;
				break;
			}
		}
		return duplicate;
		
	}

	public static void setGameDetails(int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
	}

	public static void deleteGame(String name) throws InvalidInputException {
	}

	public static void selectGame(String name) throws InvalidInputException {
	}

	public static void updateGame(String name, int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
	}

	public static void addBlock(int red, int green, int blue, int points) throws InvalidInputException {
	}

	public static void deleteBlock(int id) throws InvalidInputException {
	}

	public static void updateBlock(int id, int red, int green, int blue, int points) throws InvalidInputException {
	}

	public static void positionBlock(int id, int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {
	}

	public static void moveBlock(int level, int oldGridHorizontalPosition, int oldGridVerticalPosition,
			int newGridHorizontalPosition, int newGridVerticalPosition) throws InvalidInputException {
	}

	public static void removeBlock(int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {
	}

	public static void saveGame() throws InvalidInputException {
	}

	public static void register(String username, String playerPassword, String adminPassword)
			throws InvalidInputException {
		//////**************
		try {
			Block223 block = Block223Application.getBlock223();
			block.delete();
			Block223Persistence.save(block);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		///***********************
		if (Block223Application.getCurrentUserRole() == null) {
			if (!playerPassword.equals(adminPassword)) {
				Block223 block223 = Block223Application.getBlock223();
				Player player = null;
				User user = null;
				
				try {
					player = new Player(playerPassword, block223);
					user = new User(username, block223, player);
				} catch (RuntimeException e) {
					throw new InvalidInputException(e.getMessage());
				}
				
				if (adminPassword != null && adminPassword != "") {
					Admin admin = new Admin(adminPassword, block223);
					user.addRole(admin);
				}
				
				try {
					Block223Persistence.save(block223);
				} catch (RuntimeException e) {
					throw new InvalidInputException(e.getMessage());
				}
			}
			else {
				error = "The passwords have to be different.";
			}
		} else {
			error = "Cannot register a new user while a user is logged in."; 
		}
		
		/*try {
			Block223 block = Block223Application.getBlock223();
			block.delete();
			Block223Persistence.save(block);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}*/
		
		if (error.length() > 0) {
			throw new InvalidInputException(error.trim());
		}
	}

	public static void login(String username, String password) throws InvalidInputException {
		//clear error
		error = "";
		boolean loggedIn = false;
		if (Block223Application.getCurrentUserRole() == null) {
			User user = User.getWithUsername(username);
			if (user == null) {
				throw new InvalidInputException("The username and password do not match.");
			}
			UserRole role = null;
			for ( UserRole userRole: user.getRoles()) {
				String rolePassword = userRole.getPassword();
				if (rolePassword.equals(password)) {
					Block223Application.setCurrentUserRole(userRole);
					Block223Application.resetBlock223();
					loggedIn = true;
					break;
				} 
			}
			if (!loggedIn) {
				error = "The username and password do not match.";
			}
			
		} else {
			error = "Cannot login a user while a user is already logged in.";
		}
		if (error.length() > 0) {
			throw new InvalidInputException(error.trim());
		}
		if (loggedIn) {
			Block223Application.openAdminPage();
		}
	}

	public static void logout() {
	}

	// ****************************
	// Query methods
	// ****************************
	public static List<TOGame> getDesignableGames() throws InvalidInputException {
		
		Block223 block223 = Block223Application.getBlock223();
		UserRole admin = Block223Application.getCurrentUserRole();
		if (!(admin instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
		List<TOGame> result = new ArrayList<TOGame>();
		for (Game game : block223.getGames()) {
			Admin gameAdmin = game.getAdmin();
			if(gameAdmin.equals(admin)) {
				TOGame toGame = new TOGame(game.getName(), game.getLevels().size(), game.getNrBlocksPerLevel(),
						game.getBall().getMinBallSpeedX(), game.getBall().getMinBallSpeedY(), 
						game.getBall().getBallSpeedIncreaseFactor(), game.getPaddle().getMaxPaddleLength(),
						game.getPaddle().getMinPaddleLength());
				result.add(toGame);
			}
		}
		return result;
	}

	public static TOGame getCurrentDesignableGame() throws InvalidInputException {
	}

	public static List<TOBlock> getBlocksOfCurrentDesignableGame() throws InvalidInputException {
	}

	public static TOBlock getBlockOfCurrentDesignableGame(int id) throws InvalidInputException {
	}

	public static List<TOGridCell> getBlocksAtLevelOfCurrentDesignableGame(int level) throws InvalidInputException {
	}

	public static TOUserMode getUserMode() {
	}

}