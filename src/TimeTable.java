import java.awt.Color;
import java.awt.Point;

public class TimeTable{
	public Point boysDorm;
	public Point girlsDorm;
	public Point classRoom[] = new Point[DataInfo.classroom.length];
	public Color color;
	public int numOfGirls, numOfBoys;
	static int i;

	public TimeTable setRandomTimetable(){
		Color[] colorArray = { Color.RED, Color.ORANGE, Color.WHITE, Color.YELLOW,
				Color.GREEN };
		numOfGirls = 200;
		numOfBoys = 200;
		boysDorm = DataInfo.entry[(int) (Math.random()*10)%DataInfo.entry.length];
		girlsDorm = DataInfo.entry[(int) (Math.random()*10)%DataInfo.entry.length];
		for(int i=0;i<DataInfo.classroom.length;i++){
			classRoom[i] = DataInfo.classroom[(int)(Math.random()*20)%DataInfo.classroom.length];
		}
		color = colorArray[(i++)%5];
		return this;
	}
}
