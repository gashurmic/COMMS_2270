package hw4;

import api.Point;

/**
 * Represents a straight link that directly connects two endpoints.
 * A train can travel back and forth between these two endpoints.
 * 
 * @author George Michael
 */
public class StraightLink extends AbstractLink {
	
	/**
	 * Constructs a StraightLink using two endpoints and an intermediate point.
	 * 
	 * @param path1End the first endpoint
	 * @param path2Start the intermediate point
	 * @param path3Start the second endpoint
	 */
	public StraightLink(Point path1End, Point path2Start, Point path3Start) {
		super(path1End, path2Start, path3Start);
	}
	
	
	
	/**
	 * Returns the point connected to the specified point.
	 * If the given point is one of the endpoints, the corresponding connection is returned.
	 * 
	 * @param point the point for which to find the connection
	 * @return the connected point, or null if the point does not have a valid connection
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		Point[] pointArray = getPoints();
		
		if(point.equals(getPoints()[0])) {
			return pointArray[1];
		}
		
		else if(point.equals(getPoints()[1])) {
			return pointArray[0];
		}
		
		else if(point.equals(getPoints()[2])) {
			return pointArray[0];
		} 
		
		else {
			return null;
		}
		
	}
	
	
}
