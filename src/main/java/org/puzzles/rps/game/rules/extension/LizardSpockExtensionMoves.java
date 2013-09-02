package org.puzzles.rps.game.rules.extension;

import org.puzzles.rps.game.rules.Move;

public enum LizardSpockExtensionMoves implements Move {

	rock {
		public boolean wins(Move adversaryMove) {
			return adversaryMove == scissors || adversaryMove == lizard;

		}
	},

	paper {
		public boolean wins(Move adversaryMove) {
			return adversaryMove == rock || adversaryMove == spock;

		}
	},

	scissors {
		public boolean wins(Move adversaryMove) {
			return adversaryMove == paper || adversaryMove == lizard;

		}
	},

	lizard {
		public boolean wins(Move adversaryMove) {
			return adversaryMove == paper || adversaryMove == spock;

		}
	},

	spock {
		public boolean wins(Move adversaryMove) {
			return adversaryMove == rock || adversaryMove == scissors;

		}
	};

	public String getName() {
		return this.toString();
	}
}
