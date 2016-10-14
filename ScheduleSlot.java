/**
 * A class to represent a schedule slot.
 * @author Lilith Freed
 */
public class ScheduleSlot {
  
  /** The job scheduled in the slot. */
  private Job job;
  
  /** The start time of the slot. */
  private int startTime;
  
  /**
   * Initializes the fields of the ScheduleSlot class.
   * @param job The Job to be scheduled.
   * @param startTime The start time for this slot.
   */
  public ScheduleSlot(Job job, int startTime) {
    this.job = job;
    this.startTime = startTime;
  }
  
  /**
   * Returns the job for the slot.
   * @return The job for the schedule slot.
   */
  public Job getJob() {
    return this.job;
  }
  
  /**
   * Returns the start time for the slot.
   * @return The start time for the schedule slot.
   */
  public int getStartTime() {
    return this.startTime;
  }
  
  /**
   * Sets the start time for the slot.
   * @param startTime The desired start time for the slot.
   */
  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }
  
}