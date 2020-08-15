package com.capgemini.pecunia.entity;

public class Data1 {
	Cheque cheque;
	public Data1() {
		super();
	}
	public Data1(Cheque cheque, TransferSlip transferSlip) {
		super();
		this.cheque = cheque;
		this.transferSlip = transferSlip;
	}
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
	 * @return the transferSlip
	 */
	public TransferSlip getTransferSlip() {
		return transferSlip;
	}
	/**
	 * @param transferSlip the transferSlip to set
	 */
	public void setTransferSlip(TransferSlip transferSlip) {
		this.transferSlip = transferSlip;
	}
	TransferSlip transferSlip;
	

}
