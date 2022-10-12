import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException;  
public class ReadMain {
	
	
	static String [] pid = new String[30];
	static int[] at ;
	static int[] bt ;
	static int[] prt;

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
  
      System.out.println("*******************************\r\n" + 
				"* 1- Shortest Remaining Time First (SRTF). 	      \r\n" + 
				"* 2- Priority (non-preemptive).  \r\n" + 
				"* 3- Round Robin (RR). 		      \r\n" + 
				"* 4- Exit.                    \r\n" + 
				"*******************************");
		System.out.print("=> ");
		
		int choice = input.nextInt();
		//Reading files from the path
		
		
		while(choice!=4) {
			switch(choice) {
	 			case 1:{
	 			// Initialize global Arrays
	 				pid = new String[30];
	 				bt = new int[30];
	 				at = new int[30];
	 				ReadSRTF("C:\\Users\\win10\\Desktop\\CSC 227\\Project\\testdata1 for SRTF.txt");
	 				SRTF s = new SRTF();
	 				
	 				//System.out.println("Number of processes: ");
	 				//int numProcesses = input.nextInt();
	 				//System.out.println("Enter the following: Process ID, Arrival Time, Burst Time ");
	 				Process proc[] = new Process[30];
	 				int count = 0;
	 				for(int i = 0; i < proc.length; i++ ) {
	 					//System.out.println("process" + (i + 1) + ": " );
	 					if(pid[i] == null) break;
	 					proc[i] = new Process(pid[i], at[i],bt[i]);
	 					count++;
	 				}
	 				System.out.println(count);
	 				s.findavgTime(proc, count); // I passed (count) since it going to give number of inserted processes (before it was proc.length)
	 				break;
	 			}
	 			case 2:{
	 			// Initialize global Arrays
	 				pid = new String[30];
	 				bt = new int[30];
	 				prt = new int[30];
	 				ReadPriority("C:\\Users\\win10\\Desktop\\CSC 227\\Project\\testdata1 for priortiy.txt");
	 				Priority_Non_Preemptive s = new Priority_Non_Preemptive();
	 			//	System.out.println("Number of processes: ");
	 			//	int numProcesses = input.nextInt();
	 			//	System.out.println("Enter the following: Process ID, Priority, Burst Time ");
	 				Priority_Process proc[] = new Priority_Process[30];
	 				
	 				int count = 0;
	 				
	 				for( int i = 0; i < proc.length; i++) {
	 				//	System.out.println("process" + (i + 1) + ": " );
	 					if(pid[i] == null) break;
	 					proc[i] = new Priority_Process(pid[i], prt[i],bt[i]);
	 					count++;
	 				}
	 				
	 				s.priorityNonPreemptiveAlgorithm(proc, count);
	 				break;
	 			}
	 			case 3: {
	 				// Initialize global Arrays 
	 				pid = new String[30];
	 				bt = new int[30];

	 				ReadRR("C:\\Users\\win10\\Desktop\\CSC 227\\Project\\testdata1.txt");
	 				RR s = new RR();
	 				//System.out.println("Number of processes: ");
	 				//int numProcesses = input.nextInt();
	 				System.out.println("Enter the quantum: ");
	 				int q = input.nextInt();
	 				//System.out.println("Enter the following: Process ID, Burst Time ");
	 				RRprocess proc[] = new RRprocess[30];
	 				int count = 0; // 
	 				for(int i = 0; i < proc.length; i++) {
	 					if(pid[i] == null) break;
	 					//System.out.println("process" + (i + 1) + ": " );
	 					proc[i] = new RRprocess (pid[i],bt[i]);
	 					count++;
	 				}
	 				s.findavgTime(proc, count, q);
	 				break;
	 			}
				case 4:{
					System.out.println("Goodbye");
					break;
					}
				}
			System.out.println("*******************************\r\n" + 
					"* 1- Shortest Remaining Time First (SRTF). 	      *\r\n" + 
					"* 2- Priority (non-preemptive).  *\r\n" + 
					"* 3- Round Robin (RR). 		      *\r\n" + 
					"* 4- Exit.                    *\r\n" + 
					"*******************************");
			System.out.print("=> ");
			
			 choice = input.nextInt();
 } 

	}
	
	// Methods for reading different files
	public static void ReadSRTF(String FilePath) {

		// I'll put these as global variables to use it when creating array of processes in the main
		//int[] pid = new int[30];
  	  	//int[] at = new int[30];
  	  	//int[] bt = new int[30];
		 try {
		      File myObj = new File(FilePath); // Reads the file path
		      Scanner myReader = new Scanner(myObj);// scanner to read each line
		      String [] data = new String[30]; // array to store variables
		      int n = 0 ;
		      while (myReader.hasNextLine()) {
		    	  data[n] = myReader.nextLine(); // reading each line in text
		      
		      String[] split=data[n].split(","); // Splitting words if there is a comma
		      
	    	  pid[n] = split[0]; 
	    	  at[n] = Integer.parseInt(split[1].trim()); // removing leading and trailing spaces
	    	  bt[n] = Integer.parseInt(split[2].trim());
	    	  n++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 	for(int i = 0 ; i < pid.length ; i++) {
		 		if(pid[i] == null) break;
		 	 	System.out.println("pid "+i+ "= "+ pid[i] );
		 	 	System.out.println("at "+i+ "= "+ at[i] );
		 	 	System.out.println("bt "+i+ "= "+ bt[i] ); //// Testing ... Will be deleted
		 	}
		
	}
	
	public static void ReadPriority(String FilePath) {
		 try {
		      File myObj = new File(FilePath); // Reads the file path
		      Scanner myReader = new Scanner(myObj);// scanner to read each line
		      String [] data = new String[30]; // array to store variables
		      
		      int n = 0 ;
		      int i = 0 ; // counters
		      int j = 0 ;
		      
		      while (myReader.hasNextLine()) {
		    	  data[n] = myReader.nextLine(); // reading each line in text
		    	  String[] split;
		      if(n % 2 != 0) {
		    	  
		    	  split = data[n++].split(","); // Splitting words if there is a comma
		    	  bt[i] = Integer.parseInt(split[0].trim()); // removing leading and trailing spaces
		    	  prt[i] = Integer.parseInt(split[1].trim());
		    	  i++;
		      }
		      else {
		    	  pid[j++] = data[n++];
		      }
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 	for(int i = 0 ; i < pid.length ; i++) {
		 		if(pid[i] == null) {
		 			System.out.println("finish");
		 			break;
		 		}
		 	 	System.out.println("pid "+i+ "= "+ pid[i] );
		 	 	System.out.println("pt "+i+ "= "+ prt[i] );
		 	 	System.out.println("bt "+i+ "= "+ bt[i] ); //// Testing ... Will be deleted
		 	}
		
	}
	
	public static void ReadRR(String FilePath) {

		// I'll put these as global variables to use it when creating array of processes in the main
		//int[] pid = new int[30];
  	  	//int[] at = new int[30];
  	  	//int[] bt = new int[30];
		 try {
		      File myObj = new File(FilePath); // Reads the file path
		      Scanner myReader = new Scanner(myObj);// scanner to read each line
		      String [] data = new String[30]; // array to store variables
		      
		      int n = 0 ;
		      int i = 0 ; // counters 
		      int j = 0 ;
		      
		      while (myReader.hasNextLine()) {
		    	  data[n] = myReader.nextLine(); // reading each line in text
		    	  
		    	  if(n % 2 == 0) pid[i++] = data[n]; // if the row is even number then it means it's a pid
		    	  
		    	  else {
		    		  bt[j++] = Integer.parseInt(data[n].trim());
		    	  }
		    	  n++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 	for(int i = 0 ; i < pid.length ; i++) {
		 		if(pid[i] == null) break;
		 	 	System.out.println("pid "+i+ "= "+ pid[i] );
		 	 	System.out.println("bt "+i+ "= "+ bt[i] ); //// Testing ... Will be deleted
		 	}
		
	}
	
}
