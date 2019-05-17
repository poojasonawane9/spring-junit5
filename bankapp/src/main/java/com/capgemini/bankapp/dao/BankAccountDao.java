package com.capgemini.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.bankapp.entity.BankAccount;

public interface BankAccountDao extends JpaRepository<BankAccount, Integer>{

}
