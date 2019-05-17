package com.capgemini.bankapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

@Inheritance(strategy=InheritanceType.JOINED)
public class BankAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;

	private String accountHolderName;

	private int accountBalance;

	private String accountType;
	
	public BankAccount() {
		super();
	}

	public BankAccount(int accountId, String accountHolderName, int accountBalance, String accountType) {
		super();
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	public BankAccount(String accountHolderName, int accountBalance, String accountType) {
		super();
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", accountHolderName=" + accountHolderName + ", accountBalance="
				+ accountBalance + ", accountType=" + accountType + "]";
	}

	
	
	

}
