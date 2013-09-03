package org.puzzles.rps.game.rules.extension;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.puzzles.rps.game.rules.extension.LizardSpockExtensionMoves.paper;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.puzzles.rps.FastTests;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@Category(FastTests.class)
@RunWith(ZohhakRunner.class)
public class LizardSpockExtensionMovesTest {

	@TestWith({ 
		"scissors, lizard", 
		"scissors, paper", 
		"paper, rock",
		"paper, spock",
		"rock, scissors",
		"rock, lizard",
		"lizard, paper",
		"lizard, spock",
		"spock, rock",
		"spock, scissors"
	})
	public void playerMoveWinsVersusAdversaryMove(LizardSpockExtensionMoves playerMove,
			LizardSpockExtensionMoves adversaryMove) {
		assertThat(playerMove.wins(adversaryMove), is(TRUE));
	}
	
	@TestWith({ 
		"lizard, scissors", 
		"paper, scissors", 
		"rock, paper",
		"spock, paper",
		"scissors, rock",
		"lizard, rock",
		"paper, lizard",
		"spock, lizard",
		"rock, spock",
		"scissors, spock"
	})
	public void playerMoveLoseVersusAdversaryMove(LizardSpockExtensionMoves playerMove,
			LizardSpockExtensionMoves adversaryMove) {
		assertThat(playerMove.wins(adversaryMove), not(TRUE));
	}
	
	@Test
	public void nameForMoveIsEnumName() {
		assertThat(paper.getName(), is("paper"));
	}
}
