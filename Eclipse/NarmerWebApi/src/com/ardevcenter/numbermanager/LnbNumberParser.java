/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.numbermanager;

import com.ardevcenter.utilities.html.HtmlParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerodriguez
 */
public class LnbNumberParser {

    //private static final String LNB_URL_OLD = "http://www.lnb.gob.pa/sitio/numerosjugados.php?tiposorteo=T&ano=%d&meses=%d&Consultar=consulta";
    
    // 2013-08-26
    private static final String LNB_URL = "http://200.115.157.117/LNB/numerosjugados.php?tiposorteo=T&ano=%d&meses=%d&Consultar=consulta";
    
    private static final String HTML_QUERY = "table[width=714] tr";
    // Read lnb numbers for a gived year range
    public List<String> ReadNumbersFromYearRange(int initialYear, int finalYear) throws IOException {
        // Create the url list to download
        List<String> urlList = CreateURLListToSearch(LNB_URL, initialYear, finalYear);
        // Download and parse number information
        List<String> numberList = DownloadAndParseURLList(urlList);
        return numberList;
    }

    public List<String> DownloadAndParseURLList(List<String> urlList) throws IOException {
        List<String> numberList = new ArrayList<>();
        int urlListLength = urlList.size();
        HtmlParser htmlParser = new HtmlParser();

        for (int i = 0; i < urlListLength; i++) {
            System.out.println("Parsing file: " + urlList.get(i));
            numberList.addAll(htmlParser.Select2(urlList.get(i), HTML_QUERY));
        }
        return numberList;

    }

    ///Create the url page list to download    
    public List<String> CreateURLListToSearch(String urlFormat, int initialYear, int finalYear) {
        List<String> urlList = new ArrayList<>();
        if (initialYear == finalYear) {
            // Just create months
            for (int j = 1; j <= 12; j++) {
                urlList.add(String.format(urlFormat, initialYear, j));
            }
        } else {
            // Create years and months
            for (int i = initialYear; i <= finalYear; i++) {
                for (int j = 1; j <= 12; j++) {
                    urlList.add(String.format(urlFormat, i, j));
                }
            }
        }
        return urlList;
    }
}
