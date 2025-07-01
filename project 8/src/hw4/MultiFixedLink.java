package hw4;

import api.Point;
import api.PointPair;

/**
 * A link with fixed, predefined connections between specific pairs of points.
 * These connections cannot change during runtime.
 * 
 * @author George Michael
 */
public class MultiFixedLink extends AbstractLink {
	
	/**
	 * An array containing all valid point-to-point connections in this link.
	 */
	private PointPair[] pairArray;
	
	/**
	 * Constructs a MultiFixedLink with the specified point connections.
	 * 
	 * @param connections an array of PointPair objects representing the fixed connections
	 */
	public MultiFixedLink(PointPair[] connections ) {
		this.pairArray = connections;
	}
	
	/**
	 * Returns the total number of directional paths defined in this link.
	 * 
	 * @return twice the number of point pairs, representing both directions
	 */
	@Override
	public int getNumPaths() {
		return pairArray.length;
	}
	
	/**
	 * Returns the point connected to the given point, or null if no connection exists.
	 * 
	 * @param point the point to search for a connection
	 * @return the corresponding connected point, or null if none is found
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		Point connectedPoint = null;
		
		for (int i = 0; i < pairArray.length; i++) {
			PointPair pair = pairArray[i];
			
			if(point.equals(pair.getPointA())) {
				connectedPoint = pair.getPointB();
				break;
			}
		}
		return connectedPoint;
	}
	
	
	
	
}
