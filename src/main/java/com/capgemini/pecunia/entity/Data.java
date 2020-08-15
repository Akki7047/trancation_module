package com.capgemini.pecunia.entity;

public class Data {
	Cheque cheque;
	public Data() {
		super();
	}
	public Data(Cheque cheque, DepositSlip depositSlip) {
		super();
		this.cheque = cheque;
		this.depositSlip = depositSlip;
	}
	DepositSlip depositSlip;
	/**
	 * @return the cheque
	 */
	public Cheque getCheque() {
		return cheque;
	}
	/**
	 * @param cheque the cheque to set
	 */
	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}
	/**
	 * @return the depositSlip
	 */
	public DepositSlip getDepositSlip() {
		return depositSlip;
	}
	/**
	 * @param depositSlip the depositSlip to set
	 */
	public void setDepositSlip(DepositSlip depositSlip) {
		this.depositSlip = depositSlip;
	}
	

}
