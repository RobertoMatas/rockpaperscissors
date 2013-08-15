package org.puzzles.rps.game;

import org.puzzles.rps.game.rules.Move;

public interface GameFactory {

	Game createHumanVsComputerGame(Move humanMove);
	
	Game createComputerVsComputerGame();
}
