package org.puzzles.rps.game.rules;

import java.util.List;

public interface Rules {

	List<Move> movesAllowed();
	
	Move getByName(String name);
}
