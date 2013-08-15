package org.puzzles.rps;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ SlowTestSuite.class, FastTestSuite.class })
public class AllTestSuite {
}
