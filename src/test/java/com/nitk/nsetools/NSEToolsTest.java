package com.nitk.nsetools;

import com.nitk.nsetools.domain.ListOfIndices;
import org.junit.*;

import com.nitk.nsetools.domain.StockQuote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    
    @Test
    public void checkGetQuoteFunctionForInvalidQuote(){
        try {
            StockQuote stockQuote = nse.getQuote("INDEX Gothilla");
        }catch(Exception e) {
            assertEquals("Symbol - INDEX Gothilla - is invalid",e.getMessage());
        }
    }
    
    @Test
    public void checkGetQuoteFunctionForValidQuote() {
        try{
            StockQuote stockQuote = nse.getQuote("INFY");
            assertTrue(stockQuote.getCompanyName().equalsIgnoreCase("Infosys Limited"));
            assertTrue(stockQuote.getSeries().equalsIgnoreCase("EQ"));
            assertTrue(stockQuote.getLastPrice()!=null);
            assertTrue(stockQuote.getPriceBand()==null);
            assertTrue(stockQuote.getIsinCode().equalsIgnoreCase("INE009A01021"));
            assertTrue(stockQuote.getCm_adj_low_dt().getDate()==22);
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
            assertTrue(dateFormat.format(stockQuote.getCm_adj_low_dt()).equals("22-Aug-17"));
        }catch(Exception e) {
            assertTrue(false);
        }      
    }
    
    @Test
    public void checkTopGainersFunction() throws Exception {
        try {
            List<StockQuote> topGainersList = nse.getTopGainers();
            assertTrue(true);
        }catch(Exception e) {
            assertTrue(false);
        }
    }
    
    
    @Test
    public void checkTopLosersFunction() throws Exception {
        try {
            List<StockQuote> topLosersList = nse.getTopLosers();
            assertTrue(true);
        }catch(Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void checkIndices() throws Exception {
        try {
            ListOfIndices listOfIndices = nse.getIndices();
            assertTrue(true);
        }catch(Exception e) {
            assertTrue(false);
        }
    }
}
