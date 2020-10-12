package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	public static final String BASEURL = "http://209.97.130.115:8011/";

	public static final String USERNAME = "E123456";
	public static final String PASSWORD = "112245998";

	public static final String ADMINUSERNAME = "testAdmin";
	public static final String EMPLOYEEUSERNAME = "testEmp";
	public static final String NORMALUSERNAME = "testUser";	
	public static final String VALIDPASSWORD = "12345678";

	public static final String INVALIDUSERNAME = "!@$~&";
	public static final String INVALIDPASSWORD = "!@$~&";

	public static final String EMPTYDATA = "";

	public static final String PROJECTPATH = "D:\\HARDIK\\Work\\Automation\\LuxshPayrollHelpDesk";

	public static final String FILEUPLOADPATH = PROJECTPATH + "\\src\\main\\java\\helper\\testingPurpose\\Test PNG-1.png";
	public static final String UPDATEDFILEUPLOADPATH = PROJECTPATH + "\\src\\main\\java\\helper\\testingPurpose\\images.png";
	
	public static final Date date = new Date();

	public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");  
	public static String strDate = formatter.format(date);  
	
//	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
//	String strDate = formatter.format(date);  
//	System.out.println("Date Format with MM/dd/yyyy : "+strDate);  

//	formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
//	strDate = formatter.format(date);  
//	System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);  
//
//	formatter = new SimpleDateFormat("dd MMMM yyyy");  
//	strDate = formatter.format(date);  
//	System.out.println("Date Format with dd MMMM yyyy : "+strDate);  
//
//	formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");  
//	strDate = formatter.format(date);  
//	System.out.println("Date Format with dd MMMM yyyy zzzz : "+strDate);  
//
//	formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");  
//	strDate = formatter.format(date);  
//	System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z : "+strDate);  

}
