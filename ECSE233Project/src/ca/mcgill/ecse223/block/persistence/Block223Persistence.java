package ca.mcgill.ecse223.block.persistence;

import ca.mcgill.ecse223.block.model.*;

public class Block223Persistence {
	
	private static String filename = "dat.ass";
	
	public static void save(Block223 block223) {
		PersistenceObjectStream.serialize(block223);
	}
	
	public static Block223 load() {
		PersistenceObjectStream.setFilename(filename);
		Block223 block223 = (Block223) PersistenceObjectStream.deserialize();
		// model cannot be loaded - create empty BTMS
		if (block223 == null) {
			block223 = new Block223();
		}
		else {
			block223.reinitialize();
		}
		return block223;
	}
	
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}

}
