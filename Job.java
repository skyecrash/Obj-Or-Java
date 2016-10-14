import java.util.*;

/**
 * A class that contains information for a job.
 * @author Lilith Freed
 */
public class Job implements Comparable<Job> {
  
  /** The id of the job. */
  private int id;
  
  /** The earliest time at which the job may be started. */
  private int earliestStart;
  
  /** The latest time at which the job must be complete. */
  private int deadline;
  
  /** The length of time it takes to complete the job. */
  private int duration;
  
  /** The amount of profit to be earned if the job is complete. */
  private int profit;
  
  /**
   * Initializes all fields of Job using input values.
   * @param id The id of the job.
   * @param earliestStart The earliest time the job may be started.
   * @param deadline The latest time that the job may be completed.
   * @param duration The length of time the job will take to complete.
   * @param profit The amount of profit that can be earned from completing the job.
   */
  public Job(int id, int earliestStart, int deadline, int duration, int profit) {
    this.id = id;
    this.earliestStart = earliestStart;
    this.deadline = deadline;
    this.duration = duration;
    this.profit = profit;
  }
  
  /**
   * Returns the id of the job.
   * @return The id of the job.
   */
  public int getID() {
    return this.id;
  }
  
  /**
   * Returns the earliest time the job may be started.
   * @return The earliest time the job may be started.
   */
  public int getEarliestStart() {
    return this.earliestStart;
  }
  
  /**
   * Sets the earliest time the job may be started.
   * @param start The earliest time the job may be started.
   */
  public void setEarliestStart(int start) {
    this.earliestStart = start;
  }
  
  /**
   * Returns the latest time at which the job must be complete.
   * @return The deadline of the job.
   */
  public int getDeadline() {
    return this.deadline;
  }
  
  /**
   * Sets the latest time at which the job must be complete.
   * @param deadline The deadline of the job.
   */
  public void setDeadline(int deadline) {
    this.deadline = deadline;
  }
  
  /**
   * Returns the length of time the job will take to complete.
   * @return The length of time the job will take.
   */
  public int getDuration() {
    return this.duration;
  }
  
  /**
   * Sets the length of time the job will take to complete.
   * @param duration The length of time the job will take.
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }
  
  /** 
   * Returns the profit received upon completion of the job.
   * @return The profit to be earned from the job.
   */
  public int getProfit() {
    return this.profit;
  }
  
  /**
   * Asserts if this Job and the Job parameter are equal.
   * @param j1 The job to be compared.
   * @return True if the two are equal, false otherwise.
   */
  public boolean equals(Job j1) {
    return j1 == this;
  }
  
  /** 
   * Returns the Comparator for comparing start time. 
   * @return The Comparator that can compare start time (smallest to largest ordering)
   */
  public static Comparator<Job> getStartComparator() {
    return new Comparator<Job>() {
      public int compare(Job j1, Job j2) {
        return j1.getEarliestStart() - j2.getEarliestStart();
      }
    };
  }
  
  /**
   * Returns the Comparator for comparing profit.
   * @return The Comparator that can compare profit (largest to smallest ordering)
   */
  public static Comparator<Job> getProfitComparator() {
    return new Comparator<Job>() {
      public int compare(Job j1, Job j2) {
        return j2.getProfit() - j1.getProfit();
      }
    };
  }
  
  /**
   * Compares the Job object and parameter using ID.
   * @param j1 A Job object.
   * @return a negative integer, zero, or a positive integer when this object's ID is less than, equal to, or greater than the ID of the param.
   */
  public int compareTo(Job j1) {
    return this.getID() - j1.getID();
  }
     

}
  