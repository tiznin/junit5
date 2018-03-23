package com.yaoza.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestYaozaNumber {

	@Test
	public void testSum() {

		Assertions.assertEquals(3, YaozaNumber.sum(new int[] { 1, 2 }));

	}
}
