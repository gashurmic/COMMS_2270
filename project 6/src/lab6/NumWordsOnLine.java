package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumWordsOnLine {
	public static void main(String[] args) throws FileNotFoundException {
        File selectedFile = new File("../project5/story.txt");
        Scanner scnr = new Scanner(selectedFile); 
        
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();  
            String[] words = line.split(" ");
           int numWords = words.length;
           if(numWords == 1) {
        	   numWords = 0;
           }
           
            System.out.println(numWords);
        }
        
        scnr.close();
    }
}
