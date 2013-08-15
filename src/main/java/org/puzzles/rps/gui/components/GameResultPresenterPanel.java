package org.puzzles.rps.gui.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.puzzles.rps.game.Game;
import org.puzzles.rps.game.OutCome;
import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.gui.utils.ClassPathResourceLoadUtils;
import org.puzzles.rps.gui.utils.ResourceLoadUtils;

public class GameResultPresenterPanel extends JPanel {

	private static final long serialVersionUID = 1697093417914084136L;

	private ResourceLoadUtils classPathResourceLoadUtils;

	public GameResultPresenterPanel(Game game) {
		super(new GridLayout(3, 2, 5, 10));
		setName("GameResultPresenterPanel");

		classPathResourceLoadUtils = new ClassPathResourceLoadUtils();

		Move shootPlayer1 = game.players().firstPlayer.shoot();
		Move shootPlayer2 = game.players().secondPlayer.shoot();

		printPlayerMove("Player 1 shoots ", Color.BLUE, shootPlayer1);
		printPlayerMove("Player 2 shoots ", Color.DARK_GRAY, shootPlayer2);

		printGameResult(game);
	}

	private void printGameResult(Game game) {
		JLabel printableResult = new JLabel();
		printableResult.setText(printableResult(game.resolveGame()));
		printableResult.setForeground(Color.ORANGE);
		add(printableResult);
	}

	private String printableResult(OutCome resolveGame) {
		switch (resolveGame) {
		case PLAYER1_WINS:
			return "Player 1 WINS !!";

		case PLAYER2_WINS:
			return "Player 2 WINS !!";

		default:
			return "TIED !!";
		}
	}

	private void printPlayerMove(String moveExplanation, Color textColor, Move move) {
		JLabel playerMoveTxt = new JLabel();
		JLabel moveIcon = new JLabel();

		playerMoveTxt.setText(moveExplanation);
		playerMoveTxt.setForeground(textColor);
		moveIcon.setIcon(classPathResourceLoadUtils.icon(move.getName()));
		add(playerMoveTxt);
		add(moveIcon);

	}
}
