package com.capgemini.pecunia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name="Accounts")
public class AccountDetails {
	
	@Id 
	@Column(name="Account_number")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genName1")
	@SequenceGenerator(name="genName1", sequenceName="acc",initialValue=1875662201,allocationSize=1)
	private long accountNumber;
	
	@Column(name="Customer_ID")
	private long customerDetails;
	
	@Column(name="Account_Holder_Name",unique = true, nullable = false)
	private String accountHolderName;
	
	@Column(name="Account_Status",nullable = false)
	private String accountStatus;
	
	@Column(name="Account_Balance", nullable = false)
	private double accountBalance;

	@Column(name="Credit_Score", nullable = false)
	private int creditScore;
	
	@Column(name="Account_Interest", nullable = false)
	private float accountInterest;
	
	@Column(name="Opening_Date", nullable = false)
	private LocalDate date;
	
	@Column(name="Branch_Id", nullable = false) 
	private long branchdetails;
	
	@Column(name="Cheque_Number",unique = true, nullable = false)
	private long chequeNumber;
	
	@Column(name="IFSC", nullable = false)
	private String IFSC;

	/**
	 * @return the iFSC
	 */
	public String getIFSC() {
		return IFSC;
	}

	/**
	 * @param iFSC the iFSC to set
	 */
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the customerDetails
	 */
	public long getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * @param customerDetails the customerDetails to set
	 */
	public void setCustomerDetails(long customerDetails) {
		this.customerDetails = customerDetails;
	}

	/**
	 * @return the accountHolderName
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}

	/**
	 * @param accountHolderName the accountHolderName to set
	 */
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	/**
	 * @return the accountStatus
	 */
	public String getAccountStatus() {
		return accountStatus;
	}

	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	/**
	 * @return the accountBalance
	 */
	public double getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	/**
	 * @return the creditScore
	 */
	public int getCreditScore() {
		return creditScore;
	}

	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	/**
	 * @return the accountInterest
	 */
	public float getAccountInterest() {
		return accountInterest;
	}

	/**
	 * @param accountInterest the accountInterest to set
	 */
	public void setAccountInterest(float accountInterest) {
		this.accountInterest = accountInterest;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the branchdetails
	 */
	public long getBranchdetails() {
		return branchdetails;
	}

	/**
	 * @param branchdetails the branchdetails to set
	 */
	public void setBranchdetails(long branchdetails) {
		this.branchdetails = branchdetails;
	}

	/**
	 * @return the chequeNumber
	 */
	public long getChequeNumber() {
		return chequeNumber;
	}

	/**
	 * @param chequeNumber the chequeNumber to set
	 */
	public void setChequeNumber(long chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	public AccountDetails() {
		super();
	}
	
	

	public AccountDetails(long accountNumber, long customerDetails, String accountHolderName, String accountStatus,
			double accountBalance, int creditScore, float accountInterest, LocalDate date, long branchdetails,
			long chequeNumber, String IFSC ) {
		super();
		this.accountNumber = accountNumber;
		this.customerDetails = customerDetails;
		this.accountHolderName = accountHolderName;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.creditScore = creditScore;
		this.accountInterest = accountInterest;
		this.date = date;
		this.branchdetails = branchdetails;
		this.chequeNumber = chequeNumber;
		this.IFSC=IFSC;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountNumber=" + accountNumber + ", customerDetails=" + customerDetails
				+ ", accountHolderName=" + accountHolderName + ", accountStatus=" + accountStatus + ", accountBalance="
				+ accountBalance + ", creditScore=" + creditScore + ", accountInterest=" + accountInterest + ", date="
				+ date + ", branchdetails=" + branchdetails + ", chequeNumber=" + chequeNumber + ", IFSC=" + IFSC + "]";
	}


	
}
