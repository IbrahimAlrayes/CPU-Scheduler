
public class RR {
	
	// Java program for implementation of RoundR scheduling
	    // Method to find the waiting time for all
	    // processes
	
	
	    static void findWaitingTime(RRprocess[] RoundR, int quantum, int wt[], int numberOfProcesses) {
	    	
	    	// Make a copy of burst times bt[] to store remaining
	        // burst times.
	    	
	    	int n = numberOfProcesses;
	        int rem_bt[] = new int[n];
	        for (int i = 0 ; i < n ; i++)
	            rem_bt[i] =  RoundR[i].bt;
	       
	        int t = 0; // Current time
	       
	        // Keep traversing processes in round-robin manner
	        // until all of them are not done.
	        while(true) {
	            boolean done = true;
	       
	            // Traverse all processes one by one repeatedly
	            for (int i = 0 ; i < n; i++)
	            {
	                // If burst time of a process is greater than 0
	                // then only need to process further
	                if (rem_bt[i] > 0)
	                {
	                    done = false; // There is a pending process
	       
	                    if (rem_bt[i] > quantum)
	                    {
	                        // Increase the value of t i.e. shows
	                        // how much time a process has been processed
	                    	t += quantum;
	       
	                        // Decrease the burst_time of current process
	                        // by quantum
	                        rem_bt[i] -= quantum;
	                    }
	       
	                    // If burst time is smaller than or equal to
	                    // quantum. Last cycle for this process
	                    else
	                    {
	                        // Increase the value of t i.e. shows
	                        // how much time a process has been processed
	                    	t = t + rem_bt[i];
	                        
	       
	                        // Waiting time is current time minus time
	                        // used by this process
	                        wt[i] = t - RoundR[i].bt;
	       
	                        // As the process gets fully executed
	                        // make its remaining burst time = 0
	                        rem_bt[i] = 0;
	                    }
	                }
	            }
	       
	            // If all processes are done
	            if (done == true)
	              break;
	        }
	    }
	       
	    // Method to calculate turnaround time
	    static void findTurnAroundTime(RRprocess[] RoundR, int wt[], int tat[], int numberOfProcess) {
	        // calculating turnaround time by adding
	        // bt[i] + wt[i]
	    	int n = numberOfProcess;
	        for (int i = 0; i < n ; i++)
	            tat[i] = RoundR[i].bt + wt[i];
	    }
	       
	    // Method to calculate average time
	    static void findavgTime(RRprocess[] RoundR, int numberOfProcess, int quantum) {
	        int waitingTime[] = new int[numberOfProcess];
	        int turnAroundTime[] = new int[numberOfProcess];
	         
	        
	        int  total_waitingTime = 0, total_turnAroundTime = 0; 
	       
	        // Function to find waiting time of all 
	        // processes 
	        findWaitingTime(RoundR, quantum, waitingTime, numberOfProcess ); 
	       
	        // Function to find turn around time for 
	        // all processes 
	        findTurnAroundTime(RoundR, waitingTime, turnAroundTime, numberOfProcess); 
	       
	        // Display processes along with all 
	        // details 
	        System.out.println("Processes " + 
	                           " Burst time " + 
	                           " Waiting time " + 
	                           " Turn around time"); 
	       
	        // Calculate total waiting time and 
	        // total turnaround time 
	        for (int i = 0; i < numberOfProcess; i++) { 
	            total_waitingTime = total_waitingTime + waitingTime[i]; 
	            total_turnAroundTime = total_turnAroundTime + turnAroundTime[i]; 
	            System.out.println(" " + RoundR[i].pid + "              "
	                             + RoundR[i].bt + "            " + waitingTime[i] 
	                             + "             " + turnAroundTime[i]); 
	        } 
	       
	        System.out.println("Average waiting time = " + 
	                          (double)total_waitingTime / (double)numberOfProcess); 
	        System.out.println("Average turn around time = " + 
	                           (double)total_turnAroundTime / (double)numberOfProcess); 
	    }
	      
}
