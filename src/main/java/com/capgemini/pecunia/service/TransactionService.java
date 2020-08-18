package com.capgemini.pecunia.service;

import java.util.List;


import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransactionDetails;
import com.capgemini.pecunia.entity.TransferSlip;
import com.capgemini.pecunia.entity.WithdrawalSlip;
/****************************
 *          @author          Akshay
 *          Description      It is a service class that provides the services for Transaction .
  *         Version             1.0
  *         Created Date    7-AUG-2020
 ****************************/

public interface TransactionService {
	
	public TransactionDetails withdrawalMoneyBySlip(WithdrawalSlip slip) ;
	public TransactionDetails depositMoneyBySlip(DepositSlip slip) ;
	public List<TransactionDetails> showTransaction() ;
	public TransactionDetails withdrawalMoneyUsingCheque(Cheque cheque) ;
	public TransactionDetails transferMoneyUsingCheque(Cheque cheque,TransferSlip slip) ;
	public TransactionDetails depositChequeInAccount(Cheque cheque,DepositSlip slip) ;
	

}
