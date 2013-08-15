package org.puzzles.rps.game;

import static org.puzzles.rps.game.OutCome.PLAYER1_WINS;
import static org.puzzles.rps.game.OutCome.PLAYER2_WINS;
import static org.puzzles.rps.game.OutCome.TIED;

import org.puzzles.rps.game.player.Players;
import org.puzzles.rps.game.rules.Move;

public class GameRound implements Game {

	public final Players players;
	
	public GameRound(Players players) {
		this.players = players;
	}

	public OutCome resolveGame() {
		Move player1Move = players.firstPlayer.shoot();
		Move player2Move = players.secondPlayer.shoot();
		if (player1Move.wins(player2Move)) {
			return PLAYER1_WINS;
		} else if (player2Move.wins(player1Move)) {
			return PLAYER2_WINS;
		}
		return TIED;
	}

	public Players players() {
		return players;
	}
	
	
}
