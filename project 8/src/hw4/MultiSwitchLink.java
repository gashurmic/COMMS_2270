package hw4;

import java.util.ArrayList;
import api.PointPair;

/**
 * A type of link that supports multiple connections between points, where the connections can be switched dynamically.
 * Each valid connection is represented as a PointPair.
 * 
 * @author George Michael
 */
public class MultiSwitchLink extends MultiFixedLink {

	/**
	 * Array of point pairs representing the currently active connections in this link.
	 */
	private PointPair[] pairArray;

	/**
	 * A list of all original point pairs, used to manage and update switchable connections.
	 */
	private ArrayList<PointPair> pairList;

	/**
	 * Constructs a MultiSwitchLink with the specified initial connections.
	 * 
	 * @param connections an array of PointPair objects defining initial connections
	 */
	public MultiSwitchLink(PointPair[] connections ) {
		super(connections);
		this.pairArray = connections;
		pairList = new ArrayList<>();
		
		for (PointPair pair : connections) {
			pairList.add(pair);		
		}
	}
	
	

	/**
	 * Updates the connection at the specified index with a new PointPair.
	 * If the index is out of bounds, the method does nothing.
	 * 
	 * @param pointPair the new connection to insert
	 * @param index the index of the connection to replace
	 */
	public void switchConnection(PointPair pointPair, int index) {
		if (index < 0) {
			return;
		}
		
		if(index >= pairArray.length) {
			return;
		}
		
		pairArray[index] = pointPair;
		
	}

	
	
}
