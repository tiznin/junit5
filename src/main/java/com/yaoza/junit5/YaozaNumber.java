package com.yaoza.junit5;

public abstract class YaozaNumber {

	public static int sum(int[] theNumber) {
		int w_sum = 0;
		for (int w_loop : theNumber) {
			w_sum += w_loop;
		}

		return w_sum;
	}

}
