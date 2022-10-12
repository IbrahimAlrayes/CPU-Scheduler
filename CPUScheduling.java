import java.util.Scanner;

public class CPUScheduling {

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
		
		while(choice!=4) {
			switch(choice) {
	 			case 1:{
	 				SRTF s = new SRTF();
	 				System.out.println("Number of processes: ");
	 				int numProcesses = input.nextInt();
	 				System.out.println("Enter the following: Process ID, Arrival Time, Burst Time ");
	 				Process proc[] = new Process[numProcesses];
	 				for( int i = 0; i < numProcesses; i++) {
	 					System.out.println("process" + (i + 1) + ": " );
	 					proc[i] = new Process(input.next(), input.nextInt(), input.nextInt());
	 				}
	 				s.findavgTime(proc, numProcesses); 
	 				break;
	 			}
	 			case 2:{
	 				Priority_Non_Preemptive s = new Priority_Non_Preemptive();
	 				System.out.println("Number of processes: ");
	 				int numProcesses = input.nextInt();
	 				System.out.println("Enter the following: Process ID, Priority, Burst Time ");
	 				Priority_Process proc[] = new Priority_Process[numProcesses];
	 				for( int i = 0; i < numProcesses; i++) {
	 					System.out.println("process" + (i + 1) + ": " );
	 					proc[i] = new Priority_Process(input.next(), input.nextInt(), input.nextInt());	 				
	 					}
	 				s.priorityNonPreemptiveAlgorithm(proc, numProcesses);
	 				break;
	 			}
	 			case 3: {
	 				RR s = new RR();
	 				System.out.println("Number of processes: ");
	 				int numProcesses = input.nextInt();
	 				System.out.println("Enter the quantum: ");
	 				int q = input.nextInt();
	 				System.out.println("Enter the following: Process ID, Burst Time ");
	 				RRprocess proc[] = new RRprocess[numProcesses];
	 				for( int i = 0; i < numProcesses; i++) {
	 					System.out.println("process" + (i + 1) + ": " );
	 					proc[i] = new RRprocess (input.next(), input.nextInt());
	 				}
	 				s.findavgTime(proc, numProcesses, q);
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

}
