package com.imcs.training.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUsage {
	public static List<PropertyInformation> readPropertyInfo(File file) throws Exception{
		  List<PropertyInformation>propertyInfo = new ArrayList<>();
		  Reader fr = null;
		  BufferedReader br = null;
	  
      try {
    		  fr = new FileReader(file); 
    		  br = new BufferedReader(fr);
    		 
    		  String line = null;
    	  	  
    	  while((line = br.readLine()) != null)
    	  {
    			  PropertyInformation property = parseLine(line);
    			  propertyInfo.add(property);    		  
    	  }
    	  
    	 }
      catch(FileNotFoundException ex)
      {
    	  ex.printStackTrace();
    	  
      }
      finally
      {
    	  br.close();
    	  fr.close();
      }
      return propertyInfo;

	  }

	private static PropertyInformation parseLine(String line) {
		String[] tokens = line.split(",");
		PropertyInformation propertyInfo = new PropertyInformation(Integer.parseInt(tokens[0]), tokens[1], tokens[2],
				Double.parseDouble(tokens[3]), LocalDate.parse(tokens[4]));
		return propertyInfo;
	}
}
