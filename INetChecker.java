import java.io.IOException;
import java.net.Socket;

public class INetChecker implements Runnable {

	public static void main(String[] args) {
		/*
		 * The main() method defines the command line arguments feel free to add
		 * any CLA, but remember to add a switch case for the argument
		 */
		INetChecker tester = new INetChecker();
		if (args.length == 0) {
			System.out.println("Type java INetChecker --help for info \n"
					+ "To just run the program, Type java INetChecker --run");
		} else {
			switch (args[0]) {
			case "--help": {
				System.out
						.println("Help for INetChecker\n.\n.\n.\n"
								+ "Type java INetChecker --run to start the application.\n"
								+ "Type java INetChecker --help <ATTRIBUTE> for more help on the attribute\n"
								+ "Type java INetChecker --info for Info of the software.");
				break;
			}

			case "--run": {
				System.out
						.println("Notice: Please disable any system wide proxy setting like tor or UltraSurf\n"
								+ "or the software may not work properly and\n"
								+ "may take longer time to detect internet\n"
								+ "Checking you internet connection...");
				System.out
						.println("*********************************************************");
				if (tester.checkTimed(10)) {
					System.out.println("Your Internet is working! :D Enjoy!");
					Audio audio = new Audio();
					audio.playSound();
				}
				break;
			}
			case "--info": {
				System.out
						.println("This software is created by Ishaan and Siddharth.\n"
								+ "This software is Open Source and the source can be found at:\n"
								+ "http://www.guthub.com/ishaanbahal ");
				break;
			}

			default:
				System.out.println("Type java INetChecker --help for info");
			}
		}

	}

	static Socket google = null;
	Thread timer = null;
	int a;
	static boolean val = false;

	private boolean createConnections() {
		try {
			google = new Socket("173.194.36.18", 80);
		} catch (IOException IOE) {
			return false;

		}
		if (google.isConnected())
			return true;
		else
			return false;
	}

	public void print(String a, int val) throws WrongValException {
		// TODO Logging Function. Inherit and Override.Can be used to print
		// anything actually.
		switch (val) {
		case 1:
			System.out.println(a);
			break;

		case 2: // fill with some logging function to GUI.
			break;

		default:
			throw new WrongValException();
		}

	}

	public boolean checkTimed(int time) {
		// To keep checking connection timely
		timer = new Thread(this);
		a = time;
		timer.start();
		try {
			timer.join();
		} catch (InterruptedException e) {
			System.out.println("Interupted" + e.getLocalizedMessage());
		}
		return true;
	}

	public boolean checkOnce() {
		// To check only once
		if (createConnections()) {
			return true;
		} else
			return false;
	}

	@Override
	public void run() {

		while (!val) {
			System.out.println("\n\nAttempting to connect. Please wait");
			if (createConnections()) {
				val = true;
				System.out.println("\n\n***Successful Connections***");

				stop();

			} else {
				try {
					System.out
							.println("\nConnection unsuccessful, retrying in "
									+ a + " seconds");
					Thread.sleep(a * 1000);
					val = false;
				} catch (InterruptedException e) {
					System.out.println(e.getLocalizedMessage());
				}

			}
		}

	}

	public void stop() {
		if (timer.isAlive()) {
			try {
				if (google.isClosed())
					google.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO Exception: " + e.getLocalizedMessage());

			}
		}

	}

}
