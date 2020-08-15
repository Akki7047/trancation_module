package com.capgemini.pecunia.entity;

import java.time.LocalDate;

public class DepositSlip {
	private long accountNumber;
	LocalDate currentDate;
	private String accountHolderName;
	private double amount;
	public DepositSlip() {
		super();
	}



	public DepositSlip(long accountNumber, String accountHolderName, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.amount = amount;
	}



	@Override
	public String toString() {
		return "DepositSlip [accountNumber=" + accountNumber + ", currentDate=" + currentDate + ", accountHolderName="
				+ accountHolderName + ", amount=" + amount + "]";
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
	 * @return the currentDate
	 */
	public LocalDate getCurrentDate() {
		return currentDate;
	}
	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
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
	

}
