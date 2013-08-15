package org.puzzles.rps.game.player;

import static org.junit.Assert.assertSame;

import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.puzzles.rps.FastTests;
import org.puzzles.rps.game.player.Player;
import org.puzzles.rps.game.player.human.Human;
import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.RockPaperScissorsMoves;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@Category(FastTests.class)
@RunWith(ZohhakRunner.class)
public class HumanTest {

	Player human;
	
	@TestWith({
		"rock", "scissors", "paper"		
	})
	public void humanPlays(RockPaperScissorsMoves move) {
		human = new Human(move);
		
		Move playerShoot = human.shoot();
		
		assertSame(move, playerShoot);
	}
}
