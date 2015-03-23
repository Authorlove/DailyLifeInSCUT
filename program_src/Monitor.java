import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class Monitor extends JFrame{
	
	private JTextField classindex=new JTextField(10);
	private JTextField personindex=new JTextField(10);
	private JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,2,0));
	private JPanel jp2=new JPanel(new FlowLayout(FlowLayout.LEFT,2,0));
	private JPanel jp3=new JPanel(new FlowLayout(FlowLayout.LEFT,2,0));
	private JPanel jp4=new JPanel(new FlowLayout(FlowLayout.LEFT,2,0));
	private JPanel jp5=new JPanel(new FlowLayout(50,50,2));
	private JButton bt1=new JButton("Confirm");
	private JButton bt2=new JButton("Cancel");
	private int ClassIndex;
	private int PersonIndex;
	private String[] ClassIndexArray;
	private JComboBox<String> jcb;
	private ArrayList<PersonView> classArray;
	/**
	 * @param args
	 */
	Monitor(int ClassIn,final ArrayList<PersonView> classArray){
		ClassIndexArray=new String[ClassIn];
		this.classArray=classArray;
		for(int i=0;i<ClassIndexArray.length;i++){
			ClassIndexArray[i]=i+"";
		}
		jcb=new JComboBox<String>(ClassIndexArray);
		jp5.add(bt1);
		jp5.add(bt2);
		jp1.add(new JLabel("Class Index: "));
		jp1.add(jcb);
		jp2.add(new JLabel("Person Index: "));
		jp2.add(personindex);
		add(jp1);
		add(jp2);
		add(jp5);
		this.setSize(300, 200);
		this.setLayout(new GridLayout(3,1,0,0));
		bt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Integer.parseInt(personindex.getText())>=0 && Integer.parseInt(personindex.getText())<classArray.get(getClassIndex()).totalNum){
					PersonIndex=Integer.parseInt(personindex.getText());
				}
				dispose();
			}
			
		});
		bt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
	}
	
	public int getClassIndex(){
		return this.jcb.getSelectedIndex();
	}
	
	public int getPersonIndex(){
		return this.PersonIndex;
	}

}
