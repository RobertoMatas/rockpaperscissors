package org.puzzles.rps.game.player;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.puzzles.rps.FastTests;
import org.puzzles.rps.game.player.computer.MoveGenerator;
import org.puzzles.rps.game.player.computer.RandomMoveGenerator;
import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.RockPaperScissorsMoves;
import org.puzzles.rps.game.rules.RockPaperScissorsRules;
import org.puzzles.rps.game.rules.Rules;

@Category(FastTests.class)
@RunWith(MockitoJUnitRunner.class)
public class RandomMoveGeneratorTest {

	MoveGenerator randomMoveGenerator;

	@Spy
	Random spyRandom;
	
	Rules rules;

	@Before
	public void setUp() {
		rules = new RockPaperScissorsRules();
		randomMoveGenerator = new RandomMoveGenerator(spyRandom, rules);
	}
	
	@Test
	public void randomMoveGeneratorReturnRandomMoves() {
		when(spyRandom.nextInt(numberOfPossibleMoves())).thenReturn(0, 1, 2);

		Move firstMove = randomMoveGenerator.produceMove();
		Move secondMove = randomMoveGenerator.produceMove();
		Move lastMove = randomMoveGenerator.produceMove();

		assertThat(firstMove, not(secondMove));
		assertThat(secondMove, not(lastMove));
	}

	private int numberOfPossibleMoves() {
		return RockPaperScissorsMoves.values().length;
	}

}
