package org.puzzles.rps.game.rules;

import java.util.ArrayList;
import java.util.List;

public class RockPaperScissorsRules implements Rules {

	public List<Move> movesAllowed() {
		RockPaperScissorsMoves[] moves = RockPaperScissorsMoves.values();
		return createListOfMoves(moves);
	}

	private List<Move> createListOfMoves(RockPaperScissorsMoves[] moves) {
		List<Move> movesAllowed = new ArrayList<Move>(moves.length);
		for (int i = 0; i < moves.length; i++) {
			movesAllowed.add(moves[i]);
		}
		return movesAllowed;
	}

	public Move getByName(String name) {
		return RockPaperScissorsMoves.valueOf(name);
	}

}
