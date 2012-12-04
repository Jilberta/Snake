import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Stat {

// The name of the file the results are saved in;
private static final String FILENAME = "top5.txt"; 

/**
* This list should contain top 5 pleyers
* names and their scores stored
* in a saved text file
* @return: top5 list
* */
public static ArrayList<String> getTop5List(){
	ArrayList<String> top5 = new ArrayList<String>();
	try {
		Scanner sc = new Scanner(new FileReader(FILENAME));
		String temp ="";
		while(sc.hasNextLine()){
			temp = sc.nextLine();
			top5.add(temp);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return top5;
}

/**
* Checking the result of a player, if it is worthy to be
* in a top 5 players list
* @param: player's score
* @param: players's name
* */
public static void save(int score, String name){
if (isWorthy(score)){
setInTop5(score, name);
}
}

/**
* @param: players score
* @return: true if the player is worthy
* to be in a top5 list
* */
private static boolean isWorthy(int score){
	if (getTop5List().size()<5) {
		return true ;
	}
	else{
		for(int i = 0;i<getTop5List().size();i++){
			if(score >= Integer.parseInt(getTop5List().get(i))){
				return true;
			}
		}
	}
//TODO: implement top 5 check;
return false;
}

/**
* Set the player in a top 5 list
* @param: player's score
* @param: players's name
* */
private static void setInTop5(int score, String name){
	ArrayList<String> temp = getTop5List();
	String s = name + " " + score;
	temp.add(0, s);
	File fil = new File(FILENAME);
	try {
		FileWriter writer = new FileWriter(fil);
		@SuppressWarnings("resource")
		BufferedWriter buf = new BufferedWriter(writer);
		int size=0;
		if(temp.size()>5){
			int min ;
			int index;
			int minn;
			for (int i = 0;i<temp.size();i++){
				if(score>=Integer.parseInt(temp.get(i))){
					temp.remove(i);
				}
			}
			size = size-1;
		}
		for (int i =0; i<temp.size();i++){
			buf.write(temp.get(i));
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//TODO: implement a bufferedWriter to save results in the text file;
}

}