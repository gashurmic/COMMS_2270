package lab6;

import plotter.Plotter;


//import plotter.Polyline;
//import java.awt.Point;


public class ParseFileTester {
	public static void main(String[] args)
	  {
	    Plotter plotter = new Plotter();
	    Polyline p = parseOneLine("red 100 100 200 100 200 200 100 200 100 100");
	    plotter.plot(p);
	    
	    p = parseOneLine("2 blue 250 100 400 350 100 350 250 100");
	    plotter.plot(p);
	  }
}
