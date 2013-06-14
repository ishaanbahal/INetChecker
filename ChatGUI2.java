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

public class ChatGUI2 extends Menu {

	JFrame MainFrame = new JFrame("Chat Client");
	static int val = 0;
	JPanel panel1 = new JPanel();

	JButton checkOnce = new JButton("Check Once");
	JButton checkTimed = new JButton("Continuous Check");
	JTextArea log = new JTextArea("Software Initialised.\n"
			+ "Please choose an option", 10, 20);

	public void go() {
		panel1.setBackground(Color.WHITE);
		panel1.add(checkOnce);
		panel1.add(checkTimed);
		log.setEditable(false);
		log.setLineWrap(true);
		MainFrame.setSize(400, 250);
		MainFrame.setResizable(false);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setVisible(true);
		MainFrame.getContentPane().add(BorderLayout.NORTH, bar);
		MainFrame.getContentPane().add(BorderLayout.CENTER, panel1);
		MainFrame.getContentPane().add(BorderLayout.SOUTH, log);

		// Method below is called from Menu Class to initialize the Menu B
		setFile();

		// Methods to fill the Menus
		addItem("About", help);
		addItem("Exit", file);

		// ActionListeners below.

		list.get(0).addActionListener(new helpClick());
		list.get(1).addActionListener(new exitClick());
		checkOnce.addActionListener(new CheckOnce());
		checkTimed.addActionListener(new CheckTimed());
	}

	/*
	 * The asshole main() method..... Sometimes i wonder, why did they create a
	 * fucking main method... just a damn run() or probably start() method would
	 * be better. But well, here it is.
	 */

	public static void main(String[] s) {
		ChatGUI2 gui = new ChatGUI2();
		gui.go();
	}

	// Inner Class for ActionListener New in File Menu.
	class helpClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog aboutFrame = new JDialog();
			aboutFrame.setTitle("About");
			aboutFrame.setVisible(true);
			aboutFrame.setSize(300, 150);
			aboutFrame.setResizable(false);
			aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			aboutFrame.setAlwaysOnTop(true);
			JLabel label = new JLabel(
					"<html><p><h4>This application has been developed by<br>"
							+ " Ishaan Bahal & Siddharth Jain<br>"
							+ "\n The Source Code for the application is open and can"
							+ " be found at <I><U><font color=\"Red\"><br>"
							+ "http://www.github.com/ishaanbahal</font></I></U><h3></p></html>");
			aboutFrame.add(label);

		}

	}

	// Inner class for ActionListener Exit in File Menu.
	class exitClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			MainFrame.dispose();
		}

	}

	class CheckOnce implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			INetChecker checker = new INetChecker();
			if (checker.checkOnce()) {
				if(log.getLineCount()>=8);
				log.append("\nConnection Successful!\n"
						+ "You can now enjoy your internet ");
			} else {
				log.append("\nSorry, Your internet is not working");
			}
		}

	}

	class CheckTimed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			INetChecker checker = new INetChecker();
			log.append("\nChecking you internet Connection\n"
					+ "Connection Check Rate 10s\n"
					+ "This method will keep running unless you close the program");
			if (checker.checkTimed(10)) {
				log.append("\n\nConnection Successful!\n"
						+ "You can now enjoy your internet ");
			}

		}

	}
}

abstract class Menu {
	public JMenuBar bar = new JMenuBar();
	public JMenu file = new JMenu("File");
	public JMenu help = new JMenu("Help");
	public ArrayList<JMenuItem> list = new ArrayList<JMenuItem>();
	private static int num = 0;

	public void addItem(String s, JMenu a) {

		list.add(num, new JMenuItem(s));
		a.add(list.get(num));
		num++;

	}

	public void setFile() {
		bar.add(file);
		bar.add(help);
	}

}
