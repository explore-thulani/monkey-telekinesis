package acsse.csc2a.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Reads information about the Game from a text file
 */

/**
 * @author Mr T Ncube
 *
 */
public class ReadingFile {
	
	public static String fileReader(String fileName){
		String line = "";
		File file = new File(fileName);
		
		try {
			Scanner scFile = new Scanner(file);
			
			while(scFile.hasNext()){
				
				line = scFile.nextLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			
		}
		
		
		return line;
	}
}
