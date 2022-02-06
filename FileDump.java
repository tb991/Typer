import java.awt.Robot;
import java.util.*;  
import java.lang.*;
import java.io.File;

class FileDump{
	static Robot r;
	static boolean lowercaseonly = true;
	static String allowed = "qwertyuiopasdfghjklzxcvbnm,. ";
	public static void main(String[] args){
		//wait(5);
		//type("This was written from a Java program, it now supports commas, full stops and upper case.\n");
		readFile("kjv.txt");
	}
	public static void press(char key){
		int k;
		boolean permitted = allowed.contains(String.valueOf(Character.toLowerCase(key)));
		if (Character.isUpperCase(key)){
			k = (int)key;
		}
		else{
			k = (int)key-32;
		}
		
		if (key==' '){
			k = 32;
		}
		if (key=='\n'){
			k = 10;
		}
		if (key=='.'){
			k = 110;
		}
		if (key==','){
			k = 44;
		}
		if (!permitted){
			k = 110; // put a full stop instead of any disallowed character
		}
		try{		
			r = new Robot();
			if (Character.isUpperCase(key)){
				r.keyPress(16); //shift
			}
			mwait(2);
			r.keyPress(k);
			mwait(2);
			r.keyRelease(k);
			mwait(2);
			r.keyRelease(16);
			mwait(2);
		}
		catch (Exception ex){
		  System.out.println("error");
		}
	}
	public static void type(String text){
		//text = text.toLowerCase();
		int lim = text.length();
		int counter = 0;
		char c;
		while (counter < lim){
			c = text.charAt(counter);
			press(c);
			try{
			//Thread.sleep(100);
			}catch(Exception ex){}
			counter++;
		}
	}
	public static void wait(int seconds){
		try{
		Thread.sleep(1000*seconds);
		}catch(Exception ex){}
	}
	public static void mwait(int mseconds){
		try{
		Thread.sleep(mseconds);
		}catch(Exception ex){}
	}
	public static void readFile(String fname){
		try{
		Scanner scanner = new Scanner(new File(fname));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			type(line + " ");
		}
		}catch (Exception ex){}
	}
}
