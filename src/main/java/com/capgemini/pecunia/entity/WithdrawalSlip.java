package com.capgemini.pecunia.entity;

import java.time.LocalDate;

public class WithdrawalSlip {
private String accountHolderName;	
private long accountNumber;
LocalDate currentDate;
private double amount;

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
public WithdrawalSlip(long accountNumber, double amount,String accountHolderName) {
	super();
	this.accountNumber = accountNumber;
	this.amount = amount;
	this.accountHolderName=accountHolderName;
}
public WithdrawalSlip() {
	super();
}
}
