package com.bank.kata.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.kata.domain.Transaction;
import com.bank.kata.port.PrintPort;

public class PrintAdapter implements PrintPort {

	private static final Logger LOG = LoggerFactory.getLogger(PrintAdapter.class);

	private Transaction transaction;

	public PrintAdapter(final Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public void printHistory() {
		
		StringBuilder line = new StringBuilder();
		line.append("\n").append(" Balance =").append(transaction.getBalance());
		line.append("\n").append("operation | date  | amount ");
		String tranLines = transaction.getListRecord().stream().map(bankrecord -> String.format("%s | %s  | %s ",bankrecord.type().toString() , dateFormat(bankrecord.dateOp()), bankrecord.amount()))
				.collect(Collectors.joining("\n"));
	    line.append("\n").append(tranLines).toString();

	}
	
	private String dateFormat(LocalDateTime date) {
		final String DATE_PATTERN = "dd/MM/yyyy";
		return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
	} 

}
