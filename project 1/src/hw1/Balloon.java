package hw1;
/**
 * 
 * @author George Michael
 * 
 */
public class Balloon {
	//instance variables will need math.max Math.min. ground level = 0. height of tether. wrapping (circular) uses mod.
	private int verticalVelocity;
	private int horizontalVelocity;
	private int altitude;
	private int maxAltitude;
	private int initalgroundPosition;
	private int groundPosition;
	private int maxGroundPosition;
	private double fuel;
	private double tankCapacity;
	private double maxBurnRate;
	private int totalSeconds;
	
	
	
	/**
	 * explicit constructor
	 * 
	 * @param groundPosition maxGroundPosition maxAltitude tankCapacity
	 */
	public Balloon(int groundPosition, int maxGroundPosition, int maxAltitude, double tankCapacity) {
		this.initalgroundPosition = groundPosition;
		this.groundPosition = groundPosition;
	    this.maxGroundPosition = maxGroundPosition;
	    this.maxAltitude = maxAltitude;
	    this.tankCapacity = tankCapacity;
	    
	   
	   
		
	}
	
	
	//public methods
	
	/**Gets the current velocity of the balloon in the vertical direction.
	 * 
	 * @return the vertical velocity
	 */
	public int getVerticalVelocity() {
		
		return verticalVelocity;
	}
	
	/**Gets the current velocity of the balloon in the horizontal direction.
	 * 
	 * @return the horizontal velocity
	 */
	public int getHorizontalVelocity() {
		
		return horizontalVelocity;
	}
	
	
	/**Gets the altitude of the balloon.
	 * 
	 * @return the altitude
	 */
	public int getAltitude() {
		
		return altitude;
	}
	
	
	/**Gets the maximum altitude of the balloon. The balloon may not fly above this value.
	 * 
	 * @return the max altitude
	 */
	public int getMaxAltitude() {
		
		return maxAltitude;
	}
	
	
	/**Gets the current position of the balloon with respect to the ground (i.e., what ground is it flying over).
	 * 
	 * @return the current ground position
	 */
	public int getGroundPosition() {
		
		return groundPosition;
	}
	
	/**Gets the farthest ground position the balloon can travel before wrapping back around (in a circle) to position 0.
	 *
	 * @return the max ground position
	 */
	public int getMaxGroundPosition() {
		
		return maxGroundPosition;
	}
	
	/**Gets the amount of fuel the balloon has in its fuel tank.
	 * 
	 * @return the current fuel
	 */
	public double getFuel() {
		
		return fuel;
	}
	
	
	/**Gets the maximum capacity of the balloon’s fuel tank.
	 * 
	 * @return the tank capacity
	 */
	public double getTankCapacity() {
		
		return tankCapacity;
	}
	
	
	/**Gets the maximum rate of fuel burn (assuming there is enough fuel to burn at this rate).
	 * 
	 * @return the max burn rate
	 */
	public double getMaxBurnRate() {
		
		return maxBurnRate;
	}
	
	
	/**Sets the capacity of the fuel tank to the given parameter.
	 * 
	 * @param tankCapacity
	 */
	public void setTankCapacity(double tankCapacity) {
		
		this.tankCapacity = tankCapacity;
	}
	
	
	/**Sets the maximum burn rate to the given parameter.
	 * 
	 * @param maxBurnRate
	 */
	public void setMaxBurnRate(double maxBurnRate) {
		this.maxBurnRate = maxBurnRate;
		
	}
	
	
	/**Sets the total time the simulation has run in seconds to the given parameter.
	 * 
	 * @param time
	 */
	public void setTime(int time) {
		
		this.totalSeconds = time;
		
	}
	
	
	/**Set the ground position back to where it was set by the constructor.
	 * 
	 */
	public void restoreInitialGroundPosition() {
		
		groundPosition = initalgroundPosition;
	}
	
	
	/**Gets the number of second past the current minute. The returned value must be between 0 and 60. 
	 * 
	 * @return the number of seconds
	 */
	public int getSeconds() {
		
		return totalSeconds % 60;
	}
	
	
	/**Gets the number of full minutes past the current hour. The returned value must be between 0 and 60. 
	 * 
	 * @return the number of minutes
	 */
	public int getMinutes() {
		
		return (totalSeconds / 60) % 60;
	}
	
	/**Gets the number of full hours that have passed.
	 * 
	 * @return the number of hours
	 */
	public int getHours() {
		
		return totalSeconds / 3600;

	}
	
	
	/**Change the vertical velocity by the given delta 
	 * 
	 * @param delta
	 */
	public void adjustVerticalVelocity(int delta) {
		
		verticalVelocity = verticalVelocity + delta;
	}
	
	/**Change the horizontal velocity by the given delta.
	 * 
	 * @param delta
	 */
	public void adjustHorizontalVelocity(int delta) {
		
		horizontalVelocity = horizontalVelocity + delta;
	}
	
	/**Add the given amount of fuel to the tank, however the tank cannot fill past its maximum capacity. Return the amount of fuel actually added
	 * 
	 * @param amount
	 * @return the amount of fuel burned
	 */
	public double addFuel(double amount) {
		double actuallyAdded = fuel;
		fuel = Math.min(fuel+amount, tankCapacity);
		actuallyAdded = fuel - actuallyAdded;
		return actuallyAdded;
	}
	
	/**Simulate the passing of one second of time
	 * 
	 * @return
	 */
	public double oneSecondUpdate() {
	   
		double actualFuelBurned = fuel;
	    fuel = Math.max(fuel - maxBurnRate, 0);
	    actualFuelBurned = actualFuelBurned - fuel;

	    totalSeconds++;

	    altitude = Math.max(0, Math.min(altitude + verticalVelocity, maxAltitude));

	    groundPosition = (groundPosition + horizontalVelocity + maxGroundPosition) % maxGroundPosition;

	    return actualFuelBurned;
	}
	
	
	
}
