package com.capgemini.pecunia.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genName1")
	@SequenceGenerator(name="genName1", sequenceName="trans",initialValue=1001,allocationSize=1)
	@Column(name="Transaction_Id")
	private long transactionId;
	@Column(name="Account_Number")
	private long accountNumber;
	@Column(name="Transaction_Option")//slip or cheque
	private String transactionOption;
	@Column(name="Transaction_Type")//credit debit
	private String transactionType;
	@Column(name="Transaction_Status")
	private String transactionStatus;
	@Column(name="Transaction_Amount")
	private double transactionAmount;
	@Column(name="Transaction_Date")
	LocalDateTime transactionDate;
	@Column(name="Benificary_Name")
	private String benificaryName;
	@Column(name="Benificary_Accoount_Number")
	private long benificaryAccoountNumber;
	@Column(name="Benificary_Bank_Name")
	private String bankName;
	@Column(name="Current_Balance")
	private double current_Balance;
	
	/**
	 * @return the current_Balance
	 */
	public double getCurrent_Balance() {
		return current_Balance;
	}

	/**
	 * @param current_Balance the current_Balance to set
	 */
	public void setCurrent_Balance(double current_Balance) {
		this.current_Balance = current_Balance;
	}



	/**
	 * @return the transactionId
	 */
	public long getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
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
	 * @return the transactionOption
	 */
	public String getTransactionOption() {
		return transactionOption;
	}
	/**
	 * @param transactionOption the transactionOption to set
	 */
	public void setTransactionOption(String transactionOption) {
		this.transactionOption = transactionOption;
	}
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the transactionStatus
	 */
	public String getTransactionStatus() {
		return transactionStatus;
	}
	/**
	 * @param transactionStatus the transactionStatus to set
	 */
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	/**
	 * @return the transactionAmount
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}
	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	/**
	 * @return the transactionDate
	 */
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	/**
	 * @return the benificaryName
	 */
	public String getBenificaryName() {
		return benificaryName;
	}
	/**
	 * @param benificaryName the benificaryName to set
	 */
	public void setBenificaryName(String benificaryName) {
		this.benificaryName = benificaryName;
	}
	/**
	 * @return the benificaryAccoountNumber
	 */
	public long getBenificaryAccoountNumber() {
		return benificaryAccoountNumber;
	}
	/**
	 * @param benificaryAccoountNumber the benificaryAccoountNumber to set
	 */
	public void setBenificaryAccoountNumber(long benificaryAccoountNumber) {
		this.benificaryAccoountNumber = benificaryAccoountNumber;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Column(name="Localdate")
	LocalDate userTransactionDate;


	/**
	 * @return the transactiondate
	 */
	public LocalDate getUserTransactionDate() {
		return userTransactionDate;
	}

	/**
	 * @param transactiondate the transactiondate to set
	 */
	public void setUserTransactionDate(LocalDate userTransactionDate) {
		this.userTransactionDate = userTransactionDate;
	}

	public TransactionDetails() {
		super();
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", transactionOption=" + transactionOption + ", transactionType=" + transactionType
				+ ", transactionStatus=" + transactionStatus + ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + ", benificaryName=" + benificaryName
				+ ", benificaryAccoountNumber=" + benificaryAccoountNumber + ", bankName=" + bankName
				+ ", current_Balance=" + current_Balance + ", transactiondate=" + userTransactionDate + "]";
	}

	public TransactionDetails(long transactionId, long accountNumber, String transactionOption, String transactionType,
			String transactionStatus, double transactionAmount, LocalDateTime transactionDate, String benificaryName,
			long benificaryAccoountNumber, String bankName, double current_Balance, LocalDate transactiondate2) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.transactionOption = transactionOption;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.benificaryName = benificaryName;
		this.benificaryAccoountNumber = benificaryAccoountNumber;
		this.bankName = bankName;
		this.current_Balance = current_Balance;
		userTransactionDate = transactiondate2;
	}
	
	


}
