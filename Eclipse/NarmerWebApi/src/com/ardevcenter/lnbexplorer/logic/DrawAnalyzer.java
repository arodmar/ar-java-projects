package com.ardevcenter.lnbexplorer.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ardevcenter.lnbexplorer.data.jdo.entities.LnbDraw;

public class DrawAnalyzer {
	final static int indexFromLast = 2;

	public static Map<String, Integer> analyzeDraws(List<LnbDraw> draws, boolean allNumbers) {
		// Add first
		List<String> numbers = new ArrayList<>();		
		for (LnbDraw draw : draws) {
			numbers.add(draw.getFirstNumber());
		}
		
		if (allNumbers){
			//Add Second
			for (LnbDraw draw : draws) {
				numbers.add(draw.getSecondNumber());
			}
			//Add third
			for (LnbDraw draw : draws) {
				numbers.add(draw.getThirdNumber());
			}
		}
		
		Map<String, Integer> map = new HashMap<>();
		// Calculating repetions
		for (String number : numbers) {
			//String number = draw.getFirstNumber();
			int currentNumberLength = number.length();
			if (currentNumberLength >= indexFromLast) {
				String currentNumber = number.substring(currentNumberLength - indexFromLast, currentNumberLength - indexFromLast + 1);
				if (map.containsKey(currentNumber)) {
					int repeticions = map.get(currentNumber) + 1;
					map.put(currentNumber, repeticions);
				} else {
					map.put(currentNumber, 1);
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			String number = String.valueOf(i);
			if (map.containsKey(number)) {
				System.out.println(number + ": " + String.valueOf(map.get(number)));
			} else {
				System.out.println(number + ": 0");
			}
		}

		return map;
	}

	public static Map<String, Integer> getLastShowTime(List<LnbDraw> draws) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			String key = String.valueOf(i);

			int counter = 1;
			for (LnbDraw draw : draws) {
				String number = getSubStringFromLast(draw.getFirstNumber(), indexFromLast);
				if (number != null && !number.equals(key)) {
					counter += 1;
				} else {
					break;
				}
			}

			// number not played in the interval
			if (counter == draws.size()+1) {
				counter = -1;
			}

			map.put(key, counter);

		}
		return map;
	}

	public static String getSubStringFromLast(String value, int lastIndex) {
		String resp = null;
		int currentNumberLength = value.length();
		if (currentNumberLength >= lastIndex) {
			resp = value.substring(currentNumberLength - lastIndex, currentNumberLength - lastIndex + 1);
		}
		return resp;
	}
}
