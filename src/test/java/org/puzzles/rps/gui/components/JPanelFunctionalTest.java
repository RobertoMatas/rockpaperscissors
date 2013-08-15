package org.puzzles.rps.gui.components;

import static org.fest.swing.fixture.Containers.showInFrame;
import static org.mockito.Mockito.mock;

import javax.swing.JPanel;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.puzzles.rps.gui.GameController;

public abstract class JPanelFunctionalTest<PANEL extends JPanel> {

	protected FrameFixture frameFixture;
	protected GameController controller;
	protected PANEL panel;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() {
		this.controller = mock(GameController.class);
		this.panel = createPanel();
		this.frameFixture = showInFrame(panel);
	}

	@RunsInEDT
	private PANEL createPanel() {
		return GuiActionRunner.execute(new GuiQuery<PANEL>() {
			public PANEL executeInEDT() {
				return panelInstance();
			};
		});
	}

	protected abstract PANEL panelInstance();

	@After
	public void tearDown() {
		frameFixture.cleanUp();
	}
}
