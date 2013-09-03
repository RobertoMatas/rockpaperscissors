package org.puzzles.rps;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.puzzles.rps.game.GameFactoryTest;
import org.puzzles.rps.game.RockPaperScissorsGameRoundTest;
import org.puzzles.rps.game.player.ComputerAITest;
import org.puzzles.rps.game.player.HumanTest;
import org.puzzles.rps.game.player.RandomMoveGeneratorTest;
import org.puzzles.rps.game.rules.RockPaperScissorsMovesTest;
import org.puzzles.rps.game.rules.RockPaperScissorsRulesTest;
import org.puzzles.rps.game.rules.extension.LizardSpockExtensionMovesTest;
import org.puzzles.rps.game.rules.extension.LizardSpockExtensionRulesTest;

@RunWith(Categories.class)
@IncludeCategory(FastTests.class)
@SuiteClasses({ RockPaperScissorsGameRoundTest.class, GameFactoryTest.class,
		RockPaperScissorsMovesTest.class, ComputerAITest.class,
		HumanTest.class, RandomMoveGeneratorTest.class,
		RockPaperScissorsRulesTest.class, LizardSpockExtensionMovesTest.class, 
		LizardSpockExtensionRulesTest.class })
public class FastTestSuite {
}
