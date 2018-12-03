package cf.rohzek.lsus;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) 
	{
		if(args.length != 1) 
		{
			System.out.println("USAGE: Specify a single text file as an argument");
		}
		else 
		{
			File file = new File(args[0]);
			
			// Make sure what was provided is actually a file.
			if(!file.exists()) 
			{
				System.out.println("\nPlease provide a valid text file");
				System.exit(1);
			}
			
			// Get file as a list
			List<String> list = Utility.GetFileContents(file);
			
			// Sort list - time it
			long startTime = System.currentTimeMillis();
			Collections.sort(list);
			long endTime = System.currentTimeMillis();
			
			String time = "Sorting took " + (endTime - startTime) + " ms";
			System.out.println(time); 
			list.add("\n   ");
			list.add(time);
			
			// Output list as a new file
			Utility.WriteFileOut(list);
		}
	}
}
