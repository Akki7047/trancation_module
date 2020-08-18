package com.capgemini.pecunia.controller;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.Data;
import com.capgemini.pecunia.entity.Data1;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransactionDetails;
import com.capgemini.pecunia.entity.withdrawalSlip;
import com.capgemini.pecunia.exception.UserException;
import com.capgemini.pecunia.service.TransactionService;


/****************************
 *          @author          Akshay 
 *          Description      It is a Rest full service class that provides the services for Transaction
  *         Version             1.0
  *         Created Date    12-APR-2020
  *         Finished Date   17-APR-2020
 ****************************/

//This crossOrgin helps us to connect with angular application.
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	/*
	 *RestFul Service For Deposit Money From Slip
	 */
	@PostMapping("/DepositUsingSlip")
	public ResponseEntity<String> DepositSlip(@RequestBody DepositSlip slip)   {
		System.out.println(slip.toString());
		
		if(!(slip.getAmount()>=100 && slip.getAmount()<=100000))
			throw new UserException("Amount Range In Between 100 to 100000");
				
			
		TransactionDetails transactionDetails = null;
		
				transactionDetails = transactionService.depositMoneyBySlip(slip);
			
		return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
	}
	/*
	 *RestFul Service For Withdrawal Money From Slip
	 */
	@PostMapping("/WithdrawingUsingSlip")
	public ResponseEntity<String>  WithdrawalSlip(@RequestBody withdrawalSlip slip)   {
		TransactionDetails transactionDetails = null;
		
		if(!(slip.getAmount()>=100 && slip.getAmount()<=100000))
			throw new UserException("Amount Range In Between 100 to 100000");
	
		
				transactionDetails = transactionService.withdrawalMoneyBySlip(slip);
			
		
		return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
	}
	
	/*
	 *  Getting Today's transaction history . 
	 */
	@GetMapping("/todayTransaction")
	public ResponseEntity<List<TransactionDetails>>todayTransaction() {
		List<TransactionDetails> transactionList=transactionService.showTransaction();
		return new ResponseEntity<List<TransactionDetails>>(transactionList,HttpStatus.OK);
	}
	/*
	 * Withdrawal money using cheque
	 */
	@PostMapping("/WithdrawingUsingCheque")
	public ResponseEntity<String>  withdrawalCheque(@RequestBody Cheque cheque)  {
		System.out.println(cheque);
		String []data;
		data=cheque.getIssuedate().split("-");
		int year = Integer.parseInt( data[0] );
		int month = Integer.parseInt( data[1] );  
		int day = Integer.parseInt( data[2] );
		LocalDate issueDate = LocalDate.of(year,month,day);
		cheque.setIssueDate(issueDate);
		Period p=Period.between(issueDate, LocalDate.now());
		if(!(cheque.getAmount()>=100 && cheque.getAmount()<=200000))
			throw new UserException("Amount Range In Between 100 to 100000");
		else if(!(p.getMonths()<3 && p.getMonths()>=0))
			throw new UserException("Cheque Expired Within Three Month");
		TransactionDetails transactionDetails = null;
	
			transactionDetails = transactionService.withdrawalMoneyUsingCheque(cheque);
		
		return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
	}
	
	/*
	 * Transfer money from one account to another using cheque and transfer slip(carry benificary details)
	 */
	@PostMapping("/TransferMoneyUsingCheque")
	public ResponseEntity<String>  transferCheque(@RequestBody Data1 data1)   {
		String []data;
		data=data1.getCheque().getIssuedate().split("-");
		int year = Integer.parseInt( data[0] );
		int month = Integer.parseInt( data[1] );  
		int day = Integer.parseInt( data[2] );
		LocalDate issueDate = LocalDate.of(year,month,day);
		data1.getCheque().setIssueDate(issueDate);
		
		Period p=Period.between(issueDate, LocalDate.now());
		if(!(data1.getCheque().getAmount()>=100 &&data1.getCheque().getAmount()<=200000))
			throw new UserException("Amount Range In Between 100 to 100000");
		else if(!(p.getMonths()<3 && p.getMonths()>=0))
			throw new UserException("Cheque Expired Within Three Month");
		TransactionDetails transactionDetails = null;
		
			transactionDetails = transactionService.transferMoneyUsingCheque(data1.getCheque(), data1.getTransferSlip());
			return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
		
	
	}
	
	@PostMapping("/DepositMoneyUsingChequee")
	public ResponseEntity<String>  depositCheque(@RequestBody Data data2)  {
		String []data;
		//if(data2.getDepositSlip().getAmount()==data2.getCheque().getAmount())
		//System.out.println(data2.getCheque().getAmount()+""+data2.getDepositSlip().getAmount());
		data=data2.getCheque().getIssuedate().split("-");
		int year = Integer.parseInt( data[0] );
		int month = Integer.parseInt( data[1] );  
		int day = Integer.parseInt( data[2] );
		LocalDate issueDate = LocalDate.of(year,month,day);
		data2.getCheque().setIssueDate(issueDate);
		TransactionDetails transactionDetails = null;
		Period p=Period.between(issueDate, LocalDate.now());
		if(!(data2.getCheque().getAmount()>=100 &&data2.getCheque().getAmount()<=200000))
			throw new UserException("Amount Range In Between 100 to 100000");
		else if(!(p.getMonths()<3 && p.getMonths()>=0))
			throw new UserException("Cheque Expired Within Three Month");
		//else if(data2.getDepositSlip().getAmount()==data2.getCheque().getAmount())
			//
			transactionDetails = transactionService.depositChequeInAccount(data2.getCheque(), data2.getDepositSlip());
			
		
		return new ResponseEntity<String>("Transaction Sucessful"+"\n"+"Transaction Id:"+transactionDetails.getTransactionId(),HttpStatus.OK);
		
	}
	
	
}
