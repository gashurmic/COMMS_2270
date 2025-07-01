package hw2;

public class CyGameTest2 {
	public static void main(String[] args) {
		
		//WILL I LOOSE POINTS IF I USE INSTANCE METHOD FIECTLY IN CODE AND NOT THE GETTER METHOD FOR IT
		
		//roll(3), roll(3), roll(3), buyCyTown(), roll(3), endTurn(), roll(4) and pass the endzone, roll(6) and pass the endzone and pay rent. Player 1 should now have 200 - 200 + 200 + 160 = 360 and Player 2 should now have 200 + 200 - 160 = 240. ==> expected: <360> but was: <0>

		CyGame game1 = new CyGame(7, 200);
		game1.roll(3);
		System.out.println("Expect Player 1 to advance to sqaure 3 blizzard."); //stuck in blizzard
		System.out.println(game1);
		System.out.println("");
		
		game1.roll(3);
		System.out.println("Expect Player 2 to advance to 3 blizzard.");
		System.out.println(game1);
		System.out.println("");
		
		game1.roll(3);
		System.out.println("Expect Player 1 to escape blizzard, be on cytown");
		System.out.println(game1);
		System.out.println("");
		
		game1.buyCyTown();
		System.out.println("boguht");
		//200-200 = 0;
		game1.roll(3);
		System.out.println("Expect Player 2 to advance to 6. cant buy cytown end turn");
		System.out.println(game1);
		System.out.println("");
		//issue?
		game1.endTurn();
		
		//passendzone 0 + 200 = 200;
		game1.roll(4);
		System.out.println("Expect Player 1 to advance 3 blizzard.");
		System.out.println(game1);
		System.out.println("");
		
		//passendzien payrent
		game1.roll(6);
		System.out.println("Expect Player 2 to advance to sqaure 6 should have 200+200-80= 320??.");
		System.out.println(game1);
		System.out.println("");
		
		
		System.out.println("Is game ended: " + game1.isGameEnded());

	}
	
	
}
