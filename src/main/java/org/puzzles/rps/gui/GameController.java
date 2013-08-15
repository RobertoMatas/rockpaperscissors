package org.puzzles.rps.gui;

public interface GameController {
	
	void showGameOptions();
	
	void exit();
	
	void gameOptionSelected(GameMode mode);
	
	void humanPlays(String move);
}
