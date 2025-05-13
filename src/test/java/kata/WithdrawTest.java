package kata;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.kata.adapter.BankOperationAdapter;
import com.bank.kata.domain.Transaction;
import com.bank.kata.domain.Transaction.Type;

class WithdrawTest {

	private Transaction transaction;
	
	private BankOperationAdapter bankOperationAdapter;
	
	@BeforeEach
	public void init() {
		transaction = new Transaction();
		transaction.addRecord(Type.DEPOSIT,LocalDateTime.now(), 100d);
		bankOperationAdapter = new BankOperationAdapter(transaction);
	}
	
	@Test
	void test_withdraw_amount_less_balance() {
		bankOperationAdapter.withdraw(50d);
		assertEquals(transaction.getBalance(),50d);
		
	}
	
	@Test
	void test_withdraw_amount_great_balance() {
		assertThrows(IllegalArgumentException.class,()->bankOperationAdapter.withdraw(-150d));
	}

}
