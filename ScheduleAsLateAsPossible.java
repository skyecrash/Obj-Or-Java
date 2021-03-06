/**
 * A class that schedules jobs as late as possible according to the schedule.
 * @author Lilith Freed
 */
public class ScheduleAsLateAsPossible implements ScheduleMetric {
  
  /**
   * Attemps to place job into the schedule such that the job will be completed as late as possible.
   * @param schedule The schedule to be analyzed for insertion.
   * @param job The Job to be inserted.
   */
  public boolean scheduleJob(Schedule schedule, Job job) {
    if(schedule.isEmpty()) {
      schedule.addToFront(new ScheduleSlot(job, job.getDeadline() - job.getDuration()));
      return true;
    }
    return false;
  }
  
  
}
    
    
  