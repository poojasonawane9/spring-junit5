package com.capgemini.bankapp.entity;

import javax.persistence.Entity;

@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
public class SavingAccount extends BankAccount {

	
	private Double salary;

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(String accountHolderName, int accountBalance,String accountType,Double salary) {
		super(accountHolderName, accountBalance,accountType);
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	
}
