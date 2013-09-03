package org.puzzles.rps.game.rules.extension;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.puzzles.rps.FastTests;
import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.Rules;

@Category(FastTests.class)
public class LizardSpockExtensionRulesTest {

	Rules rules;

	@Before
	public void setUp() {
		rules = new LizardSpockExtensionRules();
	}

	@Test(expected = IllegalArgumentException.class)
	public void movesByNameThrowExceptionWhenNameIsInvalid() {
		rules.getByName("invalid-name");
	}

	@Test
	public void givenANameAvalidMoveIsReturned() {
		Move move = rules.getByName("lizard");

		assertEquals(move.getName(), "lizard");
	}

	@Test
	public void movesAllowedContainsRockPaperAndScissorsMoves() {
		List<Move> movesAllowed = rules.movesAllowed();

		assertThatMovesContainsRockPaperAndScissors(movesAllowed);
	}

	private void assertThatMovesContainsRockPaperAndScissors(
			List<Move> movesAllowed) {
		String[] moves = { "rock", "paper", "scissors", "lizard", "spock" };
		for (Move move : movesAllowed) {
			assertThat(moves, hasItemInArray(move.getName()));
		}

	}
}
