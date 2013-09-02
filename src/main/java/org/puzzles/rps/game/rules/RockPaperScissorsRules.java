package org.puzzles.rps.game.rules;

import java.util.Arrays;
import java.util.List;

public class RockPaperScissorsRules implements Rules {

	public List<Move> movesAllowed() {
		return Arrays.<Move>asList(RockPaperScissorsMoves.values());
	}

	public Move getByName(String name) {
		return RockPaperScissorsMoves.valueOf(name);
	}

}