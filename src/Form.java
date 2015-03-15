import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Form extends JFrame {
	private JMenu start = new JMenu("Start");
	private JMenu stop = new JMenu("Stop");
	private JMenu weather = new JMenu("Weather");
	private JMenuItem w1 = new JMenuItem("Sunny Day");
	private JMenuItem w2 = new JMenuItem("Rainy Day");
	private JMenu setClass = new JMenu("Class");
	private JMenu setSpeed=new JMenu("Accelerate");
	private JMenuItem X1=new JMenuItem("X1");
	private JMenuItem X10=new JMenuItem("X10");
	private JMenuItem X100=new JMenuItem("X100");
	private JMenuItem X1000=new JMenuItem("X1000");
	private JMenuItem newClass = new JMenuItem("Add class");
	private JMenuItem defaultClass = new JMenuItem("Default class");
	private JMenu exit = new JMenu("Exit");
	private JMenuBar jbar = new JMenuBar();
	private JMenu monitor =new JMenu("Monitor");
	public Map m = new Map();
	private Timer timer = new Timer(1000, null);
	private FixedTimetable fixedTimetable;
	public JLayeredPane layerdPane = new JLayeredPane();
	static ArrayList<TimeTable> timetableArray = new ArrayList<TimeTable>();
	private ArrayList<TimeTable> timetableArrayD = new ArrayList<TimeTable>();
	private ArrayList<PersonView> classArray = new ArrayList<PersonView>();

	public Form() {
		// initialize
		DataInfo.setVerticesAndPaths();
		timer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(FixedTimetable.curTime>FixedTimetable.END){
				int i=0;
				for(;i<classArray.size();i++){
					if(!classArray.get(i).isEnd)
						break;
				}
				if(i==classArray.size()){
					start.setEnabled(false);
					timer.stop();
					FixedTimetable.curTime = FixedTimetable.GET_UP;
					JOptionPane.showMessageDialog(null, "Simulation is finished!");
				}
			}
			}
			
		});
		fixedTimetable = new FixedTimetable(timer);
		
		setClass.setMnemonic(KeyEvent.VK_C);
		weather.setMnemonic(KeyEvent.VK_T);
		
		w1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		
		w2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				ActionEvent.CTRL_MASK));
	

       setSpeed.add(X1);
       setSpeed.add(X10);
       setSpeed.add(X100);
       setSpeed.add(X1000);
 
       setSpeed.setMnemonic(KeyEvent.VK_R);
       X1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.CTRL_MASK));
       X10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.CTRL_MASK));
       X100.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
				ActionEvent.CTRL_MASK));
       X1000.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
				ActionEvent.CTRL_MASK));

		weather.add(w1);
		
		weather.add(w2);

		newClass.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		defaultClass.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				ActionEvent.CTRL_MASK));

		setClass.add(newClass);
		setClass.add(defaultClass);
		jbar.add(setClass);
		jbar.add(weather);
		jbar.add(setSpeed);
		jbar.add(monitor);
		jbar.add(start);
		jbar.add(stop);
		jbar.add(exit);
		setJMenuBar(jbar);
		setTitle("SCUT Student Daily Life");
		layerdPane = getLayeredPane();
		layerdPane.add(m, new Integer(100));
		layerdPane.add(fixedTimetable, new Integer(200));
        monitor.setEnabled(false);
        start.setEnabled(false);
		//set speed
		X1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.setDelay(1000);
			}
		});
		X10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.setDelay(100);		
			}
		});
		X100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.setDelay(10);		
			}
		});
		X1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.setDelay(1);
			}
		});
		// set the weather is sunny
		w1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < classArray.size(); i++)
					classArray.get(i).whenRainy();
			}
		});
		// set the weather is rainy
		w2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < classArray.size(); i++)
					classArray.get(i).whenRainy();
			}
		});
		// add a class
		newClass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SetClassForm p = new SetClassForm();
				p.setTitle("Add class");
				p.setSize(750, 520);
				p.setLocationRelativeTo(null);
				p.setVisible(true);
				timetableArrayD.clear();
				timetableArray.add(p.timeTable);
				start.setEnabled(true);
			}
		});
		// set default five classes
		defaultClass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timetableArray.clear();
				for (int i = 0; i < 5; i++)
					timetableArrayD.add(new TimeTable().setRandomTimetable());
				start.setEnabled(true);
				
			}
		});
		monitor.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(timetableArray.size()!=0){
					Monitor p = new Monitor(timetableArray.size(),classArray);
					p.setTitle("Monitor a student");
					p.setLocationRelativeTo(null);
					p.setVisible(true);
					classArray.get(p.getClassIndex()).setPersonID(p.getPersonIndex());
					}
				else{
					Monitor p = new Monitor(timetableArrayD.size(),classArray);
					p.setTitle("Monitor a student");
					p.setLocationRelativeTo(null);
					p.setVisible(true);
					classArray.get(p.getClassIndex()).setPersonID(p.getPersonIndex());
				}		
			}
		});
		// start simulation
		start.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(timetableArray.size()!=0)
					for (int i = 0; i < timetableArray.size(); i++) {
						classArray.add(new PersonView(timetableArray.get(i), 3,timer));
						layerdPane.add(classArray.get(i), new Integer(300));
					}
				else
				   for (int i = 0; i < timetableArrayD.size(); i++) {
						classArray.add(new PersonView(timetableArrayD.get(i), 3,timer));
						layerdPane.add(classArray.get(i), new Integer(300));
					}				
				    timer.start();
					setClass.setEnabled(false);
					monitor.setEnabled(true);
			}
		}
		);
		stop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				timer.stop();
			}
		});

		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
	}

	public static void main(String[] args) {
		Form frm = new Form();
		frm.setSize(800, 620);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
