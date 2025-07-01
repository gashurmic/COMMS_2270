package hw4;

import api.Point;

/**
 * A SwitchLink allows a train to choose between two output paths (B or C) from a single input (A).
 * The selected output depends on the 'turn' setting. Both B and C always return to A.
 * 
 * @author George Michael
 */
public class SwitchLink extends AbstractLink {
	
	/**
	 * Array holding the points involved in this link.
	 */
	private Point[] points = getPoints();
	
	/**
	 * Indicates whether the train is turning. True means it switches to C; false goes to B.
	 */
	private boolean turn;

	/**
	 * Sets the direction of the switch.
	 * 
	 * @param turn true to connect to point C, false to connect to point B
	 */
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	/**
	 * Constructs a SwitchLink using three connected points.
	 * 
	 * @param pointA the shared input point
	 * @param pointB the first possible output point
	 * @param pointC the second possible output point
	 */
	public SwitchLink(Point pointA, Point pointB, Point pointC) {
		super(pointA, pointB, pointC);
	}
	
	
	
	/**
	 * Returns the point connected to the given point, based on the current switch state.
	 * 
	 * @param point the point for which the connection is requested
	 * @return the connected point, or null if no valid connection exists
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		
		if(point.equals(getPoints()[0])) {
			if (turn) {
				return points[2]; // If turning, connect to C
			} 
			
			else {
				return points[1]; // If not turning, connect to B
			}
		} 
		
		else if (point.equals(getPoints()[1]) || point.equals(getPoints()[2])) {
			return points[0]; // B and C always connect back to A
		}
		
		return null; // No valid connection
		
	} 
	
	
}
