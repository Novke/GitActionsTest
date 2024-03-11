package rs.fon.silab.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SortTests {
	private final Sort sort = new Sort();

	@Test
	public void testEmptyArray() {
		int x[] = new int[] {};
		int array[] = new int[] {};
		sort.sort(array);
		assertArrayEquals(x, array);
	}

	@Test
	public void testOneElementArray() {
		int x[] = new int[] { 10 };
		int array[] = new int[] { 10 };
		sort.sort(array);
		assertArrayEquals(x, array);
	}

	@Test
	public void testManyElementsArray() {
		int x[] = new int[] { 2, 3, 5, 8, 10 };
		int array[] = new int[] { 5, 8, 2, 10, 3 };
		sort.sort(array);
		assertArrayEquals(x, array);
	}

	@Test
	public void testManyElementsDifferentSizeArray() {
		int x[] = new int[] { 2, 3, 5, 8, 10 };
		int array[] = new int[] { 8, 2, 10, 3 };
		sort.sort(array);
		assertFalse(Arrays.equals(x, array));
	}

	@Test
	public void testManyElementsSomeDuplicatesArray() {
		int x[] = new int[] { 2, 2, 3, 5, 8, 8, 8, 10 };
		int array[] = new int[] { 2, 5, 8, 2, 8, 10, 3, 8 };
		sort.sort(array);
		assertArrayEquals(x, array);
	}
}
