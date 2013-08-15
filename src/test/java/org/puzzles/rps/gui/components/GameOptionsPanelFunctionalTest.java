package org.puzzles.rps.gui.components;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.puzzles.rps.SlowTests;
import org.puzzles.rps.gui.GameMode;

@Category(SlowTests.class)
public class GameOptionsPanelFunctionalTest extends
		JPanelFunctionalTest<GameOptionsPanel> {

	@Test
	public void controllerIsNotifiedWithUserGameModeSelection() {
		frameFixture.panel().radioButton(GameOptionsPanel.HumanVsComputer)
				.check();

		verify(controller).gameOptionSelected(GameMode.HUMAN_VS_COMPUTER);
	}

	@Override
	protected GameOptionsPanel panelInstance() {
		return new GameOptionsPanel(controller);
	}
}
