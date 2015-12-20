/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.utilities.urltemplategenerator;

/**
 *
 * @author aerodriguez
 */
public class Range<T> {
	private T min;
	private T max;
	
	public Range(T[] rangeArray){
        this.min = rangeArray[0];
        this.max = rangeArray[1];
    }
	public Range(T min, T max){
        this.min = min;
        this.max = max;
    }

	public T getMin() {
		return min;
	}

	public T getMax() {
		return max;
	}
	
	

}