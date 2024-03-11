package rs.fon.silab.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumbersTests {
	private final Numbers numbers = new Numbers();

	@Test
	public void testNumberThreeDigits() {
		int num = 234;
		int sum = numbers.threeDigitSum(num);
		assertEquals(9, sum);
	}

	@Test
	public void testNumberTwoDigits() {
		int num = 34;
		int sum = numbers.threeDigitSum(num);
		assertEquals(7, sum);
	}

	@Test
	public void testNumberFourDigitsException() {
		int num = 1024;
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			numbers.threeDigitSum(num);
		});
		assertEquals("Invalid Number!", ex.getMessage());
	}

}
