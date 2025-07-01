package hw4;

import api.Point;

/**
 * A CouplingLink represents a direct connection between two points, A and B.
 * A train can travel in both directions along this link.
 * 
 * @author George Michael
 */

public class CouplingLink extends AbstractLink {
	
	/**
	 * Creates a CouplingLink that connects two specified points.
	 * 
	 * @param path1End one endpoint of the link
	 * @param path2Start the other endpoint of the link
	 */
	public CouplingLink(Point path1End, Point path2Start) {
		super(path1End, path2Start);
	}
	
	/**
	 * Returns the number of traversable paths in this link.
	 * 
	 * @return the total number of paths (always 2)
	 */
	@Override
	public int getNumPaths() {
		return 2;
	}
	
	/**
	 * Returns the point directly connected to the specified point.
	 * If the input is point A, returns point B, and vice versa.
	 * 
	 * @param point the reference point
	 * @return the connected point, or null if the input is not part of this link
	 */
	@Override
	public Point getConnectedPoint(Point point) {
	    Point[] points = getPoints();
	    
		if(point.equals(getPoints()[0])) {
			return points[1];
		}
		
		else if(point.equals(getPoints()[1])) {
			return points[0];
		}
		
		else {
			return null;
		} 
	}
	
	
}
