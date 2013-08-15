package org.puzzles.rps.game.player.computer;

import java.util.List;
import java.util.Random;

import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.Rules;

public class RandomMoveGenerator implements MoveGenerator {

	private final Random random;
	
	private final Rules gameRules;
	
	public RandomMoveGenerator(Rules gameRules) {
		this.random = new Random();
		this.gameRules = gameRules;
	}

	public RandomMoveGenerator(Random random, Rules gameRules) {
		super();
		this.random = random;
		this.gameRules = gameRules;
	}

	public Move produceMove() {
		List<Move> moves = gameRules.movesAllowed();
		int size = moves.size();
		return moves.get(random.nextInt(size));
	}

}
