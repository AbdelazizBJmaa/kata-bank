package com.bank.kata.port;

public interface BankOperationPort {
     
	void deposit(Double amount);
	
	void withdraw(Double amount);
}
