/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.utilities.urltemplategenerator;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aerodriguez
 */
public class UrlGeneratorTest {
    
    public UrlGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUrlPattern method, of class UrlGenerator.
     */
    @Test
    public void testGetUrlPattern() {
        System.out.println("getUrlPattern");
        
        UrlGenerator instance = new UrlGenerator();
        String expResult = "pattern";
        instance.setUrlPattern(expResult);
        String result = instance.getUrlPattern();
        assertEquals("Test for getUrlPattern fails",expResult, result);
    }

    /**
     * Test of setUrlPattern method, of class UrlGenerator.
     */
    @Test
    public void testSetUrlPattern() {
        System.out.println("setUrlPattern");
        String expResult = "pattern";
        UrlGenerator instance = new UrlGenerator();
        instance.setUrlPattern(expResult);
        String result = instance.getUrlPattern();
        assertEquals(expResult, result);
    }

    /**
     * Test of generateUrls method, of class UrlGenerator.
     */
    @Test
    public void testGenerateUrls_MultipleElements() throws Exception {
        System.out.println("generateUrls");
        int expElements = 24;
        UrlGenerator instance = new UrlGenerator();
        String urlPattern = "http://example.com?value1=[2014-2015]%d&meses=[1-12]";
        instance.setUrlPattern(urlPattern);
        
        List<String> result = instance.generateUrls();        
        assertEquals(expElements, result.size());
    }
    
     @Test
    public void testGenerateUrls_SingleElement() throws Exception {
        System.out.println("generateUrls");
        int expElements = 1;
        UrlGenerator instance = new UrlGenerator();
        String urlPattern = "http://example.com?value1=[2014-2014]%d&meses=[1-1]";
        instance.setUrlPattern(urlPattern);
        
        List<String> result = instance.generateUrls();
        System.out.println(result.get(0));
        assertEquals(expElements, result.size());
    }
    
}
