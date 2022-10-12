
public class Priority_Process {
	
	String pid; // Process ID 
    int prt; // Priority
    int bt; // Burst Time
    int art; // Arrival Time
      
    public Priority_Process(String pid, int prt, int bt) { 
        this.pid = pid;  
        this.prt = prt; 
        this.bt = bt;
        art = 0; // assumed as specified in the document
    }

}
