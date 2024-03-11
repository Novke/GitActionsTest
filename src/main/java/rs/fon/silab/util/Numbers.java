package rs.fon.silab.util;

public class Numbers {
	public int threeDigitSum(int number) {
		int x, y, z;
		number = Math.abs(number);
		if (number >= 1000) {
			throw new RuntimeException("Invalid Number!");
		}
		x = number / 100;
		y = (number / 10) % 10;
		z = number % 10;
		return x + y + z;
	}
}
