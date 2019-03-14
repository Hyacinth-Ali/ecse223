package ca.mcgill.ecse223.block.controller;

import java.util.List;

import ca.mcgill.ecse223.block.application.Block223Application;
import ca.mcgill.ecse223.block.model.Admin;
import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.Player;
import ca.mcgill.ecse223.block.model.User;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;

public class Block223Controller {
	
	private static String error;

	// ****************************
	// Modifier methods
	// ****************************
	public static void createGame(String name) throws InvalidInputException {
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
		if (Block223Application.getCurrentUser() == null) {
			if (!playerPassword.equals(adminPassword)) {
				Block223 block223 = Block223Application.getBlock223();
				Player player = null;
				User user = null;
				
				try {
					player = new Player(playerPassword, block223);
				} catch (RuntimeException e) {
					throw new InvalidInputException(e.getMessage());
				}
				
				try {
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
		
		if (error.length() > 0) {
			throw new InvalidInputException(error.trim());
		}
	}

	public static void login(String username, String password) throws InvalidInputException {
	}

	public static void logout() {
	}

	// ****************************
	// Query methods
	// ****************************
	public static List<TOGame> getDesignableGames() throws InvalidInputException {
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