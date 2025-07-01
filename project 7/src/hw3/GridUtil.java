package hw3;

import static api.Orientation.*;
import static api.CellType.*;

import java.util.ArrayList;

import api.Cell;
import api.CellType;
import api.Orientation;

/**
 * Utilities for parsing string descriptions of a grid.
 */
public class GridUtil {
	/**
	 * Constructs a 2D grid of Cell objects given a 2D array of cell descriptions.
	 * String descriptions are a single character and have the following meaning.
	 * <ul>
	 * <li>"*" represents a wall.</li>
	 * <li>"e" represents an exit.</li>
	 * <li>"." represents a ground.</li>
	 * <li>"[", "]", "^", "v", or "#" represent a part of a boulder. A boulder is not a
	 * type of cell, it is something placed on a cell ground. For these descriptions
	 * a cell is created with CellType of GROUND. This method does not create any
	 * boulders or set boulders on cells.</li>
	 * </ul>
	 * The method only creates cells and not boulders. See the other utility method
	 * findBoulders which is used to create the boulders.
	 * 
	 * @param desc a 2D array of strings describing the grid
	 * @return a 2D array of cells the represent the grid without any boulders present
	 */
	public static Cell[][] createGrid(String[][] desc) {
		Cell[][] grid = new Cell[desc.length][desc[0].length];
		for(int i=0; i <desc.length; ++i) {
			for(int j = 0; j < desc[0].length; ++j) {
				if(desc[i][j].equals("*")) {
					Cell newCell = new Cell(i, j, WALL);
					grid[i][j] = newCell;

				}
				else if(desc[i][j].equals("e")) {
					Cell newCell = new Cell(i, j, EXIT);
					grid[i][j] = newCell;

				}
				else if(desc[i][j].equals(".")) {
					Cell newCell = new Cell(i, j, GROUND);
					grid[i][j] = newCell;

				}
				else{
					Cell newCell = new Cell(i, j, GROUND);
					grid[i][j] = newCell;
				}
				
			}
		}
		return grid;
	}

	/**
	 * Returns a list of boulders that are constructed from a given 2D array of cell
	 * descriptions. String descriptions are a single character and have the
	 * following meanings.
	 * <ul>
	 * <li>"[" the start (left most column) of a horizontal boulder</li>
	 * <li>"]" the end (right most column) of a horizontal boulder</li>
	 * <li>"^" the start (top most row) of a vertical boulder</li>
	 * <li>"v" the end (bottom most column) of a vertical boulder</li>
	 * <li>"#" inner segments of a boulder, these are always placed between the start
	 * and end of the boulder</li>
	 * <li>"*", ".", and "e" symbols that describe cell types, meaning there is not
	 * boulder currently over the cell</li>
	 * </ul>
	 * 
	 * @param desc a 2D array of strings describing the grid
	 * @return a list of boulders found in the given grid description
	 */
	public static ArrayList<Boulder> findBoulders(String[][] desc) {
	    ArrayList<Boulder> boulders = new ArrayList<>();

	    // Check for horizontal boulders
	    for (int i = 0; i < desc.length; ++i) {
	        for (int j = 0; j < desc[0].length; ++j) {
	            if (desc[i][j].equals("[")) {
	                int startCol = j;
	                int length = 1;
	                // Move to next column to check for horizontal boulder
	                j++;
	                // Loop to find the end of the boulder (']')
	                while (j < desc[0].length && !desc[i][j].equals("]")) {
	                    length++;
	                    j++;
	                }
	                // If the end ']' is found, create a boulder
	                if (j < desc[0].length && desc[i][j].equals("]")) {
	                    length++;  // include the closing ]
	                    boulders.add(new Boulder(i, startCol, length, HORIZONTAL));
	                }
	            }
	        }
	    }

	    // Check for vertical boulders
	    for (int j = 0; j < desc[0].length; ++j) {
	        for (int i = 0; i < desc.length; ++i) {
	            if (desc[i][j].equals("^")) {
	                int startRow = i;
	                int length = 1;
	                // Move to next row to check for vertical boulder
	                i++;
	                // Loop to find the end of the boulder ('v')
	                while (i < desc.length && !desc[i][j].equals("v")) {
	                    length++;
	                    i++;
	                }
	                // If the end 'v' is found, create a boulder
	                if (i < desc.length && desc[i][j].equals("v")) {
	                    length++;  // include the closing v
	                    boulders.add(new Boulder(startRow, j, length, VERTICAL));
	                }
	            }
	        }
	    }

	    return boulders;
	}
}
