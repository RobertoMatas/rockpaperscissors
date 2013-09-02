package org.puzzles.rps.gui.components.fake;

import org.puzzles.rps.game.rules.Move;

class MoveFake implements Move {

	private final String name;

	public MoveFake(String name) {
		this.name = name;
	}

	public boolean wins(Move adversaryMove) {
		return false;
	}

	public String getName() {
		return this.name;
	}

}