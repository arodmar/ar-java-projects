/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.drawmanager.lnb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author aerodriguez
 */
public class LnbDrawDataExtractor {

    public static final String MAIN_CONTAINER_ELEMENT_QUERY = "table[width=714] tr";
    public static final String SECOND_CONTAINER_ELEMENT_QUERY = "td span font strong";
    
    public static List<List<String>> ExtractDrawData(List<String> htmlDataList) throws IOException {
        List<List<String>> extractedData = new ArrayList<>();
        for (String htmlData : htmlDataList) {
            extractedData.addAll(ExtractDrawData(htmlData));
        }
        return extractedData;
    }

    public static List<List<String>> ExtractDrawData(String htmlData) throws IOException {
        List<String> parseData = null;
        List<List<String>> parseDataList = new ArrayList<>();

        // Create html document
        Document doc = Jsoup.parse(htmlData);

        // Get data in main container
        Elements tableInfo = doc.select(MAIN_CONTAINER_ELEMENT_QUERY);
        
        int lenght = tableInfo.size();
        for (int i = 0; i < lenght; i++) {
            // Extract info
            Elements tdInfos = tableInfo.get(i).select(SECOND_CONTAINER_ELEMENT_QUERY);
            int tdLength = tdInfos.size();
            if (tdLength > 0) {
                parseData = new ArrayList<>();
                for (int j = 0; j < tdLength; j++) {
                    parseData.add(tdInfos.get(j).html());                  
                }
                parseDataList.add(parseData);
            }
        }
        return parseDataList;
    }
}