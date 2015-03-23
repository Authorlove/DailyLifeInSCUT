import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PersonView extends JPanel {
	TimeTable timeTable;
	private int peopleSize;
	private int originSize;
	private int err = 0;
	private int personId = -1;
	public boolean isEnd = false;
	int totalNum;
	private ArrayList<PersonModel> persons = new ArrayList<PersonModel>();
	private Timer timer;

	PersonView(TimeTable timeTable, int peopleSize, Timer timer) {
		this.timeTable = timeTable;
		this.peopleSize = peopleSize;
		originSize = peopleSize;
		this.timer = timer;
		totalNum = timeTable.numOfBoys + timeTable.numOfGirls;
		for (int i = 0; i < timeTable.numOfBoys; i++)
			persons.add(new PersonModel(timeTable.boysDorm, this.peopleSize));
		for (int i = 0; i < timeTable.numOfGirls; i++)
			persons.add(new PersonModel(timeTable.girlsDorm, this.peopleSize));
		this.setBounds(0, 0, 800, 620);
		this.setOpaque(false);
		this.timer.addActionListener(new TimerListener());
	}

	public void setPersonID(int id) {
		this.personId = id;
	}

	public void whenRainy() {
		if (peopleSize != originSize)
			return;
		peopleSize += 1;
		for (int i = 0; i < timeTable.numOfBoys + timeTable.numOfGirls; i++) {
			persons.get(i).peopleSize = peopleSize;
			persons.get(i).pace = peopleSize - 3;
		}
	}

	public void whenSunny() {
		if (peopleSize == originSize)
			return;
		peopleSize = originSize;
		for (int i = 0; i < totalNum; i++) {
			persons.get(i).peopleSize = peopleSize;
			persons.get(i).pace = peopleSize;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(timeTable.color);
		for (int i = 0; i < totalNum; i++) {
			PersonModel person = persons.get(i);
			if (!person.isPaint)
				continue;
			if (i == this.personId) {
				g.fillRect((int) (person.x), (int) person.y, 8, 8);
			} else {
				g.fillOval((int) (person.x), (int) person.y, peopleSize,
						peopleSize);
			}
		}
	}

	class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();
			if (FixedTimetable.curTime > FixedTimetable.END) {
				int i;
				for (i = 0; i < totalNum; i++) {
					if (persons.get(i).isPaint)
						break;
				}
				if (i == totalNum)
					isEnd = true;
			}
			// process get up time
			int dif0 = FixedTimetable.curTime - FixedTimetable.GET_UP;
			if (dif0 >= (0 - err) && dif0 <= 30 * FixedTimetable.MINUTE + err) {
				for (int i = 0; i < totalNum; i++)
					if (Math.abs((dif0 - persons.get(i).getupTime)) <= err) {
						persons.get(i).isPaint = true;
						persons.get(i).endPoint = persons.get(i).canteen;
						persons.get(i).initialize();
					}
			}
			// process eating time
			for (int i = 0; i < totalNum; i++) {
				if (persons.get(i).curPoint == persons.get(i).canteen) {
					int dif = FixedTimetable.curTime
							- persons.get(i).canteenTime;
					if (Math.abs((dif - persons.get(i).eatTime)) <= err) {
						if (FixedTimetable.curTime < FixedTimetable.CLASS1_S)
							persons.get(i).endPoint = timeTable.classRoom[0];
						else if (FixedTimetable.curTime < FixedTimetable.CLASS5_S) {
							if (Math.random() * 10 < 7)
								persons.get(i).endPoint = persons.get(i).dorm;
							else
								persons.get(i).endPoint = timeTable.classRoom[(int) (Math
										.random() * 20)
										% DataInfo.classroom.length];
						} else {
							if (Math.random() * 10 < 7)
								persons.get(i).endPoint = persons.get(i).dorm;
							else
								persons.get(i).endPoint = timeTable.classRoom[(int) (Math
										.random() * 20)
										% DataInfo.classroom.length];
						}
						persons.get(i).isPaint = true;
						persons.get(i).initialize();

					}
				}
			}
			// process class end time
			for (int i = 0; i < FixedTimetable.classTimeArray.length; i++) {

				int dif = FixedTimetable.curTime
						- FixedTimetable.classTimeArray[i];

				if (dif >= 0 - err && dif <= 5 * FixedTimetable.MINUTE + err) {

					for (int i1 = 0; i1 < totalNum; i1++)
						if (Math.abs(dif - persons.get(i1).classTime) <= err) {
							persons.get(i1).isPaint = true;
							if (i == 3 || i == 7) {
								persons.get(i1).endPoint = persons.get(i1).canteen;
							} else if (i == FixedTimetable.classTimeArray.length - 1)
								persons.get(i1).endPoint = persons.get(i1).dorm;
							else {
								persons.get(i1).endPoint = timeTable.classRoom[i + 1];
							}
							persons.get(i1).initialize();

							break;
						}
				}
			}
			// process the first two class time
			for (int i = 0; i < FixedTimetable.classStartTime.length; i++) {
				int dif = FixedTimetable.classStartTime[i]
						- FixedTimetable.curTime;
				if (dif >= 20 * FixedTimetable.MINUTE - err
						&& dif <= 30 * FixedTimetable.MINUTE + err) {
					for (int i1 = 0; i1 < totalNum; i1++) {
						if (Math.abs(dif - persons.get(i1).firstClass) <= err) {
							if (i == 0)
								persons.get(i1).endPoint = timeTable.classRoom[4];
							else
								persons.get(i1).endPoint = timeTable.classRoom[8];
						}
						persons.get(i1).isPaint = true;
						persons.get(i1).initialize();
					}
					break;
				}
			}
			for (int i = 0; i < DataInfo.paths.length; i++) {
				int size = DataInfo.paths[i].inStartPoint.size();
				if (size == 0)
					continue;
				int capacity = DataInfo.paths[i].getCapacity(peopleSize);
				if (size <= capacity) {
					while (DataInfo.paths[i].inStartPoint.size() != 0)
						DataInfo.paths[i].inStartPoint.remove().isUpdatePosition = true;
				} else {

					for (int j = 0; j < capacity; j++)
						DataInfo.paths[i].inStartPoint.remove().isUpdatePosition = true;

					int number = Math.min(
							DataInfo.paths[i].inStartPoint.size(), capacity);
					for (int m = 0; m < number; m++) {
						PersonModel person = DataInfo.paths[i].inStartPoint
								.remove();
						person.isUpdatePosition = true;
					}
				}
			}// end for loop
			for (int i = 0; i < totalNum; i++) {
				PersonModel person = persons.get(i);
				if (!person.isPaint)
					continue;
				if (person.isNextPoint()) {
					person.updatePoint();// let the one go to next path
					if (person.index == -1) {
						break;
					}
					int x = person.curPathIndex;
					DataInfo.paths[x].inStartPoint.offer(person);
					if (DataInfo.paths[x].inStartPoint.size() <= DataInfo.paths[x]
							.getCapacity(peopleSize)) {
						person.isUpdatePosition = true; // update its position
					} else {
						person.updateMinimumPath();// check the minimum path
						if (person.curPathIndex != x) {
							if (DataInfo.paths[person.curPathIndex].inStartPoint
									.size() <= DataInfo.paths[person.curPathIndex]
									.getCapacity(peopleSize)) {
								person.isUpdatePosition = false;

							} else {
								person.isUpdatePosition = true;
							}
							DataInfo.paths[x].inStartPoint.remove(person);
							DataInfo.paths[person.curPathIndex].inStartPoint
									.offer(person);
						} else {
							person.isUpdatePosition = false;
						}
					}
				}
				if (person.isUpdatePosition)
					person.updatePositon();
			}// end for loop
		}// end action performed
	}
}
