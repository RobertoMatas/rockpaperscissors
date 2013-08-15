package org.puzzles.rps.gui.components;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.Rules;
import org.puzzles.rps.gui.GameController;
import org.puzzles.rps.gui.utils.ClassPathResourceLoadUtils;
import org.puzzles.rps.gui.utils.ResourceLoadUtils;

public class InputHumanMovePanel extends JPanel implements ItemListener {
	private static final long serialVersionUID = -5142919879180927001L;

	private GameController controller;
	private Rules gameRules;
	private ResourceLoadUtils loadUtils;

	private ButtonGroup gameMovementsGroup;

	public InputHumanMovePanel(GameController controller, Rules gameRules) {
		super(new GridLayout(0, 1));
		setName("InputHumanMovePanel");
		this.controller = controller;
		this.gameRules = gameRules;
		this.loadUtils = new ClassPathResourceLoadUtils();
		gameMovementsGroup = new ButtonGroup();

		addMovementOptions();
	}

	private void addMovementOptions() {
		List<Move> movesAllowed = gameRules.movesAllowed();
		for (Move move : movesAllowed) {
			addMove(move.getName());
		}
	}

	private void addMove(String moveLabel) {
		String move = moveLabel.toLowerCase();
		JRadioButton moveRadio = new JRadioButton(moveLabel,
				loadUtils.icon(move));
		moveRadio.setActionCommand(move);
		moveRadio.setName(move);
		moveRadio.addItemListener(this);
		gameMovementsGroup.add(moveRadio);
		add(moveRadio);
	}

	public void itemStateChanged(ItemEvent e) {
		JRadioButton item = (JRadioButton) e.getItem();
		controller.humanPlays(item.getActionCommand());

	}

}
