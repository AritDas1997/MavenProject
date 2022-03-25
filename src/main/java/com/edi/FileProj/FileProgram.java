package com.edi.FileProj;


import java.io.* ;





import java.util.* ;
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
//import java.io.IOException;  // Import the IOException class to handle errors

public class FileProgram {

        File file ;
		File myObj ;
		FileInputStream for_source ;
		Properties source ;
		String data="" ;
	    String st1="" ;
	    String st2="" ;
	    String st_test="Files in Java might be tricky." ;
	    String profile_name="" ;
	    
	    
	    
	    /**Function to create a file
	     * 
	     * @throws Exception
	     */
	    
	 	public void filecreation() throws Exception{
		   
		try {
			
			Properties prof = new Properties() ;
		    prof.load(FileProgram.class.getClassLoader().getResourceAsStream("local.properties")) ;
		    profile_name=prof.getProperty("uvalue") ;
		//	for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\project.properties") ;
			for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\" + profile_name + ".properties") ;
			
			source = new Properties() ;
			source.load(for_source);
	       	st1=source.getProperty("uname") ;
			st2=source.getProperty("path") ;
			
	            
			file = new File(st2 + st1 + ".txt")	 ;    
	   	    boolean value = file.createNewFile();
	   	        
	    if (value) {
		    System.out.println("New Java File is created.");
		        
	    } else {
		    System.out.println("The file already exists.");
	    } 
		
		} catch (Exception e) {
		      e.getStackTrace();
		}
	         
	    }
			
	 	/**Function to write to a file
	 	 * 
	 	 * @throws Exception
	 	 */
	 	
	 	
			
	 	 public void filewrite() throws Exception {
				
	     try {
	    	 Properties prof = new Properties() ;
			 prof.load(FileProgram.class.getClassLoader().getResourceAsStream("local.properties")) ;
			 profile_name=prof.getProperty("uvalue") ;
		//	 for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\project.properties") ;
			 for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\" + profile_name + ".properties") ;
			
			 source = new Properties() ;
			 source.load(for_source);
			       	
			 st1=source.getProperty("uname") ;
			 st2=source.getProperty("path") ;
			 FileWriter myWriter = new FileWriter( st2 + st1 + ".txt" );	
			
			 myWriter.write(st_test) ;
		     myWriter.close();
			 System.out.println("Successfully wrote to the file.");
			       
			      
	    } catch(Exception e) {
	         e.getStackTrace();
			        
	    }
				
        }
			 
	 	 
	 	 
	 	 /**Function to read from a file
	 	  * 
	 	  * @return
	 	  * @throws Exception
	 	  */
			
	 	 public int fileread() throws Exception {
				
		 try {
			 
			 Properties prof = new Properties() ;
			 prof.load(FileProgram.class.getClassLoader().getResourceAsStream("local.properties")) ;
			 profile_name=prof.getProperty("uvalue") ;
			 
					
		   //  for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\project.properties") ;
		   	 for_source = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\" + profile_name + ".properties") ;
			 
			 source = new Properties() ;
			 source.load(for_source);
		     
			 st1=source.getProperty("uname") ;
			 st2=source.getProperty("path") ;
			 myObj = new File( st2 + st1 + ".txt" );
			 Scanner myReader = new Scanner(myObj);
			 
	     while (myReader.hasNextLine()) {
			 data = myReader.nextLine();
			 System.out.println(data);
				    
	    }
		     myReader.close();
		   
	    } catch (FileNotFoundException e) {
		     System.out.println("An error occurred.");
			 e.printStackTrace();
	    }
			 return data.length();
	    }
			
	 	 
	 	 
	  
	/* 	 public static void main(String[] args) throws Exception {
	 	     
	 		FileProgram fp = new FileProgram() ;
	 		fp.filecreation() ;
	 		fp.filewrite();
	 		fp.fileread() ;
	 	} */
	/*		public void FileDeletion() throws Exception {
			      file.delete() ;
			} */
	    

		}
			

