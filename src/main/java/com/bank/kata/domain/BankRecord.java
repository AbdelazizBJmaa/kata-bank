package com.bank.kata.domain;

import java.time.LocalDateTime;

import com.bank.kata.domain.Transaction.Type;

public record BankRecord(Type type , LocalDateTime dateOp , Double amount) {

}
