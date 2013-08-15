package org.puzzles.rps.game.rules;

public enum RockPaperScissorsMoves implements Move {
	rock, paper, scissors;

	public boolean wins(Move adversaryMove) {
		switch (this) {
			case rock:
				return adversaryMove == scissors;
	
			case paper:
				return adversaryMove == rock;
			
			case scissors:
				return adversaryMove == paper;
				
			default:
				break;
		}
		return false;
	}

	public String getName() {
		return this.toString();
	}
}
