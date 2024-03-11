package rs.fon.silab.util;

public class Sort {
	public void sort(int[] array) {
		int pom;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					pom = array[i];
					array[i] = array[j];
					array[j] = pom;
				}
			}
		}
	}
}
