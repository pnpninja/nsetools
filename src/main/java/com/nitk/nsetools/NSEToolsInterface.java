package com.nitk.nsetools;
import java.util.HashMap;
import java.util.List;

public interface NSEToolsInterface {
    public HashMap<String,String> getStockCodes() throws Exception;  
    public boolean isValidQuote(String stockCode) throws Exception;
    public List<String> getIndexList() throws Exception;
}
