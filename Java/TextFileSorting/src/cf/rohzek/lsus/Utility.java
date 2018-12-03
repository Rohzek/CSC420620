package cf.rohzek.lsus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utility 
{
	public static List<String> GetFileContents(File file) 
	{
		List<String> list = new ArrayList<String>();
		
		try 
		{
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) 
			{
				list.add(line);
			}
			
			fileReader.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void WriteFileOut(List<String> list) 
	{
		Path file = Paths.get("output_java.txt");
		
		try 
		{
			Files.write(file, list, Charset.forName("UTF-8"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
