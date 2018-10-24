package org.udg.caes.account;

public class Account {
  private String id;
  private long balance;

  public Account(String id, long balance) {
    this.id = id;
    this.balance = balance;
  }

  public void debit(long amount) {
    balance -= amount;
  }

  public void credit(long amount) {
    balance += amount;
  }

  public long getBalance() { return balance; }
}
