package com.MercuryTours.qa.TestData;

import java.io.IOException;


public class ObjectArray_Input 
   {
	static int i=1;
	static String path = "C:\\Users\\101139\\eclipse\\eclipse-workspace\\"
			+ "Web_Automation\\src\\main\\java\\com\\MercuryTours\\qa\\TestData\\Test Data.xlsx";
	static String Sheet_name=null;
   
    
	public static Object[][] Fetch_TestData() throws IOException {
		Object[][] name; 
        Sheet_name = "Sheet"+i;
	    name = ExcelOperations.Read_TestData(path,Sheet_name);
	    i++;
	    return name;

	}
	
	public static String Fetch_ExpectedResult() throws IOException
	{
		Sheet_name="Sheet3";
		String ExpectedResult=ExcelOperations.Read_ExpectedResult(path, Sheet_name);
		return ExpectedResult;
		
	}

	

	
    }
