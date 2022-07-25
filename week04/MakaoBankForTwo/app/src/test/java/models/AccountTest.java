package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account myAccount = new Account("123-456-7890", 1000, List.of("송금,200"));
    Account otherAccount = new Account("345-678-9012", 3000, List.of("입금,200"));

    assertEquals("123-456-7890", myAccount.identifier());
    assertEquals(1000, myAccount.amount());
    assertEquals("송금,200", myAccount.transactions().get(0));

    assertEquals("345-678-9012", otherAccount.identifier());
    assertEquals(3000, otherAccount.amount());
    assertEquals("입금,200", otherAccount.transactions().get(0));
  }
}
