package com.ryan.banking;

public class TransferApi {

  double amountToTransfer;
  BankAccount sourceAccount;
  String transferMessage;

  public TransferApi theAmount(double amountToTransfer) {
    this.amountToTransfer = amountToTransfer;
    return this;
  }

  public TransferApi from(BankAccount sourceAccount) {
    this.sourceAccount = sourceAccount;
    return this;
  }

  public void to(BankAccount destinationAccount) {
    if (sourceAccount.getBalance() >= amountToTransfer) {
      sourceAccount.withdraw(amountToTransfer);
      destinationAccount.deposit(amountToTransfer);
    } else {
      this.transferMessage = "insufficient funds";
    }
  }

  public String getTransferMessage() {
    return transferMessage;
  }
}
