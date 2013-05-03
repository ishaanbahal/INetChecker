import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Audio {
	
	public void playSound(){
	try {
		File file = new File("alarma.wav");
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.start();
		clip.drain();
		clip.stop();
		clip.close();
	}
	catch(IOException e){
		System.out.println("File not Found: " + e.getLocalizedMessage());
	}
	catch(UnsupportedAudioFileException u){
		System.out.println("Unsupported File Exception: " + u.getLocalizedMessage());
	}
	catch(LineUnavailableException e){
		System.out.println("Line Unavailabe Exception: " + e.getLocalizedMessage());
	}
	
	}
	public static void main(String[] args){
		Audio test = new Audio();
		test.playSound();
		
	}
}
