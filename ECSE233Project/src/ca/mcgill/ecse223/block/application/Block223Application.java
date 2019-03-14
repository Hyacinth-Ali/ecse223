package ca.mcgill.ecse223.block.application;

import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.UserRole;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;
import ca.mcgill.ecse223.block.view.Block223LogInPage;

public class Block223Application {
	
private static Block223 block223 = null;
private static UserRole currentUser = null;
private static Game currentGame = null;


	
	public static void main(String[] args) {
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Block223LogInPage().setVisible(true);
            }
        });
	}

	public static Block223 getBlock223() {
		if (block223 == null) {
			// load model
			block223 = Block223Persistence.load();
		} else {
			block223.reinitialize();
		}
 		return block223;
	}

	public static UserRole getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(UserRole currentUser) {
		Block223Application.currentUser = currentUser;
	}

	public static Game getCurrentGame() {
		return currentGame;
	}

	public static void setCurrentGame(Game currentGame) {
		Block223Application.currentGame = currentGame;
	}
	

}
