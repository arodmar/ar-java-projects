/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.lnbexplorer.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 *
 * @author aerodriguez
 */
public class DataDownloader {
    public static String getData(String url) throws IOException{
     Document doc = Jsoup.connect(url).get();
      return doc.html();
    }
    public static List<String> getData(List<String> urlList) throws IOException {
        List<String> htmlDataList = new ArrayList<>();
        int urlListLength = urlList.size();
        
        for (int i = 0; i < urlListLength; i++) {
            //Donwload data
            htmlDataList.add(getData(urlList.get(i)));
        }
        return htmlDataList;

    }
}
