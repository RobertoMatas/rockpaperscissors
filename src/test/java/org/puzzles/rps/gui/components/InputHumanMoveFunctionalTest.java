package org.puzzles.rps.gui.components;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.puzzles.rps.SlowTests;
import org.puzzles.rps.game.rules.RulesFactoryImpl;

@Category(SlowTests.class)
public class InputHumanMoveFunctionalTest extends
		JPanelFunctionalTest<InputHumanMovePanel> {

	@Test
	public void rockPaperscissorsOptionsArePresentedAtUser() {
		frameFixture.panel().radioButton("rock").requireVisible();
		frameFixture.panel().radioButton("paper").requireVisible();
		frameFixture.panel().radioButton("scissors").requireVisible();
	}

	@Test
	public void controllerIsNotifiedWhenUserSelectAShoot() {
		frameFixture.panel().radioButton("rock").check();

		verify(controller).humanPlays("rock");
	}

	@Override
	protected InputHumanMovePanel panelInstance() {
		return new InputHumanMovePanel(controller,
				new RulesFactoryImpl().createRulesOfGame());
	}
}
