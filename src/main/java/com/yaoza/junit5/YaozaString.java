package com.yaoza.junit5;

public abstract class YaozaString {

	public static boolean isEmptyString(String theInstance) {
		return !(theInstance != null && !theInstance.isEmpty());
	}

}
