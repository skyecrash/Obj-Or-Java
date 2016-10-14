/**
 * An interface to be used in scheduling classes.
 * @author Lilith Freed
 */
public interface ScheduleMetric {
  
  boolean scheduleJob(Schedule schedule, Job job);
  
}