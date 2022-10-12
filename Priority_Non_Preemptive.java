import java.util.Scanner;

public class Priority_Non_Preemptive {
	
		
	    int burstTime[];
	    int priority[];
	    int arrivalTime[];
	    String[] processId;
	    int numberOfProcess;
	    
	    Scanner input = new Scanner(System.in);

	    void getProcessData(Scanner input) {
	        System.out.print("Enter the number of Process for Scheduling           : ");
	        int inputNumberOfProcess = input.nextInt();
	        numberOfProcess = inputNumberOfProcess;
	        
	        		
	        		
	        		
	        burstTime = new int[numberOfProcess];////////////////////////////////////////////////////////////
	        priority = new int[numberOfProcess];
	        arrivalTime = new int[numberOfProcess];
	        processId = new String[numberOfProcess];
	        String st = "P";
	        for (int i = 0; i < numberOfProcess; i++) 
	        {
	            processId[i] = st.concat(Integer.toString(i));
	            System.out.print("Enter the burst time   for Process - " + (i) + " : ");
	            burstTime[i] = input.nextInt();
	            System.out.print("Enter the arrival time for Process - " + (i) + " : ");
	            arrivalTime[i] = input.nextInt();
	            System.out.print("Enter the priority     for Process - " + (i) + " : ");
	            priority[i] = input.nextInt();
	        }
	    }

	    void sortAccordingPriority(Priority_Process proc[]) 
	    {
	    	
	        int temp;
	        String stemp;
	        for (int i = 0; i < numberOfProcess; i++) 
	        {

	            for (int j = 0; j < numberOfProcess - i - 1; j++) 
	            {
	                //sorting according to priority when arrival timings are same
	            	
                	if (proc[j + 1] != null) {
                		if (proc[j].prt > proc[j + 1].prt) {
	                    	System.out.println("swapped");
	                    	System.out.println("j = "+j);
	                        //swapping burst time
	                        temp = proc[j].bt;
	                        proc[j].bt = proc[j + 1].bt;
	                        proc[j + 1].bt = temp;

	                        //swapping priority
	                        temp = proc[j].prt;
	                        proc[j].prt = proc[j + 1].prt;
	                        proc[j + 1].prt = temp;

	                        //swapping process identity
	                        stemp = proc[j].pid; // here was temp,, I replaced it with stemp since its a string
	                        proc[j].pid = proc[j + 1].pid;
	                        proc[j + 1].pid = stemp;
	                    }
                	}
	                    
	            }

	        }
	    }
	    
	    
	    static void findWaitingTime(Priority_Process proc[], int n, int wt[]) { 
	        int rt[] = new int[n]; 
	       
	        int sum = 0;
	        for( int i = 0; i < n; i++) {
	        	wt[i] = sum;
	        	sum+= proc[i].bt;
	        }
	        
//	        // Copy the burst time into rt[] 
//	        for (int i = 0; i < n; i++) 
//	            rt[i] = proc[i].bt; 
//	       
//	        int complete = 0, t = 0; 
//	        int shortest = 0, finish_time; 
//	        boolean check = false; 
	       
//	        // Process until all processes gets 
//	        // completed 
//	        
//	        
//	        
//	        while (complete != n) { 
//	       
//	       
//	            if (check == false) { 
//	                t++; 
//	                continue; 
//	            } 
//	       
//	            // Reduce remaining time by one 
//	            rt[shortest]--; 
//	       
//	             
//	       
//	            // If a process gets completely 
//	            // executed 
//	            if (rt[shortest] == 0) { 
//	       
//	                // Increment complete 
//	                complete++; 
//	                check = false; 
//	       
//	                // Find finish time of current 
//	                // process 
//	                finish_time = t + 1; 
//	       
//	                // Calculate waiting time 
//	                wt[shortest] = finish_time - proc[shortest].bt;
//	       
//	                if (wt[shortest] < 0) 
//	                    wt[shortest] = 0; 
//	            } 
//	            // Increment time 
//	            t++; 
//	        } 
	    }
	    
	    static void findTurnAroundTime(Priority_Process proc[], int n, int wt[], int tat[]) { 
			// calculating turnaround time by adding 
			// bt[i] + wt[i] 
			for (int i = 0; i < n; i++) 
			tat[i] = proc[i].bt + wt[i]; 
			} 

	    void priorityNonPreemptiveAlgorithm(Priority_Process proc[], int numberProcess) 
	    {
	    	numberOfProcess = numberProcess;
	        int finishTime[] = new int[numberOfProcess];
	        int waitingTime[] = new int[numberOfProcess];
	        int turnAroundTime[] = new int[numberOfProcess];
	         
	        
	        int  total_waitingTime = 0, total_turnAroundTime = 0; 
	       
	        // Function to find waiting time of all 
	        // processes 
	        sortAccordingPriority(proc);
	        findWaitingTime(proc, numberOfProcess, waitingTime); 
	       
	        // Function to find turn around time for 
	        // all processes 
	        findTurnAroundTime(proc, numberOfProcess, waitingTime, turnAroundTime); 
	       
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
	            System.out.println(" " + proc[i].pid + "              "
	                             + proc[i].bt + "            " + waitingTime[i] 
	                             + "             " + turnAroundTime[i]); 
	        } 
	       
	        System.out.println("Average waiting time = " + 
	                          (float)total_waitingTime / (float)numberOfProcess); 
	        System.out.println("Average turn around time = " + 
	                           (float)total_turnAroundTime / (float)numberOfProcess); 

//	        //calculating waiting & turn-around time for each process
//	        finishTime[0] = proc[0].art + proc[0].bt;
//	        turnAroundTime[0] = finishTime[0];
//	        waitingTime[0] = turnAroundTime[0] - proc[0].bt;
//
//	        for (int i = 1; i < numberOfProcess; i++) {
//	            finishTime[i] = proc[i].bt + finishTime[i - 1];
//	            turnAroundTime[i] = finishTime[i];
//	            waitingTime[i] = turnAroundTime[i] - proc[i].bt;
//	        }
//	        
//	        
//	        double sum = 0;
//	        for (int i = 0; i < waitingTime.length ; i++) {
//	            sum += waitingTime[i];
//	        }
//	        
//	        double averageWaitingTime = sum / numberOfProcess;
//
//	        sum = 0;
//	        for (int n : turnAroundTime) 
//	        {
//	            sum += n;
//	        }
//	        float averageTurnAroundTime = sum / numberOfProcess;
//
//	        //print on console the order of processes along with their finish time & turn around time
//	        System.out.println("Priority Scheduling Algorithm : ");
//	        System.out.format("%20s%20s%20s%20s%20s%20s%20s\n", "ProcessId", "BurstTime", "ArrivalTime", "Priority", "FinishTime", "WaitingTime", "TurnAroundTime");
//	        for (int i = 0; i < numberOfProcess; i++) {
//	            System.out.format("%20s%20d%20d%20d%20d%20d%20d\n", pid[i], bt[i], at[i], prt[i], finishTime[i], waitingTime[i], turnAroundTime[i]);
//	        }
//
//	        System.out.format("%100s%20f%20f\n", "Average", averageWaitingTime, averageTurnAroundTime);
	    }

//	    public static void main(String[] args) 
//	    {
//	        Scanner input = new Scanner(System.in);
//	        Priority_Non_Preemptive obj = new Priority_Non_Preemptive();
//	        obj.getProcessData(input);
//	        obj.priorityNonPreemptiveAlgorithm();
//	    }

}
