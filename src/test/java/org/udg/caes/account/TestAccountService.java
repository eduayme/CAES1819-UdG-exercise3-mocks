package org.udg.caes.account;

import mockit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountService {

    @Mocked
    Account acc1;
    Account acc2;

    @BeforeEach
    void setup() {
        acc1 = new Account( "acc1", 200 );
        acc2 = new Account( "acc2", 400 );
    }

  @Test
  void testTransfer(@Tested AccountService as, @Mocked AccountManager am)  {

      new Expectations() {{
          am.findAccount("acc1"); result = acc1;
          am.findAccount("acc2"); result = acc2;
      }};

      as.setAccountManager( am );
      as.transfer("acc1", "acc2", 100);

      new Verifications() {{
          acc1.credit( 100 ); times = 1;
          acc2.debit( 100 ); times = 1;
      }};

      assertEquals( acc1.getBalance(), acc2.getBalance() );

  }
}