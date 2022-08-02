package services;

import models.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void transfer() {
    Account account1;
    Account account2;
    List<Account> accounts = List.of(
    account1 = new Account("1234","ashal",3000),
    account2 = new Account("2345","joker",500)
        );

    TransferService transferService = new TransferService(accounts);
    transferService.transfer("1234","2345",1000);
    assertEquals(2000,account1.amount());
    assertEquals(1500,account2.amount());
  }

}