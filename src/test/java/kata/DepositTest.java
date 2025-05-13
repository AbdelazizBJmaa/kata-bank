package kata;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.kata.adapter.BankOperationAdapter;
import com.bank.kata.domain.Transaction;
import com.bank.kata.domain.Transaction.Type;

class DepositTest {

	
	private Transaction transaction;
	
	private BankOperationAdapter bankOperationAdapter;
	
	@BeforeEach
	public void init() {
		transaction = new Transaction();
		transaction.addRecord(Type.DEPOSIT,LocalDateTime.now(), 100d);
		bankOperationAdapter = new BankOperationAdapter(transaction);
	}
	
	@Test
	void test_deposit_positif_amount() {
		bankOperationAdapter.deposit(100d);
		assertEquals(transaction.getBalance(),200d);
	}
	
	@Test
	void test_deposit_negatif_amount() {
		assertThrows(IllegalArgumentException.class,()->bankOperationAdapter.deposit(-100d));
	}

}
