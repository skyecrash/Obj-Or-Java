// Lilith Freed, laf70

public class Lab5old {
  
  /**
   * Return true of the given date/time is daylight savings.
   * Daylight savings time begins 2am the second Sunday of March and ends 2am the first Sunday of November.
   *
   * @param month - represents the month with 1 = January, 12 = December
   * @param date - represents the day of the month, between 1 and 31
   * @param day -  represents the day of the week with 1 = Sunday, 7 = Saturday
   * @param hour - represents the hour of the day with 0 = midnight, 12 = noon
   *
   * Precondition: the month is between 1 and 12, the date is between 1 and 31, the day is between 1 and 7
   *                and the hour is between 0 and 23.
   */
  public static boolean isDayLightSavings(int month, int date, int day, int hour) {
    if(month >= 4 && month <= 10) {
      return true;
    } else if(month == 11) {
      if(day == 1 && date <= 7) {
        if(hour < 2) {
          return true;
        } else {
          return false;
        }
      } else if(date <= (day - 1)) {
        return true;
      } else {
        return false;
      }
    } else if(month == 3) {
      if(day == 1 && date >= 8 && date <= 14) {
        if(hour < 2) {  
          return false;
        } else {
          return true;
        }
      } else if(date <= (day + 6)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
      
}