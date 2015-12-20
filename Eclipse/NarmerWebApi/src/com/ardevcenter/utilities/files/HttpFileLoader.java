/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.utilities.files;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;

/**
 *
 * @author aerodriguez
 */
public class HttpFileLoader implements IFileLoader {
    /*
     * Download a web page and read it information line by line
     */

    @Override
    public List<String> ReadLines(String file, Charset charsetType) throws IOException {
        List<String> loadedLines = null;
        URL url = new URL(file);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            loadedLines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                loadedLines.add(line);
            }
        }
        return loadedLines;
    }
    
    
    
    
    private final static String GET = "GET";

    /**
     * Retrieves content on provided url. Recreates connection on eeach call.
     *
     * @param url
     * @return BufferedReader
     * @throws IOException
     */
    public static ArrayList<String> get(String urlString) throws IOException {
// TODO handle 503 response
// TODO add timeout functionality
        HttpURLConnection connection;
        BufferedReader rd = null;
        ArrayList<String> strings = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(GET);
            rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                strings.add(line);
            }
        } finally {
            if (rd != null) {
                rd.close();
            }
        }
        return strings;
    }
}