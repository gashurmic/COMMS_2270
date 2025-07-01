import api.*;
import hw4.*;
import simulation.*;

public class tests {
	public static void main(String[] args) {
		testTurnLink();
		testStraightLink();
		testSwitchLink();
		testCouplingLink();
		testDeadEndLink();
		testMultiFixedLink();
		testMultiSwitchLink();
	}
	
    public static void testTurnLink() {
    	System.out.println("--------------");
    	System.out.println("TEST TURN LINK");
    	System.out.println("--------------");
    	Track track = new Track();

    	// Create three paths
    	Path a = track.addPathType(PathTypes.westToEast, 3, 3);           // entry path
    	Path b = track.addPathType(PathTypes.westToEast, 4, 3);           // straight continuation
    	Path c = track.addPathType(PathTypes.curveWestToNorth, 4, 2);     // turning path

    	// Create the TurnLink connecting the high end of path a to low ends of path b and path c
    	Point pa = a.getHighpoint();
    	Point pb = b.getLowpoint();
    	Point pc = c.getLowpoint();
    	
    	TurnLink link = new TurnLink(pa, pb, pc);

    	// Attach the TurnLink to the paths
    	a.setHighEndpointLink(link);
    	b.setLowEndpointLink(link);
    	c.setLowEndpointLink(link);
    	
    	//Test getNumPath
    	System.out.println("Link has " + link.getNumPaths() + " paths. Expected 3.");
    	System.out.println();
    	
    	Point aConnected = link.getConnectedPoint(pa);
    	Point bConnected = link.getConnectedPoint(pb);
    	Point cConnected = link.getConnectedPoint(pc);
    	
    	//Test getConnectedPoint
    	if (aConnected == pc) {
    		System.out.println("Point A is connected to point C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point A is not connected to point C.");
    	}
    	
    	if (bConnected == pa) {
    		System.out.println("Point B is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point B is not connected to point A.");
    	}
    	
    	if (cConnected == pa) {
    		System.out.println("Point C is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point C is not connected to point A.");
    	}
    	
    	System.out.println();
    	
    	//Test shiftPoints
    	//Create position vector
    	// Set up a PositionVector approaching the TurnLink from path a
    	Point beforeHigh = a.getPointByIndex(a.getNumPoints() - 2); // second-to-last point on path a
    	Point high = a.getHighpoint(); // the endpoint of path a

    	PositionVector pv = new PositionVector();
    	
    	pv.setPointA(beforeHigh);
    	pv.setPointB(high);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pc && pv.getPointB() == c.getPointByIndex(1)) {
    		System.out.println("Train from A goes to C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from A does not go to C.");
    	}
    	
