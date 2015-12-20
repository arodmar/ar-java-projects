/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.utilities.html;
import java.io.IOException;
import java.util.ArrayList;
 //import org.jsoup.*;
//import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 *
 * @author aerodriguez
 */
public class HtmlParser {
    
    public List<String> Select2(String url, String query) throws IOException{
        List<String> numberInfos = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements tableInfo = doc.select(query);
       int lenght =  tableInfo.size();
        for (int i = 0; i < lenght; i++) {
           Elements tdInfos =  tableInfo.get(i).select("td span font strong");
           int tdLength = tdInfos.size();
           if(tdLength >0 ){
           String tmpInfo ="";
            for (int j = 0; j < tdLength; j++) {
               tmpInfo+= tdInfos.get(j).html()+ ",";
            }
          numberInfos.add(tmpInfo);
        }
        }
        return numberInfos;
    }
    
    
     public List<String> Select(String url, String query) throws IOException{
        List<String> numberInfos = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements tableInfo = doc.select(query);
       int lenght =  tableInfo.size();
        for (int i = 0; i < lenght; i++) {          
          numberInfos.add(tableInfo.get(i).html());
        }
        return numberInfos;
    }
}
