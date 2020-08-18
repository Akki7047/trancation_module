package com.capgemini.pecunia.testing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransactionDetails;
import com.capgemini.pecunia.entity.TransferSlip;
import com.capgemini.pecunia.exception.UserException;
import com.capgemini.pecunia.service.TransactionService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTesting {

	@Autowired
	TransactionService transactionService;
	
 
	
	@Test
	public void depositMoney() 
	{
		DepositSlip slip=new DepositSlip(1875662001,"VAISHALI TIWARI",1000);
		try {
			transactionService.depositMoneyBySlip(slip);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(),"Account not exists" );
		}
			
	}
	@Test
	public void depositMoney1() 
	{
		DepositSlip slip=new DepositSlip(1875662201,"VAISLI TIWARI",1000);
		try {
			transactionService.depositMoneyBySlip(slip);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(),"Account Holder Name is Not matched" );
		}
			
	}
	
	@Test
	public void depositMoney2() 
	{
		DepositSlip slip=new DepositSlip(1875662201,"VAISHALI TIWARI",1000);
		try {
			TransactionDetails t=transactionService.depositMoneyBySlip(slip);
			assertEquals(t,transactionService.depositMoneyBySlip(slip));
		} catch (UserException e) {
			// TODO Auto-generated catch block
			
		}
			
	}
	
	
	@Test
	public void withdrawalMoney() 
	{
		DepositSlip slip=new DepositSlip(1875662001,"VAISHALI TIWARI",1000);
		try {
			transactionService.depositMoneyBySlip(slip);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(),"Account not exists" );
		}
			
	}
	@Test
	public void withdrawalMoney1() 
	{
		DepositSlip slip=new DepositSlip(1875662201,"VAISLI TIWARI",1000);
		try {
			transactionService.depositMoneyBySlip(slip);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(),"Account Holder Name is Not matched" );
		}
			
	}
	
	/*@Test
	public void withdrawalMoney2() 
	{
		DepositSlip slip=new DepositSlip(1875662201,"VAISHALI TIWARI",1000);
		try {
			TransactionDetails t=transactionService.depositMoneyBySlip(slip);
			assertEquals(t,transactionService.depositMoneyBySlip(slip));
		} catch (UserException e) {
			// TODO Auto-generated catch block
		
		}
			
	}*/
	@Test
	public void withdrawalMoney3() 
	{
		DepositSlip slip=new DepositSlip(1875662201,"VAISHALI TIWARI",100000);
		try {
			TransactionDetails t=transactionService.depositMoneyBySlip(slip);
			
		} catch (UserException e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(),"LOW ACCOUNT BALANCE");
		
		}
			
	}
	//Any many exceptional test case based on account number,bank name,ifsc ,pay name.
	@Test
	public void withdrawCheque()
	{
		 Cheque cheque=new Cheque();
		cheque.setAccountNumber(1875662202);
	     cheque.setAmount(1000.00);
	     cheque.setBankName("PECUNIA");
	     cheque.setChequeNumber(117002);
	     cheque.setIssueDate(LocalDate.of(2020, 05, 01));
	     cheque.setIFSC("PUNB033950");
	     cheque.setPay("VAISHALI TIWARI");
	     try {
	    	 TransactionDetails t=transactionService.withdrawalMoneyUsingCheque(cheque);
	    	 assertEquals(t,transactionService.withdrawalMoneyUsingCheque(cheque));
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void depositCheque()
	{
		 Cheque cheque=new Cheque();
			cheque.setAccountNumber(1875662202);
		     cheque.setAmount(1000.00);
		     cheque.setBankName("PECUNIA");
		     cheque.setChequeNumber(117002);
		     cheque.setIssueDate(LocalDate.of(2020, 05, 01));
		     cheque.setIFSC("PUNB033950");
		     cheque.setPay("VAISHALI TIWARI");
		 	DepositSlip slip=new DepositSlip(1875662201,"VAISHALI TIWARI",100000);
		 	try {
		 		 TransactionDetails t=transactionService.depositChequeInAccount(cheque, slip);
				 assertEquals(t,transactionService.depositChequeInAccount(cheque, slip));
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	@Test
	public void transferCheque()
	{
		 Cheque cheque=new Cheque();
			cheque.setAccountNumber(1875662202);
		     cheque.setAmount(1000.00);
		     cheque.setBankName("PECUNIA");
		     cheque.setChequeNumber(117002);
		     cheque.setIssueDate(LocalDate.of(2020, 05, 01));
		     cheque.setIFSC("PUNB033950");
		     cheque.setPay("VAISHALI TIWARI");
		     
		 	TransferSlip slip1=new TransferSlip();
			slip1.setAccountHolderName("AMARDEEP SINGH");
			slip1.setAccountNumber(1875662205);
			slip1.setBankName("PECUNIA");
			slip1.setIFSC("PUNB033950");
			
			try {
				TransactionDetails t=transactionService.transferMoneyUsingCheque(cheque, slip1);
				 assertEquals(t,transactionService.transferMoneyUsingCheque(cheque, slip1));
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
