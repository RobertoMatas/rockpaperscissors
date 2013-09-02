package org.puzzles.rps.gui.components.fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.Rules;
import org.puzzles.rps.game.rules.RulesFactory;

public class RulesFactoryFake implements RulesFactory {

	private Map<String, Move> moves;

	public RulesFactoryFake() {
		this.moves = new HashMap<String, Move>(3);
		fillFakeMoves();
	}

	private void fillFakeMoves() {
		final String[] moves = { "rock", "paper", "scissors" };
		for (int i = 0; i < moves.length; i++) {
			this.moves.put(moves[i], new MoveFake(moves[i]));
		}
	}

	public Rules createRulesOfGame() {

		return new Rules() {

			public List<Move> movesAllowed() {
				return new ArrayList<Move>(moves.values());
			}

			public Move getByName(String name) {
				return moves.get(name);
			}
		};
	}

}
