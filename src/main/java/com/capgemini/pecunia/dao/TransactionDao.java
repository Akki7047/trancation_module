package com.capgemini.pecunia.dao;

import java.util.List;

import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransactionDetails;
import com.capgemini.pecunia.entity.TransferSlip;
import com.capgemini.pecunia.entity.withdrawalSlip;

/****************************
 *          @author          Akshay
 *          Description      It is a service class that provides the services for Transaction  set and get information 
  *         Version             1.0
  *         Created Date    7-APR-2020
 ****************************/

public interface TransactionDao {
public void addAccount(AccountDetails account);
public boolean addTransaction(TransactionDetails transaction);
public List<TransactionDetails> showTransaction();
public boolean checkAccountNumber(long accountNumber);
public AccountDetails getAccountDetails(long accountNumber);
public boolean updateBalance(long accountNumber,double balance);
public TransactionDetails setTransactionDeails(AccountDetails accountDetails,withdrawalSlip slip);
public TransactionDetails setTransactionDeails1(AccountDetails accountDetails,DepositSlip slip);
public TransactionDetails setTransactionCheque(AccountDetails accountDetails,Cheque cheque);
public TransactionDetails setTranscationTransfer(AccountDetails accountDetails,Cheque cheque,TransferSlip slip);
public TransactionDetails setTranscationTransfer1(AccountDetails accountDetails,Cheque cheque,TransferSlip slip);
public TransactionDetails setTransactionDeails11(AccountDetails accountDetails,Cheque cheque,DepositSlip slip);
public TransactionDetails setTransactionDeails12(AccountDetails accountDetails,Cheque cheque,DepositSlip slip);
}
