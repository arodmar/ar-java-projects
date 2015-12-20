/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ardevcenter.drawmanager.lnb;

import java.io.File;
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
public class LnbDrawAdapterIT {
    
    public LnbDrawAdapterIT() {
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
     * Test of getLnbDrawData method, of class LnbDrawAdapter.
     */
    @Test
    public void integrationTest_GetLnbDrawData_FirstPrize_2015_10_30() throws Exception {
        System.out.println("getLnbDrawData");
        String lnbUrl ="http://www.lnb.gob.pa/numerosjugados.php?tiposorteo=T&ano=2015&meses=10&Consultar=Buscar";        
        LnbDrawAdapter instance = new LnbDrawAdapter(lnbUrl);        
        String expResult = "8791";
        List<LnbDrawRawEntity> result = instance.getLnbDrawData();
        assertEquals("Integration Test: First Price is wrong for this date. ",expResult, result.get(0).getFirstNumber());
        
    }
    
}
