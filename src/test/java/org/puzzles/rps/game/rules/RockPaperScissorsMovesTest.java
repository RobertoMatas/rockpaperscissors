package org.puzzles.rps.game.rules;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.puzzles.rps.game.rules.RockPaperScissorsMoves.paper;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.puzzles.rps.FastTests;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@Category(FastTests.class)
@RunWith(ZohhakRunner.class)
public class RockPaperScissorsMovesTest {

	@TestWith({ 
		"rock, scissors", 
		"paper, rock", 
		"scissors, paper" 
	})
	public void playerMoveWinsVersusAdversaryMove(RockPaperScissorsMoves playerMove,
			RockPaperScissorsMoves adversaryMove) {
		assertThat(playerMove.wins(adversaryMove), is(TRUE));
	}
	
	@TestWith({ 
		"rock, paper", 
		"paper, scissors", 
		"scissors, rock" 
	})
	public void playerMoveLoseVersusAdversaryMove(RockPaperScissorsMoves playerMove,
			RockPaperScissorsMoves adversaryMove) {
		assertThat(playerMove.wins(adversaryMove), not(TRUE));
	}
	
	@Test
	public void nameForMoveIsEnumName() {
		assertThat(paper.getName(), is("paper"));
	}
}
