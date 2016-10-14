// Lilith Freed, laf70

public class CreditCardAccount {
  
  /* credit limit */  
  private int credLim;
  
  /* interest rate */
  private double intRate;
  
  /* minimum monthly payment */
  private int minMonthPayment;
  
  /* late payment penalty */
  private int latePayPenalty;
  
  /* card balance */
  private double cardBal;
  
  /* payment to pay month off in full */
  private double monthPayment;
  
  /* interest charged for month */
  public double intTotal;
  
  /* payments made for month */
  private double paymentTotal;
  
  /* paid-in-full flag */
  private boolean paidInFull;
  
  /* Constructor for default values */
  public CreditCardAccount() {
    this.credLim = 500;
    this.intRate = 4.0;
    this.minMonthPayment = 125;
    this.latePayPenalty = 50;
    this.cardBal = 0.0;
    this.monthPayment = 0.0;
    this.paidInFull = true;
  } 
  
  /* Constructor for given values */
  public CreditCardAccount(int credLim, double intRate, int minMonthPayment, int latePayPenalty) {
    this.credLim = credLim;
    this.intRate = intRate;
    this.minMonthPayment = minMonthPayment;
    this.latePayPenalty = latePayPenalty;
    this.cardBal = 0.0;
    this.monthPayment = 0.0;
    this.paidInFull = true;
  }
  
  /* returns credit limit */
  public int getCreditLimit() {
    return this.credLim;
  }
  
  /* sets credit limit */
  public void setCreditLimit(int x) {
    this.credLim = x;
  }
  
  /* returns interest rate */
  public double getInterestRate() {
    return this.intRate;
  }
  
  /* sets interest rate */
  public void setInterestRate(double x) {
    this.intRate = x;
  }
  
  /* returns minimum monthly payment */
  public int getMinMonthlyPayment() {
    return this.minMonthPayment;
  }
  
  /* sets minimum montly payment */
  public void setMinMonthlyPayment(int x) {
    this.minMonthPayment = x;
  }
  
  /* returns late payment penalty */
  public int getLatePaymentPenalty() {
    return this.latePayPenalty;
  }
  
  /* sets late payment penalty */
  public void setLatePaymentPenalty(int x) {
    this.latePayPenalty = x;
  }
  
  /* returns balance */
  public double getBalance() {
    return this.cardBal;
  }
  
  /* returns montly balance to be paid off in full */
  public double getMonthlyPayment() {
    return this.monthPayment;
  }
  
  /* adds charge to card if sum of double input and cardBal is less than credLim */
  public boolean charge(double x) {
    if(x + this.cardBal <= this.credLim) {
      this.cardBal = this.cardBal + x;
      return true;
    } else {
      return false;
    }
  }
  
  /* subtracts double input from card balance and adds that input to the month's payments */
  public void payment(double x) {
    this.cardBal = this.cardBal - x;
    this.paymentTotal = this.paymentTotal + x;
  }
  
  /* if prev. month's balance is not paid in full, card charges interest on current balance */
  public void incrementDay() {
    if(!paidInFull) {
      this.intTotal = this.intTotal + (this.cardBal + this.intTotal) * (this.intRate / 365);
    }
  }
  
  /* adds intTotal to cardBal
   * sets month payment equal to current balance
   * if balance has been paid, paidInFull set to true; otherwise, set to false
   * charges late fee if minimum payment has not been met
   * sets intTotal, paymentTotal to zero */
  public void incrementMonth() {
    this.cardBal = this.cardBal + this.intTotal;
    if(this.paymentTotal >= this.monthPayment && this.monthPayment != 0) { 
      this.paidInFull = true;
    } else if(this.monthPayment == 0 && this.cardBal == 0) { // meant to handle first month incrementation, where monthly payment will be 0
      this.paidInFull = true;                                
    } else {
      this.paidInFull = false;
    }
    if(this.minMonthPayment < this.monthPayment && this.paymentTotal < this.minMonthPayment) {
      this.cardBal = this.cardBal + this.latePayPenalty;
    }
    this.monthPayment = this.cardBal;
    this.intTotal = 0;
    this.paymentTotal = 0;
  }
}
  
  