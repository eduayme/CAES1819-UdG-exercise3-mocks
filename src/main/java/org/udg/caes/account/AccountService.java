package org.udg.caes.account;

public class AccountService {
  private AccountManager accountManager;

  public void setAccountManager(AccountManager am) {
    accountManager = am;
  }

  public void transfer(String senderId, String beneficiaryId, long amount) {
    Account ben = this.accountManager.findAccount(beneficiaryId);
    Account sender = this.accountManager.findAccount(senderId);
    ben.credit(amount);
    sender.debit(amount);
    this.accountManager.updateAccount(ben);
    this.accountManager.updateAccount(sender);
  }
}
