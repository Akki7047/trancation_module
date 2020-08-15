package com.capgemini.pecunia.entity;

public class TransferSlip {
	private long accountNumber;
	private String accountHolderName;
	private String IFSC;
	private String bankName;
	
	public TransferSlip() {
		super();
	}
	public TransferSlip(long accountNumber, String accountHolderName, String iFSC,String bankName) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		IFSC = iFSC;
		this.bankName=bankName;
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

}
