package org.puzzles.rps.game;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.puzzles.rps.game.OutCome.PLAYER1_WINS;
import static org.puzzles.rps.game.OutCome.PLAYER2_WINS;
import static org.puzzles.rps.game.OutCome.TIED;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.puzzles.rps.FastTests;
import org.puzzles.rps.game.player.Player;
import org.puzzles.rps.game.player.Players;
import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.RockPaperScissorsMoves;

@Category(FastTests.class)
public class RockPaperScissorsGameRoundTest {

	Move rock, paper, scissors;

	Player player, adversary;

	Game game;

	@Before
	public void setUp() {
		rock = RockPaperScissorsMoves.rock;
		paper = RockPaperScissorsMoves.paper;
		scissors = RockPaperScissorsMoves.scissors;
		player = mock(Player.class);
		adversary = mock(Player.class);
		game = new GameRound(new Players(player, adversary));
	}

	@Test
	public void firstPlayerWins() {
		when(player.shoot()).thenReturn(rock);
		when(adversary.shoot()).thenReturn(scissors);

		OutCome outCome = game.resolveGame();

		assertThat(outCome, is(PLAYER1_WINS));
	}

	@Test
	public void secondPlayerWins() {
		when(player.shoot()).thenReturn(rock);
		when(adversary.shoot()).thenReturn(paper);

		OutCome outCome = game.resolveGame();

		assertThat(outCome, is(PLAYER2_WINS));
	}

	@Test
	public void gameFinishWithTie() {
		when(player.shoot()).thenReturn(paper);
		when(adversary.shoot()).thenReturn(paper);

		OutCome outCome = game.resolveGame();

		assertThat(outCome, is(TIED));
	}

}
