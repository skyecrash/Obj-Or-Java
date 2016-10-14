// Lilith Freed, laf70

public class Date {
  
  /* day of date */
  private int day;
  
  /* month of date */
  private int month;
  
  /* Constructor for given month and day */
  public Date(int day, int month) {
    this.day = day;
    this.month = month;
  }
  
  /* returns the day of the date */
  public int getDay() {
    return this.day;
  }
  
  /* returns the month of the date */
  public int getMonth() {
    return this.month;
  }
  
  /* increments day
   * if day exceeds month's limit, increment month
   * if month is greater than 12, month set to 1 */
  public void incrementDay() {
    this.day = day + 1;
    if(this.day > 28 && this.month == 2) {
      this.month = this.month + 1;
      this.day = 1;
    } else if(this.day > 30 && this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
      this.month = this.month + 1;
      this.day = 1;
    } else if(this.day > 31) {
      this.month = this.month + 1;
      this.day = 1;
      if(this.month > 12) {
      this.month = 1;
      }
    }
  }

}