package com.nitk.nsetools;

import org.junit.*;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.List;

public class NSEToolsTest {
    
    NSETools nse;
    
    @Before
    public void createObject() {
        nse = new NSETools();
    }
        
    @Test
    public void checkGetStockCodes() throws Exception {
        assertTrue(nse.getStockCodes().get("ADVENZYMES").equals("Advanced Enzyme Technologies Limited"));
        assertTrue(nse.getStockCodes().get("ZUARI").equals("Zuari Agro Chemicals Limited"));
    }
    
    @Test
    public void checkStockCode() throws Exception {
        assertTrue(nse.isValidCode("ZUARI"));
        assertTrue(!nse.isValidCode("gothillaindustries"));
    }
    
    @Test
    public void checkIndexList() throws Exception{
        assertTrue(nse.getIndexList().contains("NIFTY 50"));
        assertTrue(nse.getIndexList().contains("NIFTY GS COMPSITE"));
    }
    
    @Test
    public void checkIsValidIndex() throws Exception{
        assertTrue(nse.isValidIndex("Nifty 50"));
        assertTrue(!nse.isValidIndex("INDEX GOTHILLA"));
    }
}
