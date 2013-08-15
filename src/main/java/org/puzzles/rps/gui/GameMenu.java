package org.puzzles.rps.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.puzzles.rps.gui.utils.ClassPathResourceLoadUtils;
import org.puzzles.rps.gui.utils.ResourceLoadUtils;

public class GameMenu extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = -2439857914516120268L;

	private GameController controller;
	private ResourceLoadUtils loadUtils;

	private JMenuItem newGame;
	private JMenuItem exit;

	private JMenu menu;

	public GameMenu(GameController controller) {
		this.controller = controller;
		this.loadUtils = new ClassPathResourceLoadUtils();
		configureMenu();
	}

	private void configureMenu() {
		createMenuItems();
		createMenu();
		configureListeners();
	}

	private void createMenuItems() {
		newGame = new JMenuItem("New", loadUtils.icon("new"));
		exit = new JMenuItem("Exit", loadUtils.icon("exit"));
	}

	private void createMenu() {
		menu = new JMenu("Game");
		menu.add(newGame);
		menu.add(exit);
		add(menu);
	}

	private void configureListeners() {
		newGame.addActionListener(this);
		exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == newGame) {
			controller.showGameOptions();

		} else if (source == exit) {
			controller.exit();
		}

	}
}