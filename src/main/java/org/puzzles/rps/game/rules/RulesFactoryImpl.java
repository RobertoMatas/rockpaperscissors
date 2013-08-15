package org.puzzles.rps.game.rules;

public class RulesFactoryImpl implements RulesFactory {

	public Rules createRulesOfGame() {
		return new RockPaperScissorsRules();
	}

}
