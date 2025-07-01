package lab3;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasketballTest {
	/**
	* Entry point.
	*/
	public static void main(String[] args)
	{
	@TEST
	public void test1(){
	Basketball b = new Basketball(4.0);
	assertEquals(4.0, b.getDiameter(), EPSILON);
	//System.out.println(b.getDiameter());
	//System.out.println(b.isDribbleable());
	// Construct another instance with a diameter of 6
	}
	
	
	Basketball b2 = new Basketball(6.0);
	// Inflate the first one
	b.inflate();
	// First one is now dribbleable
	System.out.println("First basketball: " + b.isDribbleable());
	// Second one is unchanged
	System.out.println("Second basketball: " + b2.isDribbleable());
	}
}
