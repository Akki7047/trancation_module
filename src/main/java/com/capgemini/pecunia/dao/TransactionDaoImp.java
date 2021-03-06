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
import com.capgemini.pecunia.entity.WithdrawalSlip;


/****************************
 *          @author          Akshay
 *          Description      It is a service class that provides the services for Transaction  set and get information 
  *         Version             1.0
  *         Created Date    11-AUG-2020
 ****************************/

@Transactional
@Repository
public class TransactionDaoImp implements TransactionDao {
	private String pec="PECUNIA";
	private String deb="DEBIT";
	private String suc="Sucessful";
	private String crd="CREDIT";
	private String chq="Cheque";

	@PersistenceContext
	EntityManager em;
	/*
	 * Add Account for show the Transaction in Bank.
	 */
	@Override
	public void addAccount(AccountDetails account) {
		
		em.persist(account);
		
	}
	//add transaction
	@Override
	public boolean addTransaction(TransactionDetails transaction) {
		
		em.persist(transaction);
		return true;
	}
	//get list of today's transaction
	@Override
	public List<TransactionDetails> showTransaction() {
		
				Query query=em.createQuery("select t from TransactionDetails t where t.transactiondate=:dateParam");
				
				query.setParameter("dateParam", LocalDate.now());
				return query.getResultList();
	}
	//check account exist or not
	@Override
	public boolean checkAccountNumber(long accountNumber) {
		
		return em.contains(em.find(AccountDetails.class,accountNumber));
		
	}
	
	//get details of an account
	@Override
	public AccountDetails getAccountDetails(long accountNumber) {
		
		return em.find(AccountDetails.class,accountNumber);
	}
	//update balance in an account
	@Override
	public boolean updateBalance(long accountNumber, double balance) {
				if(em.contains(em.find(AccountDetails.class,accountNumber))) {
		em.find(AccountDetails.class,accountNumber).setAccountBalance(balance);
		return true;
		}
		return false;
	}
	//set transaction statement by slip withdrawal
	@Override
	public TransactionDetails setTransactionDeails(AccountDetails accountDetails, WithdrawalSlip slip) {
		
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setTransactionAmount(slip.getAmount());
		transaction.setBankName(pec);
		transaction.setBenificaryName(slip.getAccountHolderName());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setUserTransactionDate(LocalDate.now());
		transaction.setTransactionType(deb);
		transaction.setTransactionStatus(suc);
		transaction.setTransactionOption("Slip");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()-slip.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by slip deposit
	@Override
	public TransactionDetails setTransactionDeails1(AccountDetails accountDetails, DepositSlip slip) {
		
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setTransactionAmount(slip.getAmount());
		transaction.setBankName(pec);
		transaction.setBenificaryName(slip.getAccountHolderName());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setUserTransactionDate(LocalDate.now());
		transaction.setTransactionType(crd);
		transaction.setTransactionStatus(suc);
		transaction.setTransactionOption("Slip");
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()+slip.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque withdrawal
	@Override
	public TransactionDetails setTransactionCheque(AccountDetails accountDetails, Cheque cheque) {
		
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(accountDetails.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName(pec);
		transaction.setBenificaryName(cheque.getPay());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setUserTransactionDate(LocalDate.now());
		transaction.setTransactionType(deb);
		transaction.setTransactionStatus(suc);
		transaction.setTransactionOption(chq);
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
		transaction.setBankName(pec);
		transaction.setBenificaryAccoountNumber(slip.getAccountNumber());
		transaction.setBenificaryName(cheque.getPay());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setUserTransactionDate(LocalDate.now());
		transaction.setTransactionType(deb);
		transaction.setTransactionStatus(suc);
		transaction.setTransactionOption(chq);
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()-cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque transfer
	@Override
	public TransactionDetails setTranscationTransfer1(AccountDetails accountDetails, Cheque cheque, TransferSlip slip) {
		
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(cheque.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName(pec);
		transaction.setBenificaryAccoountNumber(slip.getAccountNumber());
		transaction.setBenificaryName(cheque.getPay());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setUserTransactionDate(LocalDate.now());
		transaction.setTransactionType(crd);
		transaction.setTransactionStatus(suc);
		transaction.setTransactionOption(chq);
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()+cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque deposit
	@Override
	public TransactionDetails setTransactionDeails11(AccountDetails accountDetails, Cheque cheque, DepositSlip slip) {
		
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(cheque.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName(cheque.getBankName());
		transaction.setBenificaryAccoountNumber(slip.getAccountNumber());
		transaction.setBenificaryName(accountDetails.getAccountHolderName());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setUserTransactionDate(LocalDate.now());
		transaction.setTransactionType(crd);
		transaction.setTransactionStatus(suc);
		transaction.setTransactionOption(chq);
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()+cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}
	//set transaction statement by cheque deposit
	@Override
	public TransactionDetails setTransactionDeails12(AccountDetails accountDetails, Cheque cheque, DepositSlip slip) {
		
		TransactionDetails transaction=new TransactionDetails();
		transaction.setAccountNumber(cheque.getAccountNumber());
		transaction.setTransactionAmount(cheque.getAmount());
		transaction.setBankName(cheque.getBankName());
		transaction.setBenificaryAccoountNumber(slip.getAccountNumber());
		transaction.setBenificaryName(cheque.getPay());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setUserTransactionDate(LocalDate.now());
		transaction.setTransactionType(deb);
		transaction.setTransactionStatus(suc);
		transaction.setTransactionOption(chq);
		transaction.setCurrent_Balance(accountDetails.getAccountBalance()-cheque.getAmount());
		em.persist(transaction);
		return transaction;
	}

}
