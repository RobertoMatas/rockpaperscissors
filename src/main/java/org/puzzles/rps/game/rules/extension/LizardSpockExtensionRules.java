package org.puzzles.rps.game.rules.extension;

import java.util.Arrays;
import java.util.List;

import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.Rules;

public class LizardSpockExtensionRules implements Rules {

	public List<Move> movesAllowed() {
		return Arrays.<Move>asList(LizardSpockExtensionMoves.values());
	}

	public Move getByName(String name) {
		return LizardSpockExtensionMoves.valueOf(name);
	}

}