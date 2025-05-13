package com.bank.kata.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Transaction {
    
	public static enum Type { DEPOSIT , WITHDRAW }
	
	private List<BankRecord> listRecord;
	
	public Transaction(List<BankRecord> listRecord) {
		this.listRecord = listRecord;
	}
	
	public void addRecord(Type type,LocalDateTime dateOp , Double amount) {
          listRecord.add(new BankRecord(type,dateOp, amount));
	}
	
	public Double getBalance() {
		return listRecord.stream().mapToDouble(BankRecord::amount).sum();    
	}

	public List<BankRecord> getListRecord() {
		return listRecord;
	}
	
	
}
