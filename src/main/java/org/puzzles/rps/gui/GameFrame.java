package org.puzzles.rps.gui;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import org.puzzles.rps.game.Game;
import org.puzzles.rps.game.GameFactory;
import org.puzzles.rps.game.rules.Rules;
import org.puzzles.rps.game.rules.RulesFactory;
import org.puzzles.rps.gui.components.GameOptionsPanel;
import org.puzzles.rps.gui.components.GameResultPresenterPanel;
import org.puzzles.rps.gui.components.InputHumanMovePanel;
import org.puzzles.rps.gui.utils.ClassPathResourceLoadUtils;

public class GameFrame extends JFrame implements GameController {

	private static final long serialVersionUID = -2390731292756833130L;

	private final GameFactory gameFactory;

	private final Rules gameRules;

	private JMenuBar gameMenu;

	private JLabel logo;

	private JComponent gameContainer;

	public GameFrame(GameFactory gameFactory, RulesFactory rulesFactory) {
		super();
		this.gameFactory = gameFactory;
		this.gameRules = rulesFactory.createRulesOfGame();
		gameMenu = new GameMenu(this);
		setJMenuBar(gameMenu);
		setImageBackground();
	}

	private void setImageBackground() {
		logo = new JLabel(new ClassPathResourceLoadUtils().icon("logo"));
		add(logo);
	}

	public void showGameOptions() {
		gameContainer = new JPanel(new GridLayout(1, 2));
		JComponent newContentPane = new GameOptionsPanel(this);
		gameContainer.add(newContentPane);
		gameContainer.setOpaque(true);
		setContentPane(gameContainer);
		this.pack();
	}

	public void exit() {
		System.exit(NORMAL);

	}

	public void gameOptionSelected(GameMode mode) {
		if (mode == GameMode.COMPUTER_VS_COMPUTER) {
			Game game = gameFactory.createComputerVsComputerGame();
			printGameRoundResult(game);

		} else if (mode == GameMode.HUMAN_VS_COMPUTER) {
			showInputHumanMovePanel();
		}

	}

	private void showInputHumanMovePanel() {
		JComponent inputHumanMovePanel = new InputHumanMovePanel(this,
				gameRules);
		gameContainer.add(inputHumanMovePanel);
		this.pack();
	}

	public void humanPlays(String move) {
		Game game = gameFactory.createHumanVsComputerGame(gameRules
				.getByName(move));
		printGameRoundResult(game);

	}

	private void printGameRoundResult(Game game) {
		JComponent resultPane = new GameResultPresenterPanel(game);
		resultPane.setOpaque(true);
		setContentPane(resultPane);
		this.pack();
	}

}
