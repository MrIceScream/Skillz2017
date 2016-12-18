package bots;
import pirates.*;
import java.util.*;

public class MyBot implements PirateBot {
	public void doTurn(PirateGame game) {
		game.debug("======Turn Number: " + game.getTurn() + "======");
		//gives names and easy access to popular objects
		List<Pirate> myPiratesList = game.getAllMyPirates();
		List<Pirate> enemyPiratesList = game.getAllEnemyPirates();
		List<Island> islandsList = game.getAllIslands();
		Location myCityLocation = game.getMyCities().get(0).getLocation(); //!!!gets the FIRST (and currently only) owned city.
		Location enemyCityLocation = game.getEnemyCities().get(0).getLocation(); //!!!gets the FIRST (and currently only) enemy city.
		
		//sends pirates to take over island 1
		List<Integer> pirateNames = new ArrayList<Integer>(0);
		for (int i=0; i < 5; i++) pirateNames.add(i);
		attackIsland(game, myPiratesList, pirateNames, islandsList.get(1));
		
		//default ship drones to city
		shipToCity(game, game.getMyLivingDrones(), myCityLocation);
		
			
	}
	
	public static void attackIsland(PirateGame game, List<Pirate> piratesList, List<Integer> piratesNames, Island island) { //static???
		List<Pirate> piratesAttack = new ArrayList<Pirate>();
		for (int i : piratesNames) piratesAttack.add(piratesList.get(i));
		for (Pirate pirate : piratesAttack) game.setSail(pirate, game.getSailOptions(pirate, island.getLocation()).get(0));
	}
	
	public static void shipToCity(PirateGame game, List<Drone> dronesList, Location city) {
		for (Drone drone : dronesList) game.setSail(drone, game.getSailOptions(drone, city).get(0));
	}
	/*
	public static void attackPirate(List<Pirate> pirates, List<Drone> targetDrones, List<Pirate> targetPirates) {
		for (Pirate pirate : pirates) {
			if (pirate.inAttackRange())
		}
	}*/

}