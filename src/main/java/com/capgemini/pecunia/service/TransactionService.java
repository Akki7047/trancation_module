package com.capgemini.pecunia.service;

import java.util.List;


import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransactionDetails;
import com.capgemini.pecunia.entity.TransferSlip;
import com.capgemini.pecunia.entity.withdrawalSlip;
import com.capgemini.pecunia.exception.UserException;
/****************************
 *          @author          Satyam Sinha
 *          Description      It is a service class that provides the services for Transaction .
  *         Version             1.0
  *         Created Date    7-APR-2020
 ****************************/

public interface TransactionService {
	
	public TransactionDetails withdrawalMoneyBySlip(withdrawalSlip slip) throws UserException;
	public TransactionDetails depositMoneyBySlip(DepositSlip slip) throws UserException;
	public List<TransactionDetails> showTransaction() ;
	public TransactionDetails withdrawalMoneyUsingCheque(Cheque cheque) throws UserException;
	public TransactionDetails transferMoneyUsingCheque(Cheque cheque,TransferSlip slip) throws UserException;
	public TransactionDetails depositChequeInAccount(Cheque cheque,DepositSlip slip) throws UserException;
	

}
