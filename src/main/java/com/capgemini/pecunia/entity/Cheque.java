package com.capgemini.pecunia.entity;

import java.time.LocalDate;

public class Cheque {
	private String pay;
	private long accountNumber;
	LocalDate issueDate;
	private long chequeNumber;
	private String IFSC;
	
	private double amount;
	private String bankName;
	private String userIssueDate;




	public Cheque(String pay, long accountNumber, long chequeNumber, String iFSC, double amount, String bankName,
			String issuedate) {
		super();
		this.pay = pay;
		this.accountNumber = accountNumber;
		this.chequeNumber = chequeNumber;
		IFSC = iFSC;
		this.amount = amount;
		this.bankName = bankName;
		this.userIssueDate = userIssueDate;
	}

	@Override
	public String toString() {
		return "Cheque [pay=" + pay + ", accountNumber=" + accountNumber + ", issueDate=" + issueDate
				+ ", chequeNumber=" + chequeNumber + ", IFSC=" + IFSC + ", amount=" + amount + ", bankName=" + bankName
				+ ", issuedate=" + userIssueDate + "]";
	}
	
	public Cheque() {
		super();
	}
	
	/**
	 * @return the IFSC
	 */
	public String getIFSC() {
		return IFSC;
	}
	/**
	 * @param IFSC the IFSC to set
	 */
	public void setIFSC(String IFSC) {
		this.IFSC = IFSC;
	}
	/**
	 * @return the pay
	 */
	public String getPay() {
		return pay;
	}
	/**
	 * @param pay the pay to set
	 */
	public void setPay(String pay) {
		this.pay = pay;
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
	 * @return the issueDate
	 */
	public LocalDate getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
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

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
	
	
	/**
	 * @return the issueDate
	 */
	public String getUserIssueDate() {
		return userIssueDate;
	}
	/**
	 * @param issuedate the issueDate to set
	 */
	public void setUserIssueDate(String userIssueDate) {
		this.userIssueDate = userIssueDate;
	}
	


}
