package org.puzzles.rps.game.player.human;

import org.puzzles.rps.game.player.Player;
import org.puzzles.rps.game.rules.Move;

public class Human implements Player {

	private final Move move;

	public Human(Move move) {
		this.move = move;
	}

	public Move shoot() {
		return move;
	}

}
