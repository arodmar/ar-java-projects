/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ardevcenter.utilities.url;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RangeManager {
	
	private String value;
	private String pattern;
	private String rangeSeparator;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getRangeSeparator() {
		return rangeSeparator;
	}

	public void setRangeSeparator(String rangeSeparator) {
		this.rangeSeparator = rangeSeparator;
	}

	public RangeManager(){}
	
	public RangeManager(String value, String pattern, String rangeSeparator){
		this.value = value;
		this.pattern = pattern;
		this.rangeSeparator = rangeSeparator;
	}
	
	
	//Methods

	public List<Range<Integer>> getRanges() {
		List<Range<Integer>> ranges = new ArrayList<>();
		List<String> textRanges= getTextRanges();
		
		Integer rangesCount = textRanges.size();
		for(int i=0; i<= rangesCount;i++ ){
			Range<Integer> range = getRangeFromText(textRanges.get(i));
			ranges.add(range);			
		}		
		return ranges;

	}
	
	public Range<Integer> getRangeFromText(String rangeText){
		Integer rangeTextSize = rangeText.length();
		// Remove range identifier
		String newRangeText = rangeText.substring(1,rangeTextSize-1);
		String textRangeLimits[] = newRangeText.split(rangeSeparator);
		
		Integer minValue = Integer.parseInt(textRangeLimits[0]);
		Integer maxValue = Integer.parseInt(textRangeLimits[1]);
		Range<Integer> range = new Range<>(minValue, maxValue);
		return range;
	}	

	public  List<String> getTextRanges() {
		List<String> ranges = new ArrayList<>();
		Pattern p = Pattern.compile(this.pattern);
		Matcher m = p.matcher(this.value);
		
		while (m.find()) {
			ranges.add( m.group());
		}		
		return ranges;
	}
}
