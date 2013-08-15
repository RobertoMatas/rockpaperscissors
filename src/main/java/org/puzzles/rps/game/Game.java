package org.puzzles.rps.game;

import org.puzzles.rps.game.player.Players;

public interface Game {
	
	Players players();

	OutCome resolveGame();
}
