import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SetClassForm extends JFrame {
	private JRadioButton[] jRadioButton;
		Color[] color = { Color.RED, Color.ORANGE, Color.WHITE, Color.YELLOW,
			Color.GREEN };
	String[] colorName = { "Red", "Orange", "White", "Yelow", "Green" };
	public TimeTable timeTable;
	JTextField numOfGirls = new JTextField(4);
	JTextField numOfBoys = new JTextField(4);
	JPanel j1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
	JPanel j2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
	JPanel j3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
	JPanel j4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
	JPanel j5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
	JPanel j6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
	JPanel j7 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
	JPanel j8 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
	JPanel j10 = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));// class number
	JPanel j9 = new JPanel();
	JButton ok = new JButton("   OK   ");
	JButton cancel = new JButton("Cancel");
	JLabel classNumber=new JLabel("The number of class you add is: "+Form.timetableArray.size());
	String[] dor = { "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9",
			"C10", "C11", "C12", "C13", "C14", "C15", "C16", "C17" };
	String[] room = { "No Lesson", "A1", "A2", "A3", "A4", "Gym",
			"Tennis Court", "Swimming Pool", "Basketball Court1",
			"Basketball Court2", "Football Court" };
	JComboBox<String> dorItem1 = new JComboBox<String>(dor);
	JComboBox<String> dorItem2 = new JComboBox<String>(dor);
	ArrayList<JComboBox<String>> classroom = new ArrayList<JComboBox<String>>();

	SetClassForm() {
		for (int i = 0; i < 9; i++) {
			classroom.add(new JComboBox<String>(room));
		}
		timeTable = new TimeTable();
		jRadioButton = new JRadioButton[5];
		for (int i = 0; i < jRadioButton.length; i++)
			jRadioButton[i] = new JRadioButton(colorName[i]);
		j1.add(new JLabel("Boys:   Number  "));
		j1.add(numOfBoys);
		j1.add(new JLabel("   Dormitory:    "));
		j1.add(dorItem1);
		j1.add(new JLabel("   Girls:   Number "));
		j1.add(numOfGirls);
		j1.add(new JLabel("   Dormitory:    "));
		j1.add(dorItem2);
		j2.add(new JLabel("Color: "));
		for (int i = 0; i < jRadioButton.length; i++) {
			j2.add(jRadioButton[i]);
		}
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < jRadioButton.length; i++) {
			group.add(jRadioButton[i]);
		}
		int j = 0;
		j4.add(new JLabel("Lesson-one    (8:50-9:35)      Classroom   :"));
		j4.add(classroom.get(j++));
		j4.add(new JLabel("Lesson-two    (9:40-10:25)     Classroom :"));
		j4.add(classroom.get(j++));
		j4.add(new JLabel("Lesson-three  (10:40-11:25)  Classroom :"));
		j4.add(classroom.get(j++));
		j4.add(new JLabel("Lesson-four    (11:30-12:15)  Classroom :"));
		j4.add(classroom.get(j++));

		j6.add(new JLabel("Lesson-five    (14:00-14:45)   Classroom :"));
		j6.add(classroom.get(j++));
		j6.add(new JLabel("Lesson-six     (14:50-15:35)   Classroom :"));
		j6.add(classroom.get(j++));
		j6.add(new JLabel("Lesson-seven (15:45-16:30) Classroom :"));
		j6.add(classroom.get(j++));
		j6.add(new JLabel("Lesson-eight  (16:35-17:20)   Classroom :"));
		j6.add(classroom.get(j++));

		j8.add(new JLabel("Lesson-evening(19:00-21:30)Classroom :"));
		j8.add(classroom.get(j++));
		j10.add(classNumber);
		j9.add(ok);
		j9.add(cancel);

		j9.add(ok);
		j9.add(cancel);
		// Buttons
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				while (!numOfBoys.getText().toString().matches("[0-9]+")) {
					String input = JOptionPane.showInputDialog(null,
							"Error! the number of boys is illegal!",
							"Reput the boys' number here:",
							JOptionPane.WARNING_MESSAGE);
					numOfBoys.setText(input);
				}

				while (!numOfGirls.getText().toString().matches("[0-9]+")) {
					String input = JOptionPane.showInputDialog(null,
							"Error! the number of girls is illegal!",
							"Reput the boys' number here:",
							JOptionPane.WARNING_MESSAGE);
					numOfGirls.setText(input);
				}
				timeTable.numOfBoys = Integer.parseInt(numOfBoys.getText()
						.toString());
				timeTable.numOfGirls = Integer.parseInt(numOfGirls.getText()
						.toString());

				timeTable.boysDorm = DataInfo.entry[dorItem1.getSelectedIndex()];
				timeTable.girlsDorm = DataInfo.entry[dorItem2
						.getSelectedIndex()];

				for (int i = 0; i < jRadioButton.length; i++) {
					if (jRadioButton[i].isSelected())
						timeTable.color = color[i];
				}
				// j class number
				// i classroom
				for (int j = 0; j < classroom.size(); j++) {
					int i = classroom.get(j).getSelectedIndex();
					if (i == 0) {
						timeTable.classRoom[j] = DataInfo.classroom[(int) (1 + Math
								.random() * 10) % DataInfo.classroom.length];

					} else if (i < 5)
						timeTable.classRoom[j] = DataInfo.entry_A[i - 1];
					else if (i == 5)
						timeTable.classRoom[j] = DataInfo.gymEntry;
					else if (i == 6)
						timeTable.classRoom[j] = DataInfo.tennisCourtEntry;
					else if (i == 7)
						timeTable.classRoom[j] = DataInfo.swimmingPoolEntry;
					else if (i == 8)
						timeTable.classRoom[j] = DataInfo.basketballCourtEntry[0];
					else if (i == 9)
						timeTable.classRoom[j] = DataInfo.basketballCourtEntry[1];
					else if (i == 10)
						timeTable.classRoom[j] = DataInfo.footballCourtEntry;
				}
				dispose();
			}
		});
		setLayout(new GridLayout(10, 1, 0, 0));
		add(j1);
		add(j2);
		add(j3);
		add(j4);
		add(j6);
		add(j8);
		add(j9);
		add(j10);
	}
}