    	pv.setPointA(b.getPointByIndex(1));
    	pv.setPointB(pb);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from B goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from B does not go to A.");
    	}
    	
    	pv.setPointA(c.getPointByIndex(1));
    	pv.setPointB(pc);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from C goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from C does not go to A.");
    	}
    	
    	System.out.println();
    }
    
    public static void testStraightLink() {
    	System.out.println("--------------");
    	System.out.println("TEST STRAIGHT LINK");
    	System.out.println("--------------");
    	Track track = new Track();

    	// Create three paths
    	Path a = track.addPathType(PathTypes.westToEast, 3, 3);           // entry path
    	Path b = track.addPathType(PathTypes.westToEast, 4, 3);           // straight continuation
    	Path c = track.addPathType(PathTypes.curveWestToNorth, 4, 2);     // turning path

    	// Create the link connecting the high end of path a to low ends of path b and path c
    	Point pa = a.getHighpoint();
    	Point pb = b.getLowpoint();
    	Point pc = c.getLowpoint();
    	
    	StraightLink link = new StraightLink(pa, pb, pc);

    	// Attach the link to the paths
    	a.setHighEndpointLink(link);
    	b.setLowEndpointLink(link);
    	c.setLowEndpointLink(link);

    	//Test getNumPath
    	System.out.println("Link has " + link.getNumPaths() + " paths. Expected 3.");
    	System.out.println();
    	
    	Point aConnected = link.getConnectedPoint(pa);
    	Point bConnected = link.getConnectedPoint(pb);
    	Point cConnected = link.getConnectedPoint(pc);
    	
    	//Test getConnectedPoint
    	if (aConnected == pb) {
    		System.out.println("Point A is connected to point B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point A is not connected to point B.");
    	}
    	
    	if (bConnected == pa) {
    		System.out.println("Point B is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point B is not connected to point A.");
    	}
    	
    	if (cConnected == pa) {
    		System.out.println("Point C is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point C is not connected to point A.");
    	}
    	
    	System.out.println();
    	
    	//Test shiftPoints
    	//Create position vector
    	// Set up a PositionVector approaching the TurnLink from path a
    	Point beforeHigh = a.getPointByIndex(a.getNumPoints() - 2); // second-to-last point on path a
    	Point high = a.getHighpoint(); // the endpoint of path a

    	PositionVector pv = new PositionVector();
    	
    	pv.setPointA(beforeHigh);
    	pv.setPointB(high);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pb && pv.getPointB() == b.getPointByIndex(1)) {
    		System.out.println("Train from A goes to B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from A does not go to B.");
    	}
    	
    	pv.setPointA(b.getPointByIndex(1));
    	pv.setPointB(pb);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from B goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from B does not go to A.");
    	}
    	
    	pv.setPointA(c.getPointByIndex(1));
    	pv.setPointB(pc);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from C goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from C does not go to A.");
    	}
    	
    	System.out.println();
    }
    
    public static void testSwitchLink() {
    	System.out.println("--------------");
    	System.out.println("TEST SWITCH LINK");
    	System.out.println("--------------");
    	Track track = new Track();

    	// Create three paths
    	Path a = track.addPathType(PathTypes.westToEast, 3, 3);           // entry path
    	Path b = track.addPathType(PathTypes.westToEast, 4, 3);           // straight continuation
    	Path c = track.addPathType(PathTypes.curveWestToNorth, 4, 2);     // turning path

    	// Create the link connecting the high end of path a to low ends of path b and path c
    	Point pa = a.getHighpoint();
    	Point pb = b.getLowpoint();
    	Point pc = c.getLowpoint();
    	
    	SwitchLink link = new SwitchLink(pa, pb, pc);

    	// Attach the link to the paths
    	a.setHighEndpointLink(link);
    	b.setLowEndpointLink(link);
    	c.setLowEndpointLink(link);
    	
    	Point aConnected = link.getConnectedPoint(pa);
    	Point bConnected = link.getConnectedPoint(pb);
    	Point cConnected = link.getConnectedPoint(pc);
    	
    	//Test getNumPath
    	System.out.println("Link has " + link.getNumPaths() + " paths. Expected 3.");
    	System.out.println();
    	
    	System.out.println("TEST WHEN TURN IS SET TO FALSE (ESSENTIALLY A STRAIGHTLINK)");
    	link.setTurn(false);
    	//Test getConnectedPoint
    	if (aConnected == pb) {
    		System.out.println("Point A is connected to point B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point A is not connected to point B.");
    	}
    	
    	if (bConnected == pa) {
    		System.out.println("Point B is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point B is not connected to point A.");
    	}
    	
    	if (cConnected == pa) {
    		System.out.println("Point C is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point C is not connected to point A.");
    	}
    	
    	System.out.println();
    	
    	//Test shiftPoints
    	//Create position vector
    	// Set up a PositionVector approaching the TurnLink from path a
    	Point beforeHigh = a.getPointByIndex(a.getNumPoints() - 2); // second-to-last point on path a
    	Point high = a.getHighpoint(); // the endpoint of path a

    	PositionVector pv = new PositionVector();
    	
    	pv.setPointA(beforeHigh);
    	pv.setPointB(high);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pb && pv.getPointB() == b.getPointByIndex(1)) {
    		System.out.println("Train from A goes to B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from A does not go to B.");
    	}
    	
    	pv.setPointA(b.getPointByIndex(1));
    	pv.setPointB(pb);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from B goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from B does not go to A.");
    	}
    	
    	pv.setPointA(c.getPointByIndex(1));
    	pv.setPointB(pc);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from C goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from C does not go to A.");
    	}
    	
    	System.out.println();
    	
    	//Test when turn is true
    	System.out.println("TEST WHEN TURN IS SET TO TRUE (ESSENTIALLY A TURNLINK)");
    	link.setTurn(true);
    	
    	aConnected = link.getConnectedPoint(pa);
    	bConnected = link.getConnectedPoint(pb);
    	cConnected = link.getConnectedPoint(pc);
    	
    	//Test getConnectedPoint
    	if (aConnected == pc) {
    		System.out.println("Point A is connected to point C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point A is not connected to point C.");
    	}
    	
    	if (bConnected == pa) {
    		System.out.println("Point B is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point B is not connected to point A.");
    	}
    	
    	if (cConnected == pa) {
    		System.out.println("Point C is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point C is not connected to point A.");
    	}
    	
    	System.out.println();
    	
    	pv.setPointA(a.getPointByIndex(a.getNumPoints() - 2));
    	pv.setPointB(pa);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pc && pv.getPointB() == c.getPointByIndex(1)) {
    		System.out.println("Train from A goes to C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from A does not go to C.");
    	}
    	
    	pv.setPointA(b.getPointByIndex(1));
    	pv.setPointB(pb);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from B goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from B does not go to A.");
    	}
    	
    	pv.setPointA(c.getPointByIndex(1));
    	pv.setPointB(pc);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from C goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from C does not go to A.");
    	}
    	
    	System.out.println();
    	
    }
    
    public static void testCouplingLink() {
    	System.out.println("--------------");
        System.out.println("TEST COUPLING LINK");
        System.out.println("--------------");

        Track track = new Track();

        // Create two straight paths
        Path a = track.addPathType(PathTypes.westToEast, 3, 3);
        Path b = track.addPathType(PathTypes.westToEast, 4, 3);

        Point pa = a.getHighpoint();
        Point pb = b.getLowpoint();

        CouplingLink link = new CouplingLink(pa, pb);

        // Attach link to both paths
        a.setHighEndpointLink(link);
        b.setLowEndpointLink(link);

        // Test getNumPaths
        System.out.println("Link has " + link.getNumPaths() + " paths. Expected 2.");
        System.out.println();

        // Test getConnectedPoint
        Point aConnected = link.getConnectedPoint(pa);
        Point bConnected = link.getConnectedPoint(pb);

        if (aConnected == pb) {
            System.out.println("Point A is connected to point B AS EXPECTED.");
        } else {
            System.out.println("FAIL: Point A is not connected to point B.");
        }

        if (bConnected == pa) {
            System.out.println("Point B is connected to point A AS EXPECTED.");
        } else {
            System.out.println("FAIL: Point B is not connected to point A.");
        }

        System.out.println();

        // Test shiftPoints from a → b
        Point beforeHigh = a.getPointByIndex(a.getNumPoints() - 2);
        PositionVector pv = new PositionVector();
        
        pv.setPointA(beforeHigh);
        pv.setPointB(pa);

        link.shiftPoints(pv);
        if (pv.getPointA() == pb && pv.getPointB() == b.getPointByIndex(1)) {
            System.out.println("Train from A goes to B AS EXPECTED.");
        } else {
            System.out.println("FAIL: Train from A does not go to B.");
        }

        // Test shiftPoints from b → a
        pv.setPointA(b.getPointByIndex(1));
        pv.setPointB(pb);

        link.shiftPoints(pv);
        if (pv.getPointA() == pa && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
            System.out.println("Train from B goes to A AS EXPECTED.");
        } else {
            System.out.println("FAIL: Train from B does not go to A.");
        }

        System.out.println();
    }

    public static void testDeadEndLink() {
        System.out.println("--------------");
        System.out.println("TEST DEAD END LINK");
        System.out.println("--------------");

        Track track = new Track();

        // Create a single path
        Path a = track.addPathType(PathTypes.westToEast, 3, 3);
        Point pa = a.getHighpoint();
        Point beforePa = a.getPointByIndex(a.getNumPoints() - 2);

        // Attach DeadEndLink
        DeadEndLink link = new DeadEndLink();
        a.setHighEndpointLink(link);

        // Test getNumPaths
        System.out.println("Link has " + link.getNumPaths() + " paths. Expected 1.");
        System.out.println();

        // Test getConnectedPoint
        Point result = link.getConnectedPoint(pa);
        if (result == null) {
            System.out.println("Connected point is null AS EXPECTED.");
        } else {
            System.out.println("FAIL: Connected point is not null.");
        }

        System.out.println();

        // Test shiftPoints
        PositionVector pv = new PositionVector();
        pv.setPointA(beforePa);
        pv.setPointB(pa);

        link.shiftPoints(pv);

        if (pv.getPointA() == beforePa && pv.getPointB() == pa) {
            System.out.println("shiftPoints did not change the position AS EXPECTED.");
        } else {
            System.out.println("FAIL: shiftPoints changed the position unexpectedly.");
        }

        System.out.println();
    }

    public static void testMultiFixedLink() {
    	System.out.println("--------------");
    	System.out.println("TEST MULTI FIXED LINK (5-WAY)");
    	System.out.println("--------------");
    	Track track = new Track();
    	
    	Path a = track.addPathType(PathTypes.curveWestToSouth, 2, 2);             	           
    	Path b = track.addPathType(PathTypes.curveWestToNorth, 2, 4);  	
    	Path c = track.addPathType(PathTypes.curveWestToNorth, 3, 2);   
    	Path d = track.addPathType(PathTypes.westToEast, 3, 3);
    	Path e = track.addPathType(PathTypes.curveWestToSouth, 3, 4);  
    	
    	// Create the link
    	Point pa = a.getHighpoint();
    	Point pb = b.getHighpoint();
    	Point pc = c.getLowpoint();
    	Point pd = d.getLowpoint();
    	Point pe = e.getLowpoint();
    	
    	PointPair[] connections = {new PointPair(pa, pe), 
    							   new PointPair(pb, pc), 
    							   new PointPair(pc, pb), 
    							   new PointPair(pd, pa), 
    							   new PointPair(pe, pa)};
    	
    	MultiFixedLink link = new MultiFixedLink(connections);
    	
    	a.setHighEndpointLink(link);
    	b.setHighEndpointLink(link);
    	c.setLowEndpointLink(link);
    	d.setLowEndpointLink(link);
    	e.setLowEndpointLink(link);
    	
    	//Test getNumPath
    	System.out.println("Link has " + link.getNumPaths() + " paths. Expected 5.");
    	System.out.println();
    	
    	Point aConnected = link.getConnectedPoint(pa);
    	Point bConnected = link.getConnectedPoint(pb);
    	Point cConnected = link.getConnectedPoint(pc);
    	Point dConnected = link.getConnectedPoint(pd);
    	Point eConnected = link.getConnectedPoint(pe);
    	
    	//Test getConnectedPoint
    	if (aConnected == pe) {
    		System.out.println("Point A is connected to point E AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point A is not connected to point E.");
    	}
    	
    	if (bConnected == pc) {
    		System.out.println("Point B is connected to point C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point B is not connected to point C.");
    	}
    	
    	if (cConnected == pb) {
    		System.out.println("Point C is connected to point B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point C is not connected to point B.");
    	}
    	
    	if (dConnected == pa) {
    		System.out.println("Point D is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point D is not connected to point A.");
    	}
    	if (eConnected == pa) {
    		System.out.println("Point E is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point E is not connected to point A.");
    	}
    	
    	System.out.println();
    	
    	Point beforeHigh = a.getPointByIndex(a.getNumPoints() - 2); // second-to-last point on path a
    	Point high = a.getHighpoint(); // the endpoint of path a

    	PositionVector pv = new PositionVector();
    	
    	pv.setPointA(beforeHigh);
    	pv.setPointB(high);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pe && pv.getPointB() == e.getPointByIndex(1)) {
    		System.out.println("Train from A goes to E AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from A does not go to E.");
    	}
    	
    	pv.setPointA(b.getPointByIndex(b.getNumPoints() - 2));
    	pv.setPointB(pb);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pc && pv.getPointB() == c.getPointByIndex(1)) {
    		System.out.println("Train from B goes to C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from B does not go to C.");
    	}
    	
    	pv.setPointA(c.getPointByIndex(1));
    	pv.setPointB(pc);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pb  && pv.getPointB() == b.getPointByIndex(b.getNumPoints() - 2)) {
    		System.out.println("Train from C goes to B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from C does not go to B.");
    	}
    	
    	pv.setPointA(d.getPointByIndex(1));
    	pv.setPointB(pd);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from D goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from D does not go to A.");
    	}
    	
    	pv.setPointA(e.getPointByIndex(1));
    	pv.setPointB(pe);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from E goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from E does not go to A.");
    	}
    	
    	System.out.println();
    }
    
    public static void testMultiSwitchLink() {
    	System.out.println("--------------");
    	System.out.println("TEST MULTI SWITCH LINK (5-WAY)");
    	System.out.println("--------------");
    	Track track = new Track();
    	
    	Path a = track.addPathType(PathTypes.curveWestToSouth, 2, 2);             	           
    	Path b = track.addPathType(PathTypes.curveWestToNorth, 2, 4);  	
    	Path c = track.addPathType(PathTypes.curveWestToNorth, 3, 2);   
    	Path d = track.addPathType(PathTypes.westToEast, 3, 3);
    	Path e = track.addPathType(PathTypes.curveWestToSouth, 3, 4);  
    	
    	// Create the link
    	Point pa = a.getHighpoint();
    	Point pb = b.getHighpoint();
    	Point pc = c.getLowpoint();
    	Point pd = d.getLowpoint();
    	Point pe = e.getLowpoint();
    	
    	PointPair[] connections = {new PointPair(pa, pe), 
    							   new PointPair(pb, pc), 
    							   new PointPair(pc, pb), 
    							   new PointPair(pd, pa), 
    							   new PointPair(pe, pa)};
    	
    	MultiSwitchLink link = new MultiSwitchLink(connections);
    	
    	a.setHighEndpointLink(link);
    	b.setHighEndpointLink(link);
    	c.setLowEndpointLink(link);
    	d.setLowEndpointLink(link);
    	e.setLowEndpointLink(link);
    	
    	//Test getNumPath
    	System.out.println("Link has " + link.getNumPaths() + " paths. Expected 5.");
    	System.out.println();
    	
    	System.out.println("TEST BEFORE SWITCHING ONE CONNECTION");
    	
    	Point aConnected = link.getConnectedPoint(pa);
    	Point bConnected = link.getConnectedPoint(pb);
    	Point cConnected = link.getConnectedPoint(pc);
    	Point dConnected = link.getConnectedPoint(pd);
    	Point eConnected = link.getConnectedPoint(pe);
    	
    	//Test getConnectedPoint
    	if (aConnected == pe) {
    		System.out.println("Point A is connected to point E AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point A is not connected to point E.");
    	}
    	
    	if (bConnected == pc) {
    		System.out.println("Point B is connected to point C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point B is not connected to point C.");
    	}
    	
    	if (cConnected == pb) {
    		System.out.println("Point C is connected to point B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point C is not connected to point B.");
    	}
    	
    	if (dConnected == pa) {
    		System.out.println("Point D is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point D is not connected to point A.");
    	}
    	if (eConnected == pa) {
    		System.out.println("Point E is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point E is not connected to point A.");
    	}
    	
    	System.out.println();
    	
    	Point beforeHigh = a.getPointByIndex(a.getNumPoints() - 2); // second-to-last point on path a
    	Point high = a.getHighpoint(); // the endpoint of path a

    	PositionVector pv = new PositionVector();
    	
    	pv.setPointA(beforeHigh);
    	pv.setPointB(high);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pe && pv.getPointB() == e.getPointByIndex(1)) {
    		System.out.println("Train from A goes to E AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from A does not go to E.");
    	}
    	
    	pv.setPointA(b.getPointByIndex(b.getNumPoints() - 2));
    	pv.setPointB(pb);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pc && pv.getPointB() == c.getPointByIndex(1)) {
    		System.out.println("Train from B goes to C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from B does not go to C.");
    	}
    	
    	pv.setPointA(c.getPointByIndex(1));
    	pv.setPointB(pc);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pb  && pv.getPointB() == b.getPointByIndex(b.getNumPoints() - 2)) {
    		System.out.println("Train from C goes to B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from C does not go to B.");
    	}
    	
    	pv.setPointA(d.getPointByIndex(1));
    	pv.setPointB(pd);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from D goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from D does not go to A.");
    	}
    	
    	pv.setPointA(e.getPointByIndex(1));
    	pv.setPointB(pe);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from E goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from E does not go to A.");
    	}
    	
    	System.out.println();
    	
    	System.out.println("TEST AFTER SWITCHING ONE CONNECTION (FROM D->A TO D->C)");
    	link.switchConnection(new PointPair(pd, pc), 3);
    	
    	aConnected = link.getConnectedPoint(pa);
        bConnected = link.getConnectedPoint(pb);
    	cConnected = link.getConnectedPoint(pc);
    	dConnected = link.getConnectedPoint(pd);
    	eConnected = link.getConnectedPoint(pe);
    	
    	//Test getConnectedPoint
    	if (aConnected == pe) {
    		System.out.println("Point A is connected to point E AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point A is not connected to point E.");
    	}
    	
    	if (bConnected == pc) {
    		System.out.println("Point B is connected to point C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point B is not connected to point C.");
    	}
    	
    	if (cConnected == pb) {
    		System.out.println("Point C is connected to point B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point C is not connected to point B.");
    	}
    	
    	if (dConnected == pc) {
    		System.out.println("Point D is connected to point C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point D is not connected to point C.");
    	}
    	if (eConnected == pa) {
    		System.out.println("Point E is connected to point A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Point E is not connected to point A.");
    	}
    	
    	System.out.println();
    	
    	pv.setPointA(beforeHigh);
    	pv.setPointB(high);

    	link.shiftPoints(pv);
    	if (pv.getPointA() == pe && pv.getPointB() == e.getPointByIndex(1)) {
    		System.out.println("Train from A goes to E AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from A does not go to E.");
    	}
    	
    	pv.setPointA(b.getPointByIndex(b.getNumPoints() - 2));
    	pv.setPointB(pb);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pc && pv.getPointB() == c.getPointByIndex(1)) {
    		System.out.println("Train from B goes to C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from B does not go to C.");
    	}
    	
    	pv.setPointA(c.getPointByIndex(1));
    	pv.setPointB(pc);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pb  && pv.getPointB() == b.getPointByIndex(b.getNumPoints() - 2)) {
    		System.out.println("Train from C goes to B AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from C does not go to B.");
    	}
    	
    	pv.setPointA(d.getPointByIndex(1));
    	pv.setPointB(pd);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pc  && pv.getPointB() == c.getPointByIndex(1)) {
    		System.out.println("Train from D goes to C AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from D does not go to C.");
    	}
    	
    	pv.setPointA(e.getPointByIndex(1));
    	pv.setPointB(pe);
    	
    	link.shiftPoints(pv);
    	if (pv.getPointA() == pa  && pv.getPointB() == a.getPointByIndex(a.getNumPoints() - 2)) {
    		System.out.println("Train from E goes to A AS EXPECTED.");
    	} else {
    		System.out.println("FAIL: Train from E does not go to A.");
    	}
    	
    	System.out.println();
    }
}
