import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Paths {
	// private variables recording the starting point, ending point and also the
	// width
	// of the paths
	private Point startingPoint;
	private Point endingPoint;
	private int width;
	public Queue<PersonModel> inStartPoint = new LinkedList<PersonModel>();

	Paths(Point startingPoint, Point endingPoint, int width) {
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.width = width;

	}

	public ArrayList<Point> subPoint(int areaOnePerson) {
		ArrayList<Point> subPoint = new ArrayList<Point>();
		double length = getLenth();
		double deltX = (areaOnePerson+1) * (endingPoint.x - startingPoint.x)
				/ length;
		double deltY = (areaOnePerson+1) * (endingPoint.y - startingPoint.y)
				/ length;
		subPoint.add(startingPoint);
		for (int i = 1; i < getCapacity(areaOnePerson) / 2; i++) {
			subPoint.add(new Point((int) (startingPoint.x + i * deltY),
					(int) (startingPoint.y - i * deltX)));
			subPoint.add(new Point((int) (startingPoint.x - i * deltY),
					(int) (startingPoint.y + i * deltX)));
		}
		return subPoint;
	}

	public Point getStartingPoint() {
		return this.startingPoint;
	}

	public Point getEndingPoint() {
		return this.endingPoint;
	}

	public int getWidth() {
		return this.width;
	}

	// public method getLenth() returns the length of the path
	public double getLenth() {
		return Math.sqrt(Math.pow(endingPoint.x - startingPoint.x, 2)
				+ Math.pow(endingPoint.y - startingPoint.y, 2));
	}

	public int getCapacity(int areaOnePerson) {
		return width / areaOnePerson;
	}

}
