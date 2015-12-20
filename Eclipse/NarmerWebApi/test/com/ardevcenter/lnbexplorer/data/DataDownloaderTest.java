package com.ardevcenter.lnbexplorer.data;

import static org.junit.Assert.*;

import java.util.List;

import com.ardevcenter.lnbexplorer.data.*;
import com.ardevcenter.lnbexplorer.logic.*;

import org.junit.Test;

public class DataDownloaderTest {

	@Test
	public void testGetDataString() {
		String urlFormat = DrawManager.LNB_URL;
		
		List<String> urls = UrlGenerator.CreateUrlListFromYearRange(urlFormat,2012,2013,6,6);		
		assertEquals("Wrong number of urls created.", urls.size(), 13);
		
		urls = UrlGenerator.CreateUrlListFromYearRange(urlFormat,2012,2012,1,12);		
		assertEquals("Wrong number of urls created.", urls.size(), 12);
		
	}

	@Test
	public void testGetDataListOfString() {
	
	}

}
