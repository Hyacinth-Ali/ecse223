package ca.mcgill.ecse223.block.application;

import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.UserRole;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;
import ca.mcgill.ecse223.block.view.Block223AdminPage;
import ca.mcgill.ecse223.block.view.Block223LogInPage;

public class Block223Application {
	
private static Block223 block223 = null;
private static UserRole currentUserRole = null;
private static Game currentGame = null;

private static Block223AdminPage adminPage;
private static Block223LogInPage loginPage;
private static final String ADMIN_PAGE = "Admin page";
private static final String PLAYER_PAGE = "Player page";


	
	public static void main(String[] args) {
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	adminPage = new Block223AdminPage();
            	loginPage = new Block223LogInPage();
            	loginPage.setVisible(true);
            }
        });
	}
	
	public static void openAdminPage() {
		//To be modified when I have multiple pages
		adminPage.setVisible(true);
		loginPage.setVisible(false);
	}
	
	public static void openLogInPage(String pageName) {

		if (pageName.equals(ADMIN_PAGE)) {
			loginPage.setVisible(true);
			adminPage.setVisible(false);
		} else if(pageName.equals(PLAYER_PAGE)) {
			loginPage.setVisible(true);
			//TODO:
			//playerPage.setVisible(false);
		}
		
		
	}

	public static Block223 getBlock223() {
		if (block223 == null) {
			// load model
			block223 = Block223Persistence.load();
		}
 		return block223;
	}

	public static UserRole getCurrentUserRole() {
		return currentUserRole;
	}

	public static void setCurrentUserRole(UserRole currentUser) {
		Block223Application.currentUserRole = currentUser;
	}

	public static Game getCurrentGame() {
		return currentGame;
	}

	public static void setCurrentGame(Game currentGame) {
		Block223Application.currentGame = currentGame;
	}
	
	public static void resetBlock223() {
		block223 = Block223Persistence.load();
	}
	

}
