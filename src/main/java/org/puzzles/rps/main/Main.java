package org.puzzles.rps.main;

import org.puzzles.rps.game.GameFactoryImpl;
import org.puzzles.rps.game.rules.RulesFactoryImpl;
import org.puzzles.rps.gui.GameFrame;

public class Main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RulesFactoryImpl rulesFactory = new RulesFactoryImpl();
				GameFrame gameFrame = new GameFrame(new GameFactoryImpl(rulesFactory), rulesFactory);
				gameFrame.setBounds(400, 150, 480, 477);
				gameFrame.setVisible(true);
			}
		});

	}

}
