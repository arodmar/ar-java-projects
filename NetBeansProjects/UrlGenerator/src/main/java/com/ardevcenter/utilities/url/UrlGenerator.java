/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.utilities.url;

/**
 *
 * @author aerodriguez
 */
import java.util.ArrayList;
import java.util.List;

public class UrlGenerator {

	// http://www.example.com/images/pic[date,initialdate,enddate, pattern].jpg
	// public static List<String> generateFromPattern(String baseURL, )

	private String urlPattern;
	private String baseUrl;
	private final String patternRegEx = "\\[[0-9]+-[0-9]+\\]";
	private final String rangeSeparator = "-";

	public String getUrlPattern() {
            return urlPattern;
	}

	public String getBaseUrl() {
            return baseUrl;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;

	}

	public UrlGenerator() {
	}

	public List<String> generateUrls() throws Exception {

            RangeManager rangeGenerator = new RangeManager(urlPattern, patternRegEx, rangeSeparator);
            List<String> textRanges = rangeGenerator.getTextRanges();
            List<String> urls = new ArrayList<>();

            Integer rangesCount = textRanges.size();
            // Evaluate first range
            if(rangesCount>0){
                String textRange0 = textRanges.get(0);				
                Range<Integer> range0 = rangeGenerator.getRangeFromText(textRanges.get(0));
                for (Integer x0 = range0.getMin(); x0 <= range0.getMax(); x0++) {

                    // Evaluate second range
                    if(rangesCount>1){
                        String textRange1 = textRanges.get(1);				
                        Range<Integer> range1 = rangeGenerator.getRangeFromText(textRanges.get(1));
                        for (Integer x1 = range1.getMin(); x1 <= range1.getMax(); x1++) {
                            String newUrl = urlPattern.replace(textRange0, x0.toString())
                                                      .replace(textRange1, x1.toString());
                            urls.add(newUrl);
                        }
                    }	
                    else{
                        String newUrl = urlPattern.replace(textRange0, x0.toString());
                        urls.add(newUrl);
                    }
                }
            }		

            // http://www.lnb.gob.pa/numerosjugados.php?tiposorteo=T&ano=%d&meses=%d&Consultar=Buscar
            // http://www.lnb.gob.pa/numerosjugados.php?tiposorteo=T&ano=[2014-2015]%d&meses=[1-12]&Consultar=Buscar

            return urls;

	}

}
