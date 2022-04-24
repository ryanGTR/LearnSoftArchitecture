package com.ryan.unit;

import static org.assertj.core.api.Assertions.assertThat;

import com.ryan.banking.AccountType;
import com.ryan.banking.BankAccount;
import com.ryan.banking.Client;
import com.ryan.banking.TransferApi;
import org.junit.jupiter.api.Test;

public class TransferMoneyTest {

  private final Client client = new Client("Tess");
  TransferApi transfer = new TransferApi();

  @Test
  public void transfer_money_to_account() {
    client.opens(BankAccount.ofType(AccountType.valueOf("Current")).withBalance(1000));
    client.opens(BankAccount.ofType(AccountType.valueOf("Savings")).withBalance(2000));

    BankAccount sourceAccount = client.get(AccountType.valueOf("Current"));
    BankAccount destinationAccount = client.get(AccountType.valueOf("Savings"));
    transfer.theAmount(500).from(sourceAccount).to(destinationAccount);

    assertThat(sourceAccount.getBalance()).isEqualTo(500);
    assertThat(destinationAccount.getBalance()).isEqualTo(2500);
  }
}
