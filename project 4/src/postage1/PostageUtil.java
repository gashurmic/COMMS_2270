package postage1;

public class PostageUtil
{
  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   */
  public static double computePostage(double weight)
  {
    
	  double static cost;
	  
	  if (weight <= 1) {
		  
		  cost = 0.47;
	  }
	  else if(weight <= 3.5) {
		  
		  cost = 0.47 + Math.ceil(weight - 1) * 0.21;
		  
	  }
	  else {
		  
		  cost = 0.94 + Math.ceil(weight - 1) * 0.21;
	  }
	 
    return 0.0;
  }
}