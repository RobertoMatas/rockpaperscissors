package org.puzzles.rps.game.rules;

public enum RockPaperScissorsMoves implements Move {
	rock {
		public boolean wins(Move adversaryMove) {
			return adversaryMove == scissors;

		}
	},

	paper {
		public boolean wins(Move adversaryMove) {
			return adversaryMove == rock;

		}
	},

	scissors {
		public boolean wins(Move adversaryMove) {
			return adversaryMove == paper;

		}
	};

	public String getName() {
		return this.toString();
	}
}
