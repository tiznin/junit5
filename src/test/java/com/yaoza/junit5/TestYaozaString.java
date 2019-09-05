package com.yaoza.junit5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestYaozaString {

	@ParameterizedTest(name = "run #{index} with [{arguments}]")
	@ValueSource(strings = { "Hellox", "JUnit" })
	public void isEmptyString(String theInstance) {
		Assertions.assertFalse(YaozaString.isEmptyString(theInstance));
	}

	@ParameterizedTest(name = "run #{index} with [{arguments}]")
	@MethodSource("createWordsForTest")
	public void isEmptyStringByMethod(boolean theExpect, String theInstance) {
		Assertions.assertEquals(theExpect, YaozaString.isEmptyString(theInstance));
	}

	public static Stream<Arguments> createWordsForTest() {
		return Stream.of(Arguments.of(true, null), Arguments.of(false, "Hello"), Arguments.of(false, "JUnit 5"));
	}

	@ParameterizedTest(name = "run #{index} with [{arguments}]")
	@CsvSource({ "false, Hello, 2018-01-01T00:00:00", "false, JUnit 5, 2018-01-01T00:00:00" })
	public void isEmptyStringByCvs(boolean theExpect, String theInstance, LocalDateTime theLocalDateTime) {
		Assertions.assertEquals(theExpect, YaozaString.isEmptyString(theInstance));
	}

	@TestFactory
	public Collection<DynamicTest> isEmptyStringByDynamicTest() {
		List<Boolean> w_listExpect = Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
		List<String> w_listData = Arrays.asList(null, "Hello", "JUnit 5");

		Collection<DynamicTest> w_tests = new ArrayList<>();

		for (int i = 0; i < w_listExpect.size(); i++) {

			Boolean w_loopExpect = w_listExpect.get(i);
			String w_loopData = w_listData.get(i);

			Executable exec = () -> Assertions.assertEquals(w_loopExpect, YaozaString.isEmptyString(w_loopData));
			String testName = " Test tranlate " + w_loopExpect;
			DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);
			w_tests.add(dTest);
		}

		return w_tests;

	}

}
