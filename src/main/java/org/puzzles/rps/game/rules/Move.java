package org.puzzles.rps.game.rules;

public interface Move {

	boolean wins(Move adversaryMove);
	
	String getName();
}
