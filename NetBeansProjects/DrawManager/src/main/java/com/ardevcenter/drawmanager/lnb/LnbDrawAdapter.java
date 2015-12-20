/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.drawmanager.lnb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerodriguez
 */
public class LnbDrawAdapter {

    private List<String> urls;

    public LnbDrawAdapter() {
    }

    public LnbDrawAdapter(String url) {
        this.urls = new ArrayList<>();
        this.urls.add(url);
    }

    public LnbDrawAdapter(List<String> urls) {
        this.urls = urls;
    }

    public List<LnbDrawRawEntity> getLnbDrawData() throws IOException, Exception {
        if (this.urls == null || this.urls.isEmpty()) {
            throw new Exception("No lnb urls to process");
        }

        List<String> lnbDrawHtmlList = LnbDrawDataDownloader.getData(this.urls);
        List<List<String>> preParsedData = LnbDrawDataExtractor.ExtractDrawData(lnbDrawHtmlList);
        List<LnbDrawRawEntity> mappedDrawData = LnbDrawMapper.mapDraws(preParsedData);

        return mappedDrawData;
    }

    public List<LnbDrawRawEntity> getLnbDrawData(List<String> lnbDrawHtmlList) throws IOException {
        //List<String> lnbDrawHTML  = LnbDrawDataDownloader.getData(this.urls);
        List<List<String>> preParsedData = LnbDrawDataExtractor.ExtractDrawData(lnbDrawHtmlList);
        List<LnbDrawRawEntity> mappedDrawData = LnbDrawMapper.mapDraws(preParsedData);

        return mappedDrawData;
    }

}
