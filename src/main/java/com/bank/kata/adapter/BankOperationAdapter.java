package com.bank.kata.adapter;

import java.time.LocalDateTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.kata.domain.Transaction;
import com.bank.kata.domain.Transaction.Type;
import com.bank.kata.port.BankOperationPort;


public class BankOperationAdapter implements BankOperationPort {

	
	private static final Logger LOG =  LoggerFactory.getLogger(BankOperationAdapter.class);
	
	private Transaction transaction;
	
	public BankOperationAdapter(final Transaction transaction) {
		this.transaction = transaction;
	}
	
	@Override
	public void deposit(Double amount) {
		if(Objects.isNull(amount) || amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative or null amount");
		}
		
		transaction.addRecord(Type.DEPOSIT,LocalDateTime.now(), amount);
		
        LOG.info("DEPOSIT Amount = " + amount + " ,Balance = " + transaction.getBalance());
	}

	@Override
	public void withdraw(Double amount) {
		
		if(Objects.isNull(amount) || amount < 0 || amount > transaction.getBalance()) {
			throw new IllegalArgumentException("Insuffisant Fund");
		}
		
		transaction.addRecord(Type.WITHDRAW,LocalDateTime.now(),  -amount);
		
		LOG.info("WithDraw Amount = " + -amount + " ,Balance = " + transaction.getBalance());
		
	}


}
