/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.lnbexplorer.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerodriguez
 */
public class UrlGenerator {

    ///Create the url page list to download    
    public static List<String> CreateUrlListFromYearRange(String urlFormat, int initialYear, int finalYear) {

        return CreateUrlListFromYearRange(urlFormat,initialYear,finalYear,1,12);       
    }

    public static List<String> CreateUrlListFromYearRange(String urlFormat, int initialYear, int finalYear, int initialMonth, int finalMonth) {

        List<String> urlList = new ArrayList<>();
        if (initialYear == finalYear) {
            // Just create months
            urlList.addAll(CreateUrlListFromMonthRange(urlFormat, initialYear, initialMonth, finalMonth));
        } else {
            // Create years and months
            for (int i = initialYear; i <= finalYear; i++) {
            	// 20140818: Validate months error creating urls when initialMonth>finalMonth
            	int firstMonthIndex = (i == initialYear)?initialMonth:1;
            	int lastMonthIndex = (i == finalYear)?finalMonth:12;
                urlList.addAll(CreateUrlListFromMonthRange(urlFormat, i, firstMonthIndex, lastMonthIndex));
            }
        }
        return urlList;
    }

    public static List<String> CreateUrlListFromMonthRange(String urlFormat, int year, int initialMonth, int finalMonth) {

        List<String> urlList = new ArrayList<>();
        if (initialMonth == finalMonth) {
            // Just create one month            
            urlList.add(String.format(urlFormat, year, initialMonth));
        } else {
            // Create months  
        	for (int j = initialMonth; j <= finalMonth; j++) {            	
                urlList.add(String.format(urlFormat, year, j));
            }
        }
        return urlList;
    }
}
