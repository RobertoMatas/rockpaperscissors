package org.puzzles.rps.gui;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.puzzles.rps.SlowTests;
import org.puzzles.rps.game.Game;
import org.puzzles.rps.game.GameFactory;
import org.puzzles.rps.game.OutCome;
import org.puzzles.rps.game.player.Player;
import org.puzzles.rps.game.player.Players;
import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.Rules;
import org.puzzles.rps.game.rules.RulesFactory;
import org.puzzles.rps.gui.GameFrame;
import org.puzzles.rps.gui.components.GameOptionsPanel;
import org.puzzles.rps.gui.components.fake.RulesFactoryFake;

@Category(SlowTests.class)
public class GameFrameFunctionalTest {

	private FrameFixture window;

	private GameFactory gameFactory;

	private RulesFactory rulesFactory;

	private Rules rules;

	private Game game;

	private Player computer;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() {
		inizializeMocks();
		GameFrame frame = GuiActionRunner.execute(new GuiQuery<GameFrame>() {
			protected GameFrame executeInEDT() {
				return new GameFrame(gameFactory, rulesFactory);
			}
		});
		window = new FrameFixture(frame);
		window.show();
	}

	private void inizializeMocks() {
		gameFactory = mock(GameFactory.class);
		rulesFactory = new RulesFactoryFake();
		rules = rulesFactory.createRulesOfGame();
		game = mock(Game.class);
		computer = mock(Player.class);
		when(game.players()).thenReturn(new Players(computer, computer));
		when(game.resolveGame()).thenReturn(OutCome.TIED);
		when(computer.shoot()).thenReturn(rules.getByName("rock"));
		when(gameFactory.createComputerVsComputerGame()).thenReturn(game);
		when(gameFactory.createHumanVsComputerGame(any(Move.class))).thenReturn(game);
	}

	@Test
	public void whenUserClickOnNewOptionMenuGameOptionsPanelIsShowed() {
		window.menuItemWithPath("Game", "New").click();
		window.panel("GameOptionsPanel").requireVisible();
	}

	@Test
	public void buildComputerVsComputerGameWhenUserSelectThisOption() {
		window.menuItemWithPath("Game", "New").click();
		window.panel("GameOptionsPanel").radioButton(GameOptionsPanel.ComputerVersusComputer).check();

		verify(gameFactory).createComputerVsComputerGame();
	}

	@Test
	public void inputHumanMovePanelAppaersWhenUserSelectHumanVsComputerMode() {
		window.menuItemWithPath("Game", "New").click();
		window.panel("GameOptionsPanel").radioButton(GameOptionsPanel.HumanVsComputer).check();

		window.panel("InputHumanMovePanel").requireVisible();
	}

	@Test
	public void buildHumanVsComputerGameWhenUserInputAShoot() {
		window.menuItemWithPath("Game", "New").click();
		window.panel("GameOptionsPanel").radioButton(GameOptionsPanel.HumanVsComputer).check();
		window.panel("InputHumanMovePanel").radioButton("rock").check();

		verify(gameFactory).createHumanVsComputerGame(any(Move.class));
	}

	@After
	public void tearDown() {
		window.cleanUp();
	}

}
