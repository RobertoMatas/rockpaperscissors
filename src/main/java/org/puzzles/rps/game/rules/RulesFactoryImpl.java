package org.puzzles.rps.game.rules;

import org.puzzles.rps.game.rules.extension.LizardSpockExtensionRules;

public class RulesFactoryImpl implements RulesFactory {

	public Rules createRulesOfGame() {
		return new LizardSpockExtensionRules();
	}

}
