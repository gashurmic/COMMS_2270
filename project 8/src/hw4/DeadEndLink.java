package hw4;

import api.Point;
import api.PositionVector;

/**
 * Represents a link with no outgoing connections (a dead end).
 * Trains cannot move through or beyond this type of link.
 * 
 * @author George Michael
 */
public class DeadEndLink extends AbstractLink {
	
	/**
	 * No action is taken here since movement is not possible in a dead-end link.
	 * 
	 * @param positionVector the current position of the train
	 */
	@Override
	public void shiftPoints(PositionVector positionVector) {
		
		
	}
	
	/**
	 * Returns the number of paths in this link.
	 * 
	 * @return always 1, since a dead-end has a single entry point
	 */
	@Override
	public int getNumPaths() {
		return 1;
	}
	
	/**
	 * Always returns null because a dead-end link has no connected points.
	 * 
	 * @param point the point for which a connection is being checked
	 * @return null, as no connections exist
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		return null;
	}
	
	
}
