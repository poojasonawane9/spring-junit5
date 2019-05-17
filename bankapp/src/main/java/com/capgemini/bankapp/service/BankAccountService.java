package com.capgemini.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.entity.BankAccount;

@Service
public class BankAccountService {
	
	@Autowired
	BankAccountDao dao;

	public BankAccount addBankAccount(BankAccount account) {
		return dao.save(account);
	}
	
	public List<BankAccount> getAllBankAccount(){
		return dao.findAll();
		
	}
	
	public boolean deleteAccount(int accountId) {
		Optional<BankAccount> account = dao.findById(accountId);
		if(account.isPresent()) {
			dao.deleteById(accountId);
			return true;
		}
		return false;
	}
	
	public Optional<BankAccount> findAccountById(int id) {
		Optional<BankAccount> account = dao.findById(id);
		return account;
	}
	
	public boolean updateBankAccount(BankAccount account) {
		Optional<BankAccount> account1 = dao.findById(account.getAccountId());
		if(account1.isPresent()) {
			dao.save(account);
			return true;
		}
		return false;
	}
}
