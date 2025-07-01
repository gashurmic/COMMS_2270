package hw4;

import api.Point;

/**
 * A link that connects three points, allowing the train to make turns between them.
 * 
 * @author George Michael
 */
public class TurnLink extends AbstractLink {
	
	/**
	 * Array storing the points involved in this link.
	 */
	private Point[] pointArray = getPoints();
	
	/**
	 * Constructs a TurnLink using three points.
	 * 
	 * @param path1End the first point
	 * @param path2Start the second point
	 * @param path3Start the third point
	 */
	public TurnLink(Point path1End, Point path2Start, Point path3Start) {
		super(path1End, path2Start, path3Start);
	}
	
	

	/**
	 * Returns the point that is connected to the given point.
	 * 
	 * @param point the point to check for a connection
	 * @return the connected point, or null if no connection exists
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		
		if (point.equals(getPoints()[0])) {
			return pointArray[2];
		} 
		
		else if (point.equals(getPoints()[1])) {
			return pointArray[0];
		}
		
		else if (point.equals(getPoints()[2])) {
			return pointArray[0];
		}
		
		else {
			return null;
		}
	}
	
	
}
