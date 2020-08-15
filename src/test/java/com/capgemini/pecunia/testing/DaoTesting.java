package com.capgemini.pecunia.testing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.pecunia.dao.TransactionDao;
import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.TransactionDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTesting {
	
	@Autowired
	TransactionDao transactionDao;
	
	@Test
	public void addDemoAccount()
	{
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
		transactionDao.addAccount(account1);
		assertEquals(account1,transactionDao.getAccountDetails(1875662201) );
	}
	@Test
	public void checkAccount()
	{
		boolean value=true;
		assertEquals(transactionDao.checkAccountNumber(1875662201),value);
	}
	@Test
	public void checkAccount1()
	{
		boolean value=false;
		assertEquals(transactionDao.checkAccountNumber(1875662228),value);
	}
	
	@Test
	public void checkUpdateBalance()
	{
		boolean value=true;
		assertEquals(transactionDao.updateBalance(1875662201,1000),value);
	}

	@Test
	public void checkUpdateBalance1()
	{
		boolean value=false;
		assertEquals(transactionDao.updateBalance(1875662228,1000),value);
	}
	
	@Test
	public void setTransaction()
	{
		boolean value=true;
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(117001);
		transaction.setTransactionAmount(1000);
		transaction.setBankName("PECUNIA");
		transaction.setBenificaryAccoountNumber(1875662201);
		transaction.setBenificaryName("VAISHALI TIWARI");
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionType("CREDIT");
		transaction.setTransactionStatus("Sucessful");
		transaction.setTransactionOption("Cheque");
		transaction.setCurrent_Balance(26000);
	
		assertEquals(transactionDao.addTransaction(transaction),value);
		
	}

}
