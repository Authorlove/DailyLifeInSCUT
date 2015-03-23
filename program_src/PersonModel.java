import java.awt.Point;
import java.util.ArrayList;
class PersonModel {
	public WeightedGraph<Point> graph;// the graph object
	public Point dorm;
	public Point canteen;
	public int peopleSize;
	public double x, y;// current position
	public Point curPoint, nextPoint, endPoint;// current/next/end point
	private double length, deltX, deltY;// pace
	public ArrayList<Point> path;// from end to source
	public ArrayList<WeightedEdge> edges = new ArrayList<WeightedEdge>();// edges  object																		
	int index;// path array's access index
	int curPathIndex;// current path's index
	static int subPathNum;// determine the number of sub path
	ArrayList<Point> subPoint;// the current path's sun starting point
	Point p;// one of the starting point
	double determine0, determine;// determine if pass the next point
	public boolean isUpdatePosition = true;// check if update position
    public boolean isPaint = false;
    public boolean isMonitor = false;
    int getupTime;
    int eatTime;
    int classTime;
    int firstClass;
    int canteenTime;
    public int pace;
	PersonModel(Point dorm,int peopleSize) {
		pace = peopleSize + 2;
		getupTime = (int)(Math.random()*30)*FixedTimetable.MINUTE;
		firstClass = (int)(20+(Math.random()*10))*FixedTimetable.MINUTE;
		eatTime = (20+(int)(Math.random()*10))*FixedTimetable.MINUTE;
		classTime = (int)(Math.random()*5)*FixedTimetable.MINUTE;
		this.dorm = dorm;
		curPoint = dorm;
		this.peopleSize = peopleSize;
		canteen = DataInfo.canteenEntrance[(int) (Math.random()*10%2)];
		setEdges();// Initialize edges
	}

	void initialize() {
		int endIndex = DataInfo.vertices.indexOf(endPoint);
		int sourceIndex = DataInfo.vertices.indexOf(curPoint);
		graph = new WeightedGraph<Point>(edges, DataInfo.vertices);
		if ( endIndex == sourceIndex){
			isPaint = false;
			return;
		}
		path = graph.getShortestPath(sourceIndex, endIndex).getPath(endIndex);
		index = path.size() - 2;
		nextPoint = path.get(index);
		curPathIndex = DataInfo.getPathIndex(curPoint, nextPoint);
		subPoint = DataInfo.paths[curPathIndex].subPoint(peopleSize);
		p = subPoint.get(subPathNum % subPoint.size());
		x = p.x;
		y = p.y;
		deltX = pace * (nextPoint.x - curPoint.x) / length;
		deltY = pace * (nextPoint.y - curPoint.y) / length;
		subPathNum++;
	}

	// change the position
	public void updatePositon() {
		x += deltX;
		y += deltY;
	}

	// if coming to the next point
	public boolean isNextPoint() {
		determine0 = (curPoint.y - nextPoint.y) * deltY
				+ (curPoint.x - nextPoint.x) * deltX;
		determine = (y - nextPoint.y) * deltY + (x - nextPoint.x) * deltX;
		if (determine0 * determine < 0)
			return true;
		else
			return false;
	}

	// change the current point and next point when going to next path
	public void updatePoint() {
		curPoint = nextPoint;
		index--;
		if (index == -1){
			isPaint = false;
			if(curPoint==canteen)
			canteenTime = FixedTimetable.curTime;
			return;
		}
		nextPoint = path.get(index);
		curPathIndex = DataInfo.getPathIndex(curPoint, nextPoint);
		
//		System.out.println("current path index"+" "+curPathIndex);
//		System.out.println("path's size"+" "+DataInfo.paths.length);
		subPoint = DataInfo.paths[curPathIndex].subPoint(2);
		p = subPoint.get(subPathNum % subPoint.size());
		x = p.x;
		y = p.y;
		length = getPathLength(curPoint, nextPoint);
		deltX = peopleSize * (nextPoint.x - curPoint.x) / length;
		deltY = peopleSize * (nextPoint.y - curPoint.y) / length;
		subPathNum+=2;
	}

	// initialize the edges
	private void setEdges() {
		for (int i = 0; i < DataInfo.paths.length; ++i) {
			int u = DataInfo.vertices.indexOf(DataInfo.paths[i]
					.getStartingPoint());
			int v = DataInfo.vertices.indexOf(DataInfo.paths[i]
					.getEndingPoint());
			int w = (int) DataInfo.paths[i].getLenth();
			edges.add(new WeightedEdge(u, v, w));
		}
	}

	// when the people are waiting for take next path, add the weight of next
	// path and update the graph
	public void updateMinimumPath() {
		int index = DataInfo.vertices.indexOf(curPoint);
		WeightedEdge[] edge = new WeightedEdge[graph.queues.get(index).size()];
		int i = 0;
		while (graph.queues.get(index).size() != 0) {
			edge[i] = graph.queues.get(index).poll();
			Paths path = DataInfo.paths[edges.indexOf(edge[i])];
			edge[i].addWeight(path.inStartPoint.size() / path.getCapacity(peopleSize)
					+ 1);
			i++;
		}
		for (int i1 = 0; i1 < edge.length; i1++)
			graph.queues.get(index).offer(edge[i1]);
		initialize();
	}

	// get path's length
	private double getPathLength(Point startPoint, Point nextPoint) {
		return Math.sqrt(Math.pow(nextPoint.x - startPoint.x, 2)
				+ Math.pow(nextPoint.y - startPoint.y, 2));
	}
}