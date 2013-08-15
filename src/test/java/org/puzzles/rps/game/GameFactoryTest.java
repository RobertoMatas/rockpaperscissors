package org.puzzles.rps.game;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.puzzles.rps.game.rules.RockPaperScissorsMoves.paper;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.puzzles.rps.FastTests;
import org.puzzles.rps.game.player.computer.Computer;
import org.puzzles.rps.game.player.human.Human;
import org.puzzles.rps.game.rules.RulesFactory;
import org.puzzles.rps.game.rules.RulesFactoryImpl;

@Category(FastTests.class)
public class GameFactoryTest {

	GameFactory gameFactory;

	RulesFactory rulesFactory;
	
	@Before
	public void setUp() {
		rulesFactory = new RulesFactoryImpl();
		gameFactory = new GameFactoryImpl(rulesFactory);
	}

	@Test
	public void factoryCreatesAnComputerVsComputerGame() {
		Game game = gameFactory.createComputerVsComputerGame();

		assertThatAllPlayersAreComputers(game);
	}

	private void assertThatAllPlayersAreComputers(Game game) {
		assertThat(game.players().firstPlayer, instanceOf(Computer.class));
		assertThat(game.players().secondPlayer, instanceOf(Computer.class));
	}

	@Test
	public void factoryCreatesAnHumanVsComputerGame() {
		Game game = gameFactory.createHumanVsComputerGame(paper);

		assertThat(game.players().firstPlayer, instanceOf(Human.class));
		assertThat(game.players().secondPlayer, instanceOf(Computer.class));
	}

}
