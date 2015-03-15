import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

class FixedTimetable extends JPanel {
	/**
	 * store fixed timetable to stimulate one day
	 */
	public int timeInterval;
	public static int curTime;// current time
	final static int HOUR = 3600; // the simulated hour
	final static int MINUTE = 60; // the simulated minute
	final static int SECOND = 1; // the simulated second
	final static int GET_UP = 7 * HOUR + 30 * MINUTE;// the time to start to stimulation
	final static int CLASS1_S = 8*HOUR + 50*MINUTE;
	final static int CLASS1 = 9 * HOUR + 35 * MINUTE;// class 1 finish time
	final static int CLASS2 = 10 * HOUR + 25 * MINUTE;// class 2 finish time
	final static int CLASS3 = 11 * HOUR + 20 * MINUTE;// class 3 finish time
	final static int CLASS4 = 12 * HOUR + 15 * MINUTE;// the time for lunch
	
	final static int CLASS5_S = 14*HOUR;
	final static int CLASS5 = 14 * HOUR + 45 * MINUTE;//class 5 finish time
	final static int CLASS6 = 15 * HOUR + 35 * MINUTE;// class 6 finish time
	final static int CLASS7 = 16 * HOUR + 30 * MINUTE;// class 7 finish time
	final static int CLASS8 = 17 * HOUR + 20 * MINUTE;//class 8 finish time
	final static int CLASS9_S = 19 * HOUR;
	
	final static int END = 21 * HOUR + 30 * MINUTE;// the time to stop the stimulation
	public static Integer[] classStartTime = {CLASS5_S,CLASS9_S};
	public static Integer[] classTimeArray ={CLASS1,CLASS2,CLASS3,CLASS4,CLASS5,CLASS6,CLASS7,CLASS8,END};
	

	
	public String curTimeString = " ";
	private Timer timer;
	int hour, minute, second;


	FixedTimetable(Timer timer) {
		this.setOpaque(false);
		setSize(800, 250);
		curTime = GET_UP;
		this.timer = timer;
		hour = curTime / HOUR;
		minute = curTime % HOUR / MINUTE;
		second = curTime % MINUTE;
		curTimeString = Integer.toString(hour) + " :"
				+ Integer.toString(minute) + " :"
				+ Integer.toString(second);
		timer.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				curTime += SECOND;
				hour = curTime / HOUR;
				minute = curTime % HOUR / MINUTE;
				second = curTime % MINUTE;
				curTimeString = Integer.toString(hour) + " :"
						+ Integer.toString(minute) + " :"
						+ Integer.toString(second);

				repaint();
			}
		});
	}

	// paint the clock
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int clockRadius = 40;
		int xCenter = 595;
		int yCenter = 75;
		// draw the 3, 6, 9, 12 on the clock face
		g.setColor(Color.black);
		g.drawOval(xCenter - clockRadius, yCenter - clockRadius,
				2 * clockRadius, 2 * clockRadius);
		g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
		g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
		g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
		g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);
		// draw the second hand
		int sLength = (int) (clockRadius * 0.8);
		int xSecond = (int) (xCenter + sLength
				* Math.sin(second * (2 * Math.PI / 60)));
		int ySecond = (int) (yCenter - sLength
				* Math.cos(second * (2 * Math.PI / 60)));
		g.setColor(Color.red);
		g.drawLine(xCenter, yCenter, xSecond, ySecond);
		// draw the minute hand
		int mLength = (int) (clockRadius * 0.65);
		int xMinute = (int) (xCenter + mLength
				* Math.sin(minute * (2 * Math.PI / 60)));
		int yMinute = (int) (yCenter - mLength
				* Math.cos(minute * (2 * Math.PI / 60)));
		g.setColor(Color.blue);
		g.drawLine(xCenter, yCenter, xMinute, yMinute);
		// draw the hour hand
		int hLength = (int) (clockRadius * 0.5);
		int xHour = (int) (xCenter + hLength
				* Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		int yHour = (int) (yCenter - hLength
				* Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		g.setColor(Color.green);
		g.drawLine(xCenter, yCenter, xHour, yHour);
		g.setColor(Color.black);

		g.drawString(curTimeString, xCenter - 20, yCenter * 2 - 10);
	}
}
