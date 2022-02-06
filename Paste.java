import java.awt.Robot;
import java.util.*;  
import java.lang.*;
class Paste{
	static Robot r;
	public static void main(String[] args){
		wait(5);
		type("this was written from a Java program, it now supports commas and fullstops, but not upper case.\n");
	}
	public static void press(char key){
		int k;
		k = (int)key-32;
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
		try{		
			r = new Robot();
			r.keyPress(k);
			r.keyRelease(k);
			Thread.sleep(50);
		}
		catch (Exception ex){
		  System.out.println("error");
		}
	}
	public static void type(String text){
		text = text.toLowerCase();
		int lim = text.length();
		int counter = 0;
		while (counter < lim){
			press(text.charAt(counter));
			try{
			Thread.sleep(100);
			}catch(Exception ex){}
			counter++;
		}
	}
	public static void wait(int seconds){
		try{
		Thread.sleep(1000*seconds);
		}catch(Exception ex){}
	}
}
