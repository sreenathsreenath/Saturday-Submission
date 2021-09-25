package com.java.infintie.bank;

import java.util.Date;

public class Trans {
	
	private int accountNo;
	private int transAmount;
	private Date transDate;
	private String transType;
	public Trans(int accountNo, int transAmount, Date transDate, String transType) {
		
		this.accountNo = accountNo;
		this.transAmount = transAmount;
		this.transDate = transDate;
		this.transType = transType;
	}
	public Trans() {
		
		// TODO Auto-generated constructor stub
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(int transAmount) {
		this.transAmount = transAmount;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	@Override
	public String toString() {
		//return "Trans [accountNo=" + accountNo + ", transAmount=" + transAmount + ", transDate=" + transDate
				//+ ", transType=" + transType + "]";
		return String.format("%10s  %10s  %10s  %10s  ",accountNo,transAmount,getTransDate(),transType  );
	}
	
	

}
