package org.puzzles.rps.game.player.computer;

import org.puzzles.rps.game.player.Player;
import org.puzzles.rps.game.rules.Move;

public class Computer implements Player {

	private final Move move;

	public Computer(MoveGenerator moveGenerator) {
		this.move = moveGenerator.produceMove();
	}

	public Move shoot() {
		return move;
	}

}
