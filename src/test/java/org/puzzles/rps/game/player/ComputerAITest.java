package org.puzzles.rps.game.player;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.puzzles.rps.FastTests;
import org.puzzles.rps.game.player.computer.Computer;
import org.puzzles.rps.game.player.computer.MoveGenerator;
import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.RockPaperScissorsMoves;

@Category(FastTests.class)
public class ComputerAITest {

	MoveGenerator moveGenerator;

	Computer computer;

	private Move moveGenerated;

	@Before
	public void setUp() {
		moveGenerator = mock(MoveGenerator.class);
		moveGenerated = RockPaperScissorsMoves.paper;
		when(moveGenerator.produceMove()).thenReturn(moveGenerated);
		computer = new Computer(moveGenerator);
	}
	
	@Test
	public void computerCallsAIForMoveGeneration() {
		verify(moveGenerator).produceMove();
	}

	@Test
	public void computerShootMoveReturnedByAI() {
		Move moveReturned = computer.shoot();

		assertSame(moveGenerated, moveReturned);

	}
}
