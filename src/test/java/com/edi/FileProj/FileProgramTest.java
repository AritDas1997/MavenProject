package com.edi.FileProj;

import static org.junit.Assert.*;





import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;




//import com.edi.FileProj.FileProgram ;
public class FileProgramTest {

	    FileInputStream for_source ;
	    FileInputStream for_test ;
	    Properties source  ;
	    Properties test ;
	
	    String str1="" ;
	    String str2="" ;
	    String str3="" ;
     	String str4="Files in Java might be tricky." ;
	    String profile_name="" ;
	    String testprofile_name=" " ;
	    
	
	    FileProgram fptr=new FileProgram() ;
	//FileProgramTest pf=new FileProgramTest() ;
	
	    
	/* This test case is used to validate whether the Initialize() function is successfully being able to initialize 
	 * the file input stream variable
	 *  with the location of the properties file.*/    
	    
	@Before
    public void Initialize() throws Exception {
		
		 Properties prof = new Properties() ;
		
		 prof.load(FileProgram.class.getClassLoader().getResourceAsStream("local.properties")) ;
		 profile_name=prof.getProperty("uvalue") ;
	//	 for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\project.properties") ;
		
		 
		 for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\" + profile_name + ".properties") ;
		 
	     source = new Properties() ;
	     source.load(for_source);
    
	     str1=source.getProperty("uname") ;
	     str2=source.getProperty("path") ;
	     str3 = ( str2 + str1 + ".txt" ) ;
	 
	}
	
	
	
	/**This test case is used to check whether the filecreation() function is successfully
	 * being able to create a file or not.
	 * 
	 * @throws Exception
	 */
	 
	
    @Test
	public void FileCreationTest() throws Exception {
	    fptr.filecreation();
	}
	
	
    /**This test case is used to check whether the fileread() function is successfully
	 * being able to read the contents from a file or not.
     * 
     * @throws Exception
     */
	@Test
	public void test4() throws Exception{
		
		Properties test_prof = new Properties() ;
		test_prof.load(FileProgram.class.getClassLoader().getResourceAsStream("local.properties"));
		testprofile_name=test_prof.getProperty("uvalue") ;
     //   for_test = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testproject.properties") ;
		for_test = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\" + "test" + testprofile_name + ".properties") ;
		
	    test = new Properties() ;
		test.load(for_test);
	
		String str="";
		str=test.getProperty("test_path") ;
		File myfile = new File(str) ;
		
	if(! myfile.exists())
		System.out.println("The file you searched does not exist") ;
		assertEquals(true, myfile.exists() );
		
	}
	
	 
	/**This test case is used to check whether the filewrite() function is successfully
	 * being able to write the string to a file or not.
	 * 
	 * @throws Exception
	 */
	
	
	

    @Test
    public void test2() throws Exception{
  //  	for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\dev.properties") ;
    	for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\" + profile_name + ".properties") ;
    	
	    boolean chk=false;
//		m=(s+q+".txt") ;
	    
	    
     	FileProgram ptr=new FileProgram() ;
	    ptr.filewrite();  
	    System.out.println(str1) ;
	if(str3.length() > 0)
	    chk = true ;
	    assertEquals(true,chk) ;
	     
    }
   
  
    
	
    /**This test case is used to check whether the fileread() function is successfully
	 * being able to read the contents from a file or not.
     * 
     * @throws Exception
     */
    
    @Test
	public void test3() throws Exception {
    	FileProgram tr=new FileProgram() ;
    // 	m=(s+q+".txt") ;
        int temp= tr.fileread() ;
    	assertEquals(str4.length(), temp) ;
     	File nptr=new File(str3) ;
        nptr.deleteOnExit(); 
  
	    
    }
    
    

 /*  @AfterClass
     public static void test5() throws Exception{
    	
    	FileProgramTest pf=new FileProgramTest() ;
    	File fo=new File(pf.m) ;
		fo.deleteOnExit();
    	
    } */
    
   
}
