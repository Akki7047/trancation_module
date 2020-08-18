package com.capgemini.pecunia;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.pecunia.dao.TransactionDao;
import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransferSlip;
import com.capgemini.pecunia.service.TransactionService;
/****************************
 *          @author          Akshay
 *          Description      It is a Main class.
  *         Version             1.0
  *         Created Date    7-APR-2020
 ****************************/

@SpringBootApplication
public class PecuniaBankApplication implements CommandLineRunner {
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	TransactionService transactionService;
	Logger logger =LoggerFactory.getLogger(PecuniaBankApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		/*
		 * Sample Account Details.
		 */
		//Account 1
		AccountDetails account1=new AccountDetails();
		account1.setAccountHolderName("VAISHALI TIWARI");
		account1.setAccountStatus("Active");
		account1.setAccountBalance(25000);
		account1.setCreditScore(800);
		account1.setAccountInterest(3);
		account1.setDate(LocalDate.of(2020, 05, 01));
		account1.setBranchdetails(118001);
		account1.setIFSC("PUNB033950");
		account1.setChequeNumber(117001);
		
		     //Account 2
				AccountDetails account2=new AccountDetails();
				account2.setAccountHolderName("PRABHJNOT SAINI");
				account2.setAccountStatus("Active");
				account2.setAccountBalance(15000);
				account2.setCreditScore(750);
				account2.setAccountInterest(3);
				account2.setDate(LocalDate.of(2020, 03, 01));
				account2.setBranchdetails(118001);
				account2.setIFSC("PUNB033950");
				account2.setChequeNumber(117002);
				
				
				//Account 3
				AccountDetails account3=new AccountDetails();
				account3.setAccountHolderName("SATYAM SINHA");
				account3.setAccountStatus("Saving");
				account3.setAccountBalance(20000);
				account3.setCreditScore(900);
				account3.setAccountInterest((float) 3.5);
				account3.setDate(LocalDate.of(2020, 03, 11));
				account3.setBranchdetails(118001);
				account3.setIFSC("PUNB033950");
				account3.setChequeNumber(117003);
				
				//Account 4
				AccountDetails account4=new AccountDetails();
				account4.setAccountHolderName("PRANAV SINHA");
				account4.setAccountStatus("Saving");
				account4.setAccountBalance(12000);
				account4.setCreditScore(1000);
				account4.setAccountInterest((float) 3.5);
				account4.setDate(LocalDate.of(2020, 04, 11));
				account4.setBranchdetails(118001);
				account4.setIFSC("PUNB033950");
				account4.setChequeNumber(117004);
				
				
				//Account 5
				AccountDetails account5=new AccountDetails();
				account5.setAccountHolderName("AMARDEEP SINGH");
				account5.setAccountStatus("Saving");
				account5.setAccountBalance(15000);
				account5.setCreditScore(750);
				account5.setAccountInterest((float) 3.5);
				account5.setDate(LocalDate.of(2020, 04, 01));
				account5.setBranchdetails(118001);
				account5.setIFSC("PUNB033950");
				account5.setChequeNumber(117005);
				
				
				/*
				 * Add account in database for Transaction Operation
				 */
				transactionDao.addAccount(account1);
				transactionDao.addAccount(account2);
				transactionDao.addAccount(account3);
				transactionDao.addAccount(account4);
				transactionDao.addAccount(account5);
				
				
				DepositSlip slip=new DepositSlip(1875662201,"VAISHALI TIWARI",1000);
				logger.info(slip.toString());
			
				
				
				
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
				
	}

}
