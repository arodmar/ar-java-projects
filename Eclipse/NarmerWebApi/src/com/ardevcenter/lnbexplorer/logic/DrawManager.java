/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.lnbexplorer.logic;

import com.ardevcenter.lnbexplorer.data.DataDownloader;
import com.ardevcenter.lnbexplorer.data.DataExtractor;
import com.ardevcenter.lnbexplorer.data.UrlGenerator;
//import com.ardevcenter.lnbexplorer.entities.LnbDraw;
import com.ardevcenter.lnbexplorer.data.jdo.entities.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
//import java.util.TimeZone;


/**
 *
 * @author aerodriguez
 */
public class DrawManager {
    
    // 2013-08-26
    //private static final String LNB_URL = "http://200.115.157.117/LNB/numerosjugados.php?tiposorteo=T&ano=%d&meses=%d&Consultar=consulta";
	public static final String LNB_URL ="http://www.lnb.gob.pa/numerosjugados.php?tiposorteo=T&ano=%d&meses=%d&Consultar=Buscar";
    
	public static List<LnbDraw> getOnlineDrawData( int initialYear, int finalYear, int initialMonth, int finalMonth ) throws IOException{

        //Generate urls to download
        List<String> lnbGeneratedUrls = UrlGenerator.CreateUrlListFromYearRange(LNB_URL, initialYear, finalYear, initialMonth, finalMonth);
        
        // Download html data
        List<String> downloadedLnbData = DataDownloader.getData(lnbGeneratedUrls); 
        
        //Extract draw data
        List<List<String>> drawData = DataExtractor.ExtractDrawData(downloadedLnbData);
                        
        //Map data
        List<LnbDraw> mappedDrawData = DrawMapper.mapDraws(drawData);
        
      //Persisting data
        //PMF.persistEntity(mappedDrawData);
        
        return mappedDrawData;
        
        
    }
    
    
    public static List<LnbDraw> addNewDrawData( Date initialDate, Date finalDate) throws IOException{
		// Set calendar info
		Calendar initialCalendar =  GregorianCalendar.getInstance();
		initialCalendar.setTime(initialDate);
		Calendar finalCalendar = GregorianCalendar.getInstance();
		finalCalendar.setTime(finalDate);
		
		//Get calendar values
		Integer iy= initialCalendar.get(Calendar.YEAR);
		Integer im= initialCalendar.get(Calendar.MONTH);
		Integer fy= finalCalendar.get(Calendar.YEAR);
		Integer fm= finalCalendar.get(Calendar.MONTH);
		
		return addNewDrawData(iy,fy,im,fm);
			
    }
    
    
    public static List<LnbDraw> addNewDrawData( int initialYear, int finalYear, int initialMonth, int finalMonth ) throws IOException{

        //Generate urls to download
        List<String> lnbGeneratedUrls = UrlGenerator.CreateUrlListFromYearRange(LNB_URL, initialYear, finalYear, initialMonth, finalMonth);
        
        // Download html data
        List<String> downloadedLnbData = DataDownloader.getData(lnbGeneratedUrls); 
        
        //Extract draw data
        List<List<String>> drawData = DataExtractor.ExtractDrawData(downloadedLnbData);
                        
        //Map data
        List<LnbDraw> mappedDrawData = DrawMapper.mapDraws(drawData);
        
      //Persisting data
        PMF.persistEntity(mappedDrawData);
        
        return mappedDrawData;
        
        
    }

    
    public static LnbDraw getDrawData(Date date)
    {
    	Class<LnbDraw> classForLnbDraw =  LnbDraw.class;
        return PMF.getEntity(classForLnbDraw, date.getTime());	
    
    }
    
    public static List<LnbDraw>  getDrawData(Date initialDate, Date finalDate)
    {
        return getDrawData( initialDate,  finalDate,false);
    }
    
    public static List<LnbDraw>  getDrawData(Date initialDate, Date finalDate, boolean descending)
    {
    	Class<LnbDraw> classForLnbDraw =  LnbDraw.class;
    	String filter = "drawID>= initialDate && drawID<= finalDate";
    	String params = "Long initialDate, Long finalDate";
    	String orderingClause = descending?"drawID desc":null;
    	Object[] parameterValues = {initialDate.getTime(),finalDate.getTime()};
        return PMF.getEntities(classForLnbDraw, filter,orderingClause,  params,parameterValues);
    }

public static void deleteAllDraws(){
	
	
}

}
