package com.bank.kata.adapter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import com.bank.kata.domain.Transaction;
import com.bank.kata.domain.Transaction.Type;
import com.bank.kata.port.BankOperationPort;

public class BankOperationAdapter implements BankOperationPort {

	private Transaction transaction;
	
	public BankOperationAdapter(Transaction transaction) {
		this.transaction = transaction;
	}
	
	@Override
	public void deposit(Double amount) {
		if(Objects.isNull(amount) || amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative or null amount");
		}
		
		transaction.addRecord(Type.DEPOSIT,LocalDateTime.now(), amount);

	}

	@Override
	public void withdraw(Double amount) {
		// TODO Auto-generated method stub
		
	}


}
