package org.puzzles.rps.gui.components;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.puzzles.rps.gui.GameController;
import org.puzzles.rps.gui.GameMode;

public class GameOptionsPanel extends JPanel implements ItemListener {

	private static final long serialVersionUID = -5142919879180927001L;
	public static final String HumanVsComputer = "HUMAN_VS_COMPUTER";
	public static final String ComputerVersusComputer = "COMPUTER_VS_COMPUTER";

	private GameController controller;
	private ButtonGroup gameOptionsGroup;

	/**
	 * 
	 */
	public GameOptionsPanel(GameController controller) {
		super(new GridLayout(0, 1));
		setName("GameOptionsPanel");
		this.controller = controller;
		this.gameOptionsGroup = new ButtonGroup();

		addGameOption("Human Vs Computer", HumanVsComputer);
		addGameOption("Computer Vs Computer", ComputerVersusComputer);

	}

	private void addGameOption(String label, String actionCommand) {
		JRadioButton gameOption = new JRadioButton(label);
		gameOption.setActionCommand(actionCommand);
		gameOption.setName(actionCommand);
		gameOption.addItemListener(this);
		gameOptionsGroup.add(gameOption);
		add(gameOption);
	}

	public void itemStateChanged(ItemEvent e) {
		JRadioButton item = (JRadioButton) e.getItem();
		String actionCommand = item.getActionCommand();
		controller.gameOptionSelected(GameMode.valueOf(actionCommand));

	}

}
