// Lilith Freed, laf70

public class Account {
  
  /* first name */
  private String firstName;
  
  /* last name */
  private String lastName;
  
  /* street address */
  private String streetAddress;
  
  /* zipcode */
  private String zipcode;
  
  /* date associated with account */
  private Date date;
  
  /* savings account */
  private BankAccount savingsAccount;
  
  /* checking account */
  private BankAccount checkingAccount;
  
  /* money market account */
  private BankAccount marketAccount;
  
  /* credit card account */
  private CreditCardAccount creditCardAccount;
  
  /* Constructor with given values */
  public Account(String firstName, String lastName, Date date) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.date = date;
  }
  
  /* returns first name */
  public String getFirstName() {
    return this.firstName;
  }
  
  /* sets first name */
  public void setFirstName(String s) {
    this.firstName = s;
  }
  
  /* returns last name */
  public String getLastName() {
    return this.lastName;
  }
  
  /* sets last name */
  public void setLastName(String s) {
    this.lastName = s;
  }
  
  /* returns street address */
  public String getStreetAddress() {
    return this.streetAddress;
  }
  
  /* sets street address */
  public void setStreetAddress(String s) {
    this.streetAddress = s;
  }
  
  /* returns zip code */
  public String getZipCode() {
    return this.zipcode;
  }
  
  /* sets zip code */
  public void setZipCode(String s) {
    this.zipcode = s;
  }
  
  /* returns savings account object */
  public BankAccount getSavingsAccount() {
    return this.savingsAccount;
  }
  
  /* sets savings account object */
  public void setSavingsAccount(BankAccount account) {
    this.savingsAccount = account;
  }
  
  /* returns checking account object */
  public BankAccount getCheckingAccount() {
    return this.checkingAccount;
  }
  
  /* sets checking account object */
  public void setCheckingAccount(BankAccount account) {
    this.checkingAccount = account;
  }
  
  /* returns money market account object */
  public BankAccount getMoneyMarketAccount() {
    return this.marketAccount;
  }
  
  /* sets money market account object */
  public void setMoneyMarketAccount(BankAccount account) {
    this.marketAccount = account;
  }
  
  /* returns credit card account object */
  public CreditCardAccount getCreditCardAccount() {
    return this.creditCardAccount;
  }
  
  /* sets credit card account object */
  public void setCreditCardAccount(CreditCardAccount account) {
    this.creditCardAccount = account;
  }
  
  /* returns date associated with account */
  public Date getDate() {
    return this.date;
  }
  
  /* sets date associated with account */
  public void setDate(Date date) {
    this.date = date;
  }
  
  /* helper method for checking for new month */
  private boolean isNewMonth(int oldMonth, Date date) {
    if(oldMonth == 12 && date.getMonth() == 1) {
      return true;
    } else if(oldMonth < date.getMonth()) {
      return true;
    } else {
      return false;
    }
  }
  
  /* calls incrementDay on associated date
   * calls incrementDay for each account that is not null
   * if the month changes, call incrementMonth for each account that is not null */
  public void incrementDay() {
    int oldMonth = this.date.getMonth();
    this.date.incrementDay();
    boolean isNewMonth = this.isNewMonth(oldMonth, this.date);
    if(this.savingsAccount != null) {
      this.savingsAccount.incrementDay();
      if(isNewMonth) {
        this.savingsAccount.incrementMonth();
      }
    }
    if(this.checkingAccount != null) {
      this.checkingAccount.incrementDay();
      if(isNewMonth) {
        this.checkingAccount.incrementMonth();
      }
    }
    if(this.marketAccount != null) {
      this.marketAccount.incrementDay();
      if(isNewMonth) {
        this.marketAccount.incrementMonth();
      }
    }
    if(this.creditCardAccount != null) {
      this.creditCardAccount.incrementDay();
      if(isNewMonth) {
        this.creditCardAccount.incrementMonth();
      }
    }
  }
  
}