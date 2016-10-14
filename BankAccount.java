// Lilith Freed, laf70

public class BankAccount {
  
  /* account balance */
  private double acctBal;
  
  /* interest rate */
  private double intRate;
  
  /* minimum balance */
  private int minBal;
  
  /* overdraft fee */
  private double draftFee;
  
  /* ATM fee */
  private double ATMFee;
  
  /* bounced check fee */
  private double bounceFee;
  
  /* withdraw fee */
  private double wdrawFee;
  
  /* withdraw limit */
  private int wdrawLim;
  
  /* overdraft flag */
  private boolean draftFlag;
  
  /* withdrawal incrementer */
  private int wdrawCount;
  
  /* month's interest */
  public double intTotal;
  
  /* create the bank account with default values */
  public BankAccount() {
    this.intRate = 0.4;
    this.minBal = 100;
    this.draftFee = 25.0;
    this.ATMFee = 8.0;
    this.bounceFee = 20.0;
    this.draftFlag = false;
    this.acctBal = 0.0;
    this.wdrawFee = 10.0;
    this.wdrawLim = 8;
  }
  
  /* create the bank account with given values */
  public BankAccount(double intRate, int minBal, double draftFee, double ATMFee, double bounceFee) {
    this.intRate = intRate;
    this.minBal = minBal;
    this.draftFee = draftFee;
    this.ATMFee = ATMFee;
    this.bounceFee = bounceFee;
    this.draftFlag = false;
    this.acctBal = 0.0;
    this.wdrawFee = 10.0;
    this.wdrawLim = 8;
  }
  
  /* returns current balance for account */
  public double getBalance() {
    return this.acctBal;
  }
  
  /* returns interest rate for account */
  public double getInterestRate() {
    return this.intRate;
  }
  
  /* sets interest rate for account */
  public void setInterestRate(double x) {
    this.intRate = x;
  }
  
  /* returns minimum balance threshold */
  public int getMinimumBalance() {
    return this.minBal;
  }
  
  /* sets minimum balance threshold */
  public void setMinimumBalance(int x) {
    this.minBal = x;
  }
  
  /* returns ATM fee */
  public double getATMFee() {
    return this.ATMFee;
  }
  
  /* sets ATM fee */
  public void setATMFee(double x) {
    this.ATMFee = x;
  }
  
  /* returns overdraft fee */
  public double getOverDraftFee() {
    return this.draftFee;
  }
  
  /* sets overdraft fee */
  public void setOverDraftFee(double x) {
    this.draftFee = x;
  }
  
  /* returns bounced check fee */
  public double getBouncedCheckFee() {
    return this.bounceFee;
  }
  
  /* sets bounced check fee */
  public void setBouncedCheckFee(double x) {
    this.bounceFee = x;
  }
  
  /* returns withdraw fee */
  public double getWithdrawFee() {
    return this.wdrawFee;
  }
  
  /* sets withdraw fee */
  public void setWithdrawFee(double x) {
    this.wdrawFee = x;
  }
  
  /* returns withdraw limit */
  public int getWithdrawLimit() {
    return this.wdrawLim;
  }
  
  /* sets withdraw limit */
  public void setWithdrawLimit(int x) {
    this.wdrawLim = x;
  }
  
  /* adds double input to the account's balance */
  public void deposit(double x) {
    this.acctBal = this.acctBal + x;
  }
  
  /* if acctBal is greater than or equal to double input, money is withdrawn,
     Withdrawals incremented, withdraw fee applied if it exceeds wdrawLim and returns true
   * Otherwise method returns false and nothing is removed */
  public boolean withdraw(double x) {
    if(x <= this.acctBal) {
      this.acctBal = this.acctBal - x;
      if(wdrawLim > 0) {
        this.wdrawCount = this.wdrawCount + 1;
        if(this.wdrawCount > this.wdrawLim) {
          this.acctBal = this.acctBal - this.wdrawFee;
        }
        return true;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }
  
  /* if acctBal is greater than or equal to double input, money is withdrawn,
     Withdrawals incremented, withdraw fee applied if it exceeds wdrawLim and returns true
   * Otherwise, balance is reduced by bounced check fee and method returns false */
  public boolean withdrawDraft(double x) {
    if(x <= this.acctBal) {
      this.withdraw(x);
      return true;
    } else {
      this.acctBal = this.acctBal - this.bounceFee;
      return false;
    }
  }
      
  
  /* if acctBal PLUS ATMFee is greater than or equal to double input, money is withdrawn,
     Withdrawals incremented, withdraw fee applied if it exceeds wdrawLim and returns true
   * Otherwise method returns false and nothing is removed */
  public boolean withdrawATM(double x) {
    if (x + this.ATMFee <= this.acctBal) {
      withdraw(x + this.ATMFee);
      return true;
    } else {
      return false;
    }
  }
  
  /* method takes no inputs and returns nothing
   * if acctBal is less than minBal and draftFlag is false, 
     then balance is reduced by draft Fee, flag is set to true, no interest earned
   * if acctBal is less than minBal and draftFlag is true,
     no interest earned and nothing deducted
   * else, acctBal and interest are compounded, new interest calculated */
  public void incrementDay() {
    if(this.acctBal < this.minBal && !this.draftFlag) {
      this.acctBal = this.acctBal - this.draftFee;
      this.draftFlag = true;
    } else if(this.acctBal < this.minBal && this.draftFlag) {
    } else {
      this.intTotal = this.intTotal + (this.intTotal + this.acctBal) * (this.intRate / 365);
    }
  }
  
  /* method takes no inputs and returns nothing
   * intTotal is added to the balance, set to zero
   * overdraft flag set to false */
  public void incrementMonth() {
    this.acctBal = this.acctBal + this.intTotal;
    this.intTotal = 0;
    this.draftFlag = false;
  }
  
}
    
  
  
  

