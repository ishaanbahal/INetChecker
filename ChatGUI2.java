import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ChatGUI2  extends Menu {
	
	JFrame MainFrame = new JFrame("Chat Client");
	static int val = 0;
	JPanel panel1 = new JPanel();
	JButton checkOnce = new JButton("Check Once");
	JButton check = new JButton("Continuous Check");
	JTextArea log = new JTextArea("Log");
	public void go(){
		log.setSize(350, 200);
		panel1.add(checkOnce);
		panel1.add(check);
		//panel1.add(log);
		MainFrame.setSize(400, 300);
		MainFrame.setResizable(false);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setVisible(true);
		MainFrame.add(BorderLayout.NORTH, bar);
		MainFrame.add(BorderLayout.CENTER, panel1);
		
		//Method below is called from Menu Class to initialize the Menu B
		setFile();
		
		//Methods to fill the Menus
		addItem("About", help);
		addItem("Exit", file);
		
		//ActionListeners below.
		
		list.get(0).addActionListener(new helpClick());
		list.get(1).addActionListener(new exitClick());
		checkOnce.addActionListener(new CheckOnce());
		
	}
		
	/*The asshole main() method..... Sometimes i wonder, 
	 * why did they create a fucking main method...
	 * just a damn run() or probably start() method
	 * would be better. But well, here it is.*/
	
	
	public static void main(String[] s){
		ChatGUI2 gui = new ChatGUI2();
		gui.go();
	}
	//Inner Class for ActionListener New in File Menu.
	class helpClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog aboutFrame = new JDialog();
			aboutFrame.setTitle("About");
			aboutFrame.setVisible(true);
			aboutFrame.setSize(300, 150);
			aboutFrame.setResizable(false);
			aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			aboutFrame.setAlwaysOnTop(true);
			JLabel label = new JLabel("<html><p><h4>This application has been developed by<br>" +
					" Ishaan Bahal & Siddharth Jain<br>" +
					"\n The Source Code for the application is open and can" +
					" be found at <I><U><font color=\"Red\"><br>" +
					"http://www.github.com/ishaanbahal</font></I></U><h3></p></html>");
			aboutFrame.add(label);
			
		}
		
	}
	//Inner class for ActionListener Exit in File Menu.
	class exitClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MainFrame.dispose();
		}
		
	}
	class CheckOnce implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			INetChecker checker = new INetChecker();
			if(checker.checkOnce()){
				panel1.setBackground(new Color(0,40,154));
			}
			else {
				panel1.setBackground(new Color(201,0,0));
			}
		}
		
	}
	class CheckTimed implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			INetChecker checker = new INetChecker();
			if(checker.checkTimed(10)){
				panel1.setBackground(new Color(0,40,154));
			}
			
		}
		
	}
}

abstract class Menu{
	public JMenuBar bar = new JMenuBar();
	public JMenu file = new JMenu("File");
	public JMenu help = new JMenu("Help");
	public ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
	private static int num = 0;
	
	public void addItem(String s, JMenu a){
		
		list.add(num,new JMenuItem(s));
		a.add(list.get(num));
		num++;
		
	}
	
	public void setFile(){
		bar.add(file);
		bar.add(help);
	}
	
}
