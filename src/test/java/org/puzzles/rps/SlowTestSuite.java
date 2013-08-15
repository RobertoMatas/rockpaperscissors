package org.puzzles.rps;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.puzzles.rps.gui.GameFrameFunctionalTest;
import org.puzzles.rps.gui.components.GameOptionsPanelFunctionalTest;
import org.puzzles.rps.gui.components.InputHumanMoveFunctionalTest;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@SuiteClasses({ GameFrameFunctionalTest.class,
		GameOptionsPanelFunctionalTest.class,
		InputHumanMoveFunctionalTest.class })
public class SlowTestSuite {
}
