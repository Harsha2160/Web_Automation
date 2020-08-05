package com.MercuryTours.qa.TestData;

import java.io.IOException;

public class ObjectArray_Input 
   {
	static int i=3;
	static String path = "C:\\Users\\101139\\eclipse\\eclipse-workspace\\"
			+ "Web_Automation\\src\\main\\java\\com\\MercuryTours\\qa\\TestData\\Test Data.xlsx";
	static String Sheet_name=null;
    
    
	public static Object[][] Login_Array() throws IOException {
		Object[][] name = new Object[100][100];
        Sheet_name = "Sheet1";
	    name = ExcelOperations.Read(path,Sheet_name);
		return name;

	}

	public static Object[][] Register_data() throws IOException {
		Object[][] name = new Object[100][100];
        Sheet_name = "Sheet2";
        name = ExcelOperations.Read(path,Sheet_name);
		return name;

	}
	
	
	
	
	//Write operation is optional as per the design
	
	public static void Test_Write1(String S) throws IOException
	{
		++i;
		Sheet_name = "Sheet"+i;
		ExcelOperations.Write(S,Sheet_name);
		
	}
    }
