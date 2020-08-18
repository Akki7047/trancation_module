package com.capgemini.pecunia.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.pecunia.dao.TransactionDao;
import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.DepositSlip;
import com.capgemini.pecunia.entity.TransactionDetails;
import com.capgemini.pecunia.entity.TransferSlip;
import com.capgemini.pecunia.entity.withdrawalSlip;
import com.capgemini.pecunia.exception.UserException;

/****************************
 *          @author          Akshay
 *          Description      It is a service class that provides the services for Transaction
  *         Version             1.0
  *         Created Date    07-APR-2020
 ****************************/

@Service
public class TransactionServiceImp implements TransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	/****************************
	 * Method: Withdrawal Money
                *Description: To withdrawal money from an account
	 * Slip Details       -Account Number,CurrentDate,Amount ,Holder Name
	 
	 * @throws AccountException - It is raised due to insufficient balance or invalid account Id or  
                                                                         server side validation
                *Created By                                - Akshay
                *Created Date                            - 11-AUG-2020                           
	 
	 ****************************/
	@Override
	public TransactionDetails withdrawalMoneyBySlip(withdrawalSlip slip)  {
		
	
		if(transactionDao.checkAccountNumber(slip.getAccountNumber()))
		{
			AccountDetails accountDetails=transactionDao.getAccountDetails(slip.getAccountNumber());
			
			if(accountDetails.getAccountHolderName().equals(slip.getAccountHolderName()))
			{
				if(accountDetails.getAccountBalance()>=slip.getAmount())
				{
					transactionDao.updateBalance(accountDetails.getAccountNumber(),(accountDetails.getAccountBalance()-slip.getAmount()));
					return transactionDao.setTransactionDeails(accountDetails, slip);
					 
				}
				else
				{
					System.out.println("Low Balance");
					throw new UserException("LOW ACCOUNT BALANCE");
				}
			}
			else
			{
				System.out.println("Account Holder Name is Not matched");
				throw new UserException("Account Holder Name is Not matched");
			}
		}
		else
		{
			System.out.println("Account not exists");
			throw new UserException("Account not exists");
		}
	
	}
	
	

	/****************************
	 * Method: Deposit Money
                *Description: To withdrawal money from an account
	 * Slip Details       -Account Number,CurrentDate,Amount ,Holder Name
	 
	 * @throws AccountException - invalid account Id or Invalid HolderName 
                                                    server side validation
                *Created By                                - Akshay
                *Created Date                            - 11-AUG-2020                           
	 
	 ****************************/

	@Override
	public TransactionDetails depositMoneyBySlip(DepositSlip slip)  {
		
		System.out.println(slip.getAccountNumber());
		if(transactionDao.checkAccountNumber(slip.getAccountNumber()))
		{
			AccountDetails accountDetails=transactionDao.getAccountDetails(slip.getAccountNumber());
			
			if(accountDetails.getAccountHolderName().equals(slip.getAccountHolderName()))
			{
					transactionDao.updateBalance(accountDetails.getAccountNumber(),(accountDetails.getAccountBalance()+slip.getAmount()));
					return transactionDao.setTransactionDeails1(accountDetails, slip);
					 
				
			}
			else
			{
				System.out.println("Account Holder Name is Not matched");
				throw new UserException("Account Holder Name is Not matched");
				
			}
		}
		else
		{
			System.out.println("Account not exists");
			throw new UserException("Account not exists");
		}
	
		

	}
	
	/****************************
	 * Method: Daily Transaction Report
                *Description: To withdrawal money from an account
	
    *Created By                               -Akshay
    *Created Date                            - 12-AUG-2020                           
	 
	 ****************************/

	@Override
	public List<TransactionDetails> showTransaction() {
		
		return transactionDao.showTransaction() ;
	}
	
	
	/****************************
	 * Method: Withdrawal Money Using Cheque
                *Description: To withdrawal money from an account
	 * Cheque Details       -Account Number,CurrentDate,Amount ,Holder Name,IFSC ,Issue Date
	 
	 * @throws AccountException - invalid account Id or Invalid HolderName,cheque number 
                                                    server side validation
                *Created By                                - Akshay
                *Created Date                            - 13-AUG-2020                           
	 
	 ****************************/

	@Override
	public TransactionDetails withdrawalMoneyUsingCheque(Cheque cheque)  {
	
		if(transactionDao.checkAccountNumber(cheque.getAccountNumber()))
		{
			AccountDetails accountDetails=transactionDao.getAccountDetails(cheque.getAccountNumber());
			if(accountDetails.getChequeNumber()==(cheque.getChequeNumber())) {
		
				
			if(accountDetails.getAccountHolderName().equals(cheque.getPay()))
			{
				if(accountDetails.getAccountBalance()>=cheque.getAmount())
				{
					transactionDao.updateBalance(accountDetails.getAccountNumber(),(accountDetails.getAccountBalance()-cheque.getAmount()));
					return transactionDao.setTransactionCheque(accountDetails, cheque);
					
					 
				}
				else
				{
					System.out.println("Low Balance");
					throw new UserException("Low Balance");
				}
			}
			else
			{
				System.out.println("Account Holder Name is Not matched");
				throw new UserException("Account Holder Name is Not matched");
			}
		
		
		}
			else
			{
				System.out.println("Cheque Number is Wrong");	
				throw new UserException("Cheque Number is Wrong");
			}
		}
		else
		{
			System.out.println("Account not exists");
			throw new UserException("Account not exists");
		}
		
	}
	
	
	/****************************
	 * Method: Transfer Money Using Cheque With the help of Transfer Slip that carry benificary Details.
                *Description: To withdrawal money from an account
	 * Cheque Details       -Account Number,CurrentDate,Amount ,Holder Name,IFSC ,Issue Date
	 * Transfer Slip        -Account number,IFSC,Amount.
	 
	 * @throws AccountException - invalid account Id or Invalid HolderName,cheque number 
                                                    server side validation
                *Created By                                -Akshay
                *Created Date                            - 14-AUG-2020                           
	 
	 ****************************/

	@Override
	public TransactionDetails transferMoneyUsingCheque(Cheque cheque, TransferSlip slip) throws UserException {
		
		

		if(transactionDao.checkAccountNumber(cheque.getAccountNumber()))
		{
		
			AccountDetails accountDetails=transactionDao.getAccountDetails(cheque.getAccountNumber());
			//System.out.println(accountDetails.getChequeNumber()+" "+cheque.getChequeNumber());
			if(accountDetails.getChequeNumber()==cheque.getChequeNumber()) {
			
		
			
				if(accountDetails.getAccountBalance()>=cheque.getAmount())
				{
					transactionDao.updateBalance(accountDetails.getAccountNumber(),(accountDetails.getAccountBalance()-cheque.getAmount()));
				if(slip.getBankName().equals("PECUNIA"))
				{
					if(transactionDao.checkAccountNumber(slip.getAccountNumber()))
					{
						AccountDetails accountDetails1=transactionDao.getAccountDetails(slip.getAccountNumber());
						
							if(accountDetails1.getAccountHolderName().equals(cheque.getPay()))
							{
								transactionDao.setTranscationTransfer1(accountDetails, cheque, slip);
								transactionDao.updateBalance(accountDetails.getAccountNumber(),(accountDetails.getAccountBalance()+cheque.getAmount()));
								
								return transactionDao.setTranscationTransfer(accountDetails, cheque, slip);
							}
							else
							{
								System.out.println("cheque is not belong to Benificary Person");
								throw new UserException("cheque is not belong to Benificary Person");
							}
							
						
						
					}
					else
					{
						System.out.println("Benificary Account not exists");
						throw new UserException("Benificary Account not exists");
					}
				}
				else
				{
					
					//We assume that the information written in slip for other bank is correct.
					return transactionDao.setTranscationTransfer(accountDetails, cheque, slip);
				}
					
					
					 
				}
				else
				{
					System.out.println("Low Balance");
					throw new UserException("Low Balance");
				}
		
		
		
		}
			else
			{
				System.out.println("Cheque Number is Wrong");	
				throw new UserException("Account not exists");
			}
		}
		else
		{
			System.out.println("Account not exists");
			throw new UserException("Account not exists");
		}
	
		
	}
	
	
	/****************************
	 * Method:Deposit cheque to credited the Account using deposit slip where the account details is mention.
                *Description: To withdrawal money from an account
	 * Cheque Details       -Account Number,CurrentDate,Amount ,Holder Name,IFSC ,Issue Date
	 * Deposit Slip        -Account number,IFSC,HolderName.
	 
	 * @throws AccountException - invalid account Id or Invalid HolderName,cheque number 
                                                    server side validation
                *Created By                                - Akshay
                *Created Date                            - 14-AUG-2020                           
	 
	 ****************************/
	@Override
	public TransactionDetails depositChequeInAccount(Cheque cheque, DepositSlip slip) {
		
		
        if(cheque.getBankName().equals("PECUNIA"))
        {

        	if(cheque.getPay().equals(slip.getAccountHolderName()))
        	{
        	if(transactionDao.checkAccountNumber(slip.getAccountNumber()))
    		{
        	AccountDetails accountDetails=transactionDao.getAccountDetails(slip.getAccountNumber());
        	if(transactionDao.checkAccountNumber(cheque.getAccountNumber()))
        	{
        		AccountDetails accountDetails1=transactionDao.getAccountDetails(cheque.getAccountNumber());
        		if(accountDetails1.getChequeNumber()==cheque.getChequeNumber()) {
        			if(accountDetails1.getAccountBalance()>=slip.getAmount())
        			{
        				transactionDao.updateBalance(accountDetails.getAccountNumber(),(accountDetails.getAccountBalance()+cheque.getAmount()));
            			transactionDao.updateBalance(accountDetails1.getAccountNumber(),(accountDetails1.getAccountBalance()-cheque.getAmount()));
        				transactionDao.setTransactionDeails12(accountDetails1, cheque, slip);
        				return transactionDao.setTransactionDeails11(accountDetails, cheque, slip);
        				
        			}
        			else
        			{
        				System.out.println("cheque holder has low amount");
        				throw new UserException("cheque holder has low amount");
        			}
        			
        			
        		
        		
        	}
        		else
        		{
        			System.out.println("Cheque Number is Wrong");
        			throw new UserException("Cheque Number is Wrong");
        		}
        	}
        	else
        	{
        		System.out.println("cheque Account Not Exists in  our bank");
        		throw new UserException("cheque Account Not Exists in  our bank");
        	}
        }
        	else
        	{
        		System.out.println("Holder Account Not Exists in not our bank");
        		throw new UserException("Holder Account Not Exists in not our bank");
        	}
        }
        	else
        	{
        		System.out.println("Cheque belong the another person");
        		throw new UserException("Cheque belong the another person");
        	}
        }
        
        else
        {
        	if(cheque.getPay().equals(slip.getAccountHolderName()))
        	{
        		if(transactionDao.checkAccountNumber(slip.getAccountNumber()))
        		{
        			AccountDetails accountDetails=transactionDao.getAccountDetails(slip.getAccountNumber());
        			transactionDao.updateBalance(accountDetails.getAccountNumber(),(accountDetails.getAccountBalance()+cheque.getAmount()));
        			return transactionDao.setTransactionDeails11(accountDetails, cheque, slip);
        		}
        		else
        		{
        			System.out.println("Holder Account Not Exists in not our bank");
        			throw new UserException("Holder Account Not Exists in not our bank");
        		}
        		
        	}
        	else
        	{
        		System.out.println("Cheque belong the another person");
        		throw new UserException("Cheque belong the another person");
        	}
        }
	
	}
	
	
	
	

}
