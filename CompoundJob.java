import java.util.*;

/**
 * A class to represent a CompoundJob.
 * @author Lilith Freed
 */
public class CompoundJob extends Job {
  
  /** The list of SubJobs. */
  private Job[] subJobs;
  
  /** Initializes the fields of the CompoundJob.
    * @param profit The total profit for completing the set of subJobs.
    * @param subJobs an array of Jobs.
    */
  public CompoundJob(int profit, Job... subJobs) {
    super(0, subJobs[0].getEarliestStart(), subJobs[subJobs.length - 1].getDeadline(), 
          0, profit);
    
    this.subJobs = subJobs;
    
    int duration = calculateDuration(subJobs);
    setDuration(duration);
    
    adjustStartsAndDeadlines(subJobs);
  }
  
 /**
  * Helper method for calculating duration.
  * @param subJobs A list of subJobs.
  * @return The duration of the compound job.
  */
  private int calculateDuration(Job[] subJobs) {
    int duration = 0;
    
    /* Adds together the durations of the Jobs in subJobs.
     * Goal: duration is equal to the total duration of all the subjobs. */
    for(Job j : subJobs) {
      duration += j.getDuration();
    }
    
    return duration;
  }
  
  /** Helper method for adjusting deadlines and earliest starts of the Jobs in subJobs.
    * @param subJobs A list of subJobs.
    */
  private void adjustStartsAndDeadlines(Job[] subJobs) {
    
    int cjobDeadline = subJobs[subJobs.length - 1].getDeadline();
    int deadlineMinimum = cjobDeadline - (calculateDuration(subJobs) - 
                                          subJobs[0].getDuration());
        // the minimum deadline require to finish ALL jobs, currently calculated
        // based on the first job
    subJobs[0].setDeadline(deadlineMinimum);
                                                            
    int durationSum = subJobs[0].getEarliestStart();
    
    /* Adjusts the deadlines and earliest starts of the Jobs in subJobs.
     * Subgoal: i has earliest start time durationSum, i has deadline deadlineMinimum.
     * Goal: all starts and deadlines have been adjusted.
     * Precond: The deadline and start time has been set for the first job. */
    for(int i = 1; i < subJobs.length; i++) {
      deadlineMinimum += subJobs[i].getDuration();
      durationSum += subJobs[i - 1].getDuration();
      
      subJobs[i].setEarliestStart(durationSum);
      
      if(i != subJobs.length - 1) {
        subJobs[i].setDeadline(deadlineMinimum);
      }
      
    }
  }
         
}