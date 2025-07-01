package lab6;

import plotter.Plotter;
import plotter.Polyline;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseFile {
	public static Polyline parseOneLine(String Line) throws FileNotFoundException {
	
	
	String color = "";
	File myFile = new File("test.txt");
	Scanner scnr = new Scanner(myFile);
	
	String line = scnr.nextLine();
	if(line.trim().length() == 0){
	line = scnr.nextLine();
	}
	if(line.charAt(0) == '#') {
		line = scnr.nextLine();
	}
	if(scnr.hasNextInt()) {
		line = scnr.next();
		line = scnr.next();
	}
	
	
	String[] words = line.split(" ");
	//if (line.
	//scnr.next();
	color = words[0];
	int currentInt = 1;
	Polyline pl = new Polyline(color);
	for(int i = 1; i < words.length; i = i+2) {
		int x = Integer.parseInt(words[i]);
		int y = Integer.parseInt(words[i+1]);
		
		pl.addPoint(new Point(x, y));
	}
	return pl;
		

	
	
	}
	
	public static ArrayList<Polyline> readFile(String fileName) throws FileNotFoundException {
	    File myFile = new File(fileName);
	    Scanner scnr = new Scanner(myFile);
	    ArrayList<Polyline> myArr = new ArrayList<>();

	    while (scnr.hasNextLine()) {
	        String line = scnr.nextLine().trim();
	        
	        if (line.isEmpty() || line.startsWith("#")) {
	            continue; 
	        }

	        Scanner lineScanner = new Scanner(line);
	        int width = 1;
	        String color;

	       
	        if (lineScanner.hasNextInt()) {
	            width = lineScanner.nextInt();
	        }
	        
	        
	        if (!lineScanner.hasNext()) {
	            lineScanner.close();
	            continue; 
	        }
	        color = lineScanner.next();
	        
	        Polyline pl = new Polyline(color, width);

	       
	        while (lineScanner.hasNextInt()) {
	            int x = lineScanner.nextInt();
	            if (lineScanner.hasNextInt()) {
	                int y = lineScanner.nextInt();
	                pl.addPoint(new Point(x, y));
	            }
	        }
	        lineScanner.close();
	        myArr.add(pl);
	    }
	    
	    scnr.close();
	    return myArr;
	}

	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException
	  {
		/*
	    Plotter plotter = new Plotter();
	    Polyline p = parseOneLine("red 100 100 200 100 200 200 100 200 100 100");
	    plotter.plot(p);
	    
	    p = parseOneLine("2 blue 250 100 400 350 100 350 250 100");
	    plotter.plot(p);
	    */
	
		 ArrayList<Polyline> list = readFile("hello.txt");
		    Plotter plotter = new Plotter();

		    for (Polyline p : list)
		    {
		      plotter.plot(p);
		    }
		    
	  }
	
}



