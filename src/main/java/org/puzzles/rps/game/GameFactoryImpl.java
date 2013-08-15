package org.puzzles.rps.game;

import org.puzzles.rps.game.player.Players;
import org.puzzles.rps.game.player.computer.Computer;
import org.puzzles.rps.game.player.computer.RandomMoveGenerator;
import org.puzzles.rps.game.player.human.Human;
import org.puzzles.rps.game.rules.Move;
import org.puzzles.rps.game.rules.Rules;
import org.puzzles.rps.game.rules.RulesFactory;

public class GameFactoryImpl implements GameFactory {

	private final Rules rulesOfGame;

	/**
	 * 
	 * @param rulesFactory
	 */
	public GameFactoryImpl(RulesFactory rulesFactory) {
		super();
		this.rulesOfGame = rulesFactory.createRulesOfGame();
	}

	public Game createHumanVsComputerGame(Move humanMove) {
		return new GameRound(new Players(new Human(humanMove), new Computer(
				new RandomMoveGenerator(rulesOfGame))));
	}

	public Game createComputerVsComputerGame() {
		return new GameRound(new Players(new Computer(new RandomMoveGenerator(
				rulesOfGame)), new Computer(
				new RandomMoveGenerator(rulesOfGame))));
	}

}
