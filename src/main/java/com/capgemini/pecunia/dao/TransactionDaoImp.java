package com.capgemini.pecunia.dao;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransactionDetails;
import com.capgemini.pecunia.entity.TransferSlip;
import com.capgemini.pecunia.entity.withdrawalSlip;


/****************************
 *          @author          Satyam Sinha
 *          Description      It is a service class that provides the services for Transaction  set and get information 
  *         Version             1.0
  *         Created Date    11-APR-2020
 ****************************/

@Transactional
@Repository
public class TransactionDaoImp implements TransactionDao {

	@PersistenceContext
	EntityManager em;
	/*
	 * Add Account for show the Transaction in Bank.
	 */
	@Override
	public void addAccount(AccountDetails account) {
		// TODO Auto-generated method stub
		em.persist(account);
		
	}
	//add transaction
	@Override
	public boolean addTransaction(TransactionDetails transaction) {
		// TODO Auto-generated method stub
		em.persist(transaction);
		return true;
	}
	//get list of today's transaction
	@Override
	public List<TransactionDetails> showTransaction() {
		// TODO Auto-generated method stub
				Query query=em.createQuery("select t from TransactionDetails t where t.transactiondate=:dateParam");
				
				query.setParameter("dateParam", LocalDate.now());
				return query.getResultList();
	}
	//check account exist or not
	@Override
	public boolean checkAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		return em.contains(em.find(AccountDetails.class,accountNumber));
		
	}
	
	//get details of an account
	@Override
	public AccountDetails getAccountDetails(long accountNumber) {
		// TODO Auto-generated method stub
		return em.find(AccountDetails.class,accountNumber);
	}
	//update balance in an account
	@Override
	public boolean updateBalance(long accountNumber, double balance) {
		// TODO Auto-generated method stub
		if(em.contains(em.find(AccountDetails.class,accountNumber))) {
		em.find(AccountDetails.class,accountNumber).setAccountBalance(balance);
		return true;
		}
		return false;
	}
	//set transaction statement by slip withdrawal
	@Override
	public TransactionDetails setTransactionDeails(AccountDetails accountDetails, withdrawalSlip slip) {
		// TODO Auto-generated method stub
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setTransactionAmount(slip.getAmount());
		transaction.setBankName("PECUNIA");
		transaction.setBenificaryName(slip.getAccountHolderName());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionType("DEBIT");
		transaction.setTransactionStatus("Sucessful");
		transaction.setTransactionOption("Slip");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()-slip.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by slip deposit
	@Override
	public TransactionDetails setTransactionDeails1(AccountDetails accountDetails, DepositSlip slip) {
		// TODO Auto-generated method stub
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setTransactionAmount(slip.getAmount());
		transaction.setBankName("PECUNIA");
		transaction.setBenificaryName(slip.getAccountHolderName());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionType("CREDIT");
		transaction.setTransactionStatus("Sucessful");
		transaction.setTransactionOption("Slip");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()+slip.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque withdrawal
	@Override
	public TransactionDetails setTransactionCheque(AccountDetails accountDetails, Cheque cheque) {
		// TODO Auto-generated method stub
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName("PECUNIA");
		transaction.setBenificaryName(cheque.getPay());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionType("DEBIT");
		transaction.setTransactionStatus("Sucessful");
		transaction.setTransactionOption("Cheque");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()-cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque transfer
	
	@Override
	public TransactionDetails setTranscationTransfer(AccountDetails accountDetails, Cheque cheque, TransferSlip slip) {
	
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName("PECUNIA");
		transaction.setBenificaryAccoountNumber(slip.getAccountNumber());
		transaction.setBenificaryName(cheque.getPay());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionType("DEBIT");
		transaction.setTransactionStatus("Sucessful");
		transaction.setTransactionOption("Cheque");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()-cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque transfer
	@Override
	public TransactionDetails setTranscationTransfer1(AccountDetails accountDetails, Cheque cheque, TransferSlip slip) {
		// TODO Auto-generated method stub
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(cheque.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName("PECUNIA");
		transaction.setBenificaryAccoountNumber(slip.getAccountNumber());
		transaction.setBenificaryName(cheque.getPay());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionType("CREDIT");
		transaction.setTransactionStatus("Sucessful");
		transaction.setTransactionOption("Cheque");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()+cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque deposit
	@Override
	public TransactionDetails setTransactionDeails11(AccountDetails accountDetails, Cheque cheque, DepositSlip slip) {
		// TODO Auto-generated method stub
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(cheque.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName(cheque.getBankName());
		transaction.setBenificaryAccoountNumber(slip.getAccountNumber());
		transaction.setBenificaryName(accountDetails.getAccountHolderName());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionType("CREDIT");
		transaction.setTransactionStatus("Sucessful");
		transaction.setTransactionOption("Cheque");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()+cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque deposit
	@Override
	public TransactionDetails setTransactionDeails12(AccountDetails accountDetails, Cheque cheque, DepositSlip slip) {
		// TODO Auto-generated method stub
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(cheque.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName(cheque.getBankName());
		transaction.setBenificaryAccoountNumber(slip.getAccountNumber());
		transaction.setBenificaryName(cheque.getPay());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionType("DEBIT");
		transaction.setTransactionStatus("Sucessful");
		transaction.setTransactionOption("Cheque");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()-cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}

}
