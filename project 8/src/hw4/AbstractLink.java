package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

/**
 * All crossable train links extend this class.
 * AbstractLink class serves as a foundation for all links.
 * This class defines a base for objects that link different points together, acting as pathways for trains to cross between locations.
 * It implements core functionality related to train crossings, ensuring simulations can track when a train enters or exits a linked area.
 * Provides a method get points that gets all the points in the points array.
 * Most importantly this has shift points, which moves the position vector the the next point available. After implementing shift points in every class individually,
 * it became obvious that they were all pretty similar. After some tweaking one shift points method could be used for all classes, making it able to be implemented here and never overridden
 * Establishes getNumPaths, which returns the basic answer of 3 for paths 1, 2 and 3.
 * @author George Michael
 */
public abstract class AbstractLink implements Crossable {
	
	/**
	 * Array of points that define this link.
	 */
	private final Point[] pointArray;
	
	/**
	 * Indicates whether a train is currently within the crossing.
	 */
	private boolean isInCrossing;
	
	/**
	 * Constructs a link using the given points.
	 * 
	 * @param points the points that this link connects
	 */
	protected AbstractLink(Point...points) {
		this.pointArray = points;
	}
	
	/**
	 * Returns the array of points that define this link.
	 * 
	 * @return the points in this link
	 */
	protected Point[] getPoints() {
		return pointArray;
	}
	
	/**
	 * Called when a train enters the crossing; sets the crossing flag to true.
	 */
	public void trainEnteredCrossing() {
		isInCrossing = true;
	}

	/**
	 * Called when a train exits the crossing; sets the crossing flag to false.
	 */
	public void trainExitedCrossing() {
		isInCrossing = false;
	}

	/**
	 * Returns the number of traversable paths in this link.
	 * 
	 * @return the number of paths
	 */
	public int getNumPaths() {
		return 3;
	}
	
	/**
	 * Returns the point connected to the specified point.
	 * 
	 * @param point the reference point
	 * @return the connected point, or null if there is none
	 */
	public abstract Point getConnectedPoint(Point point);
	
	/**
	 * Updates the train’s position to move it to the next connected track segment.
	 * 
	 * @param positionVector the current position of the train
	 */
	public void shiftPoints(PositionVector positionVector) {
		Point currentPosition = positionVector.getPointA();
		Point futurePosition = positionVector.getPointB();
		Point next = getConnectedPoint(futurePosition);
		
		if (next != null) {
			positionVector.setPointA(next);
			int index = next.getPointIndex();
			int pathLength = next.getPath().getNumPoints();
			
			if (index == 0 && pathLength > 1) {
				
				positionVector.setPointB(next.getPath().getPointByIndex(1));
				
			} 
			
			else if (index == pathLength - 1 && pathLength > 1) {
				
				positionVector.setPointB(next.getPath().getPointByIndex(index - 1));
				
			} 
			
			else if (futurePosition.getPointIndex() > currentPosition.getPointIndex()) {
				
				positionVector.setPointB(next.getPath().getPointByIndex(index + 1));
				
			} 
			
			else {
				
				positionVector.setPointB(next.getPath().getPointByIndex(index - 1));
				
			}
		}
	}
}
