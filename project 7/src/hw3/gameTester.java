package hw3;

import java.util.ArrayList;
import api.Cell;
import api.CellType;
import api.Orientation;



public class gameTester {
	 public static void main(String[] args) {
	        // Example grid description (your format might differ)
	        String[][] gridDesc = {
	            {"*", "*", "*", "*", "*"},
	            {"*", "[", "#", "#", "]"},
	            {"*", ".", ".", ".", "*"},
	            {"*", "*", "*", "*", "*"}
	        };

	        // Call the GridUtil method to find boulders
	        ArrayList<Boulder> boulders = GridUtil.findBoulders(gridDesc);

	        // Print out the boulders found
	        for (Boulder boulder : boulders) {
	            System.out.println(boulder);
	        }

	        // Initialize the UI (if you have a GUI to display)
	        MainUI ui = new MainUI();
	        ui.display();
	    }
