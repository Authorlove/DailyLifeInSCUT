import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class Map extends JPanel {
	private static final long serialVersionUID = 1L;

	Map() {
		this.setBounds(0, 0, 800, 620);
		this.setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		// use the BuildRoad method to draw the paths
		// pass the g2d and pathArray for parameter
		for (int i = 0; i < DataInfo.pathArray.length; i++) {
			BuildRoad(g2d, DataInfo.pathArray[i]);
		}

		// use the Graphics object g for drawing the buidings
		g.setColor(Color.blue);
		for (int i = 0; i < DataInfo.dorm_C.length; i++) {
			g.fillRect(DataInfo.dorm_C[i].x, DataInfo.dorm_C[i].y,
					DataInfo.dorm_C[i].width, DataInfo.dorm_C[i].height);
		}

		g.setColor(Color.green);
		for (int i = 0; i < DataInfo.teachingBuilding_A.length; i++) {
			g.fillRect(DataInfo.teachingBuilding_A[i].x,
					DataInfo.teachingBuilding_A[i].y,
					DataInfo.teachingBuilding_A[i].width,
					DataInfo.teachingBuilding_A[i].height);
		}

		g.setColor(Color.red);
		g.fillRect(DataInfo.canteen2.x, DataInfo.canteen2.y,
				DataInfo.canteen2.width, DataInfo.canteen2.height);
		g.fillArc(DataInfo.canteen1.x, DataInfo.canteen1.y,
				DataInfo.canteen1.width, DataInfo.canteen1.height, 180, 90);

		g.setColor(Color.orange);
		g.fillRect(DataInfo.library.x, DataInfo.library.y,
				DataInfo.library.width, DataInfo.library.height);

		g.setColor(Color.lightGray);
		for (int i = 0; i < DataInfo.basketballCourt.length; i++) {
			g.fillRect(DataInfo.basketballCourt[i].x,
					DataInfo.basketballCourt[i].y,
					DataInfo.basketballCourt[i].width,
					DataInfo.basketballCourt[i].height);
		}

		g.setColor(Color.gray);
		g.fillRect(DataInfo.tennisCourt.x, DataInfo.tennisCourt.y,
				DataInfo.tennisCourt.width, DataInfo.tennisCourt.height);

		g.setColor(Color.magenta);
		g.fillRect(DataInfo.footballCourt.x, DataInfo.footballCourt.y,
				DataInfo.footballCourt.width, DataInfo.footballCourt.height);

		g.setColor(Color.pink);
		g.fillRect(DataInfo.gym.x, DataInfo.gym.y, DataInfo.gym.width,
				DataInfo.gym.height);

		g.setColor(Color.cyan);
		g.fillRect(DataInfo.swimmingPool.x, DataInfo.swimmingPool.y,
				DataInfo.swimmingPool.width, DataInfo.swimmingPool.height);
		// draw building name;
				for (int i = 0; i < 31; i++) {
					if (i < 17)
						g.setColor(Color.BLUE);
					if (i >= 17)
						g.setColor(Color.BLACK);
					g.drawString(DataInfo.buildingName[i], DataInfo.name_x[i],
							DataInfo.name_y[i]);
				}
	}

	public void BuildRoad(Graphics2D g2d, Paths path) {
		g2d.setStroke(new BasicStroke(path.getWidth()));// Set the width of the
														// road
		g2d.drawLine(path.getStartingPoint().x, path.getStartingPoint().y,
				path.getEndingPoint().x, path.getEndingPoint().y);
	}

}
