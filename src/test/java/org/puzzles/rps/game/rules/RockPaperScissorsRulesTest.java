package org.puzzles.rps.game.rules;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.puzzles.rps.FastTests;

@Category(FastTests.class)
public class RockPaperScissorsRulesTest {

	Rules rules;

	@Before
	public void setUp() {
		rules = new RockPaperScissorsRules();
	}

	@Test(expected = IllegalArgumentException.class)
	public void movesByNameThrowExceptionWhenNameIsInvalid() {
		rules.getByName("invalid-name");
	}

	@Test
	public void givenANameAvalidMoveIsReturned() {
		Move move = rules.getByName("rock");

		assertEquals(move.getName(), "rock");
	}

	@Test
	public void movesAllowedContainsRockPaperAndScissorsMoves() {
		List<Move> movesAllowed = rules.movesAllowed();

		assertThatMovesContainsRockPaperAndScissors(movesAllowed);
	}

	private void assertThatMovesContainsRockPaperAndScissors(
			List<Move> movesAllowed) {
		String[] moves = { "rock", "paper", "scissors" };
		for (Move move : movesAllowed) {
			assertThat(moves, hasItemInArray(move.getName()));
		}

	}
}
