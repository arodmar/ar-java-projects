package com.ardevcenter.drawmanager.lnb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunctions {
	
	public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    public static String parseDateToStandardFormat(String dateToParse, String originFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(originFormat);
        String standardFormattedDate;
        Date date;
        try {
            date = dateFormat.parse(dateToParse);
            SimpleDateFormat standardDateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT );
            standardFormattedDate = standardDateFormat.format(date);
        } catch (ParseException e) {
            standardFormattedDate = null;
        }
        return standardFormattedDate;
    }
    
    
    
    
    public static Date parseDateFromString(String dateToParse) {

        return parseDateFromString(dateToParse,DATE_DEFAULT_FORMAT);
    }
    
    public static Date parseDateFromString(String dateToParse, String originFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(originFormat);
        Date date;        
        try {
            date = dateFormat.parse(dateToParse);           
        } catch (ParseException e) {
            date = null;
        }
        return date;
    }
    
    public static String parseDateToString(Date dateToParse) {       
        return parseDateToString(dateToParse,DATE_DEFAULT_FORMAT);
    }
    
    public static String parseDateToString(Date dateToParse, String originFormat) {
        String standardFormattedDate;
        SimpleDateFormat standardDateFormat = new SimpleDateFormat(originFormat);
       try {            
            standardFormattedDate = standardDateFormat.format(dateToParse);
        } catch (Exception e) {
            standardFormattedDate = null;
        }
        return standardFormattedDate;
    }
}
