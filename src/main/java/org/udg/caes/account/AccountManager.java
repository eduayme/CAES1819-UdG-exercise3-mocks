package org.udg.caes.account;

public interface AccountManager {
  void updateAccount(Account acc);

  Account findAccount(String john);
}
