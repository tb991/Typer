import java.awt.Robot;
import java.util.*;  
import java.lang.*;
class Paste{
	static Robot r;
	public static void main(String[] args){
		wait(5);
		type("This was written from a Java program, it now supports commas, full stops and upper case.\n");
	}
	public static void press(char key){
		int k;
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
		try{		
			r = new Robot();
			if (Character.isUpperCase(key)){
				r.keyPress(16); //shift
			}
			r.keyPress(k);
			Thread.sleep(100);
			r.keyRelease(k);
			r.keyRelease(16);
			Thread.sleep(50);
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
